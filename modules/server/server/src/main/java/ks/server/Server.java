package ks.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;
import io.javalin.http.ForbiddenResponse;
import ks.common.model.game.Game;
import ks.common.server.GameList;
import ks.common.server.protocol.GameListResponse;
import ks.server.dao.InMemoryStore;
import ks.server.dao.ServerDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.javalin.apibuilder.ApiBuilder.path;

/**
 * Start a Javalin server
 * https://javalin.io/documentation#context
 */
public class Server {
    private static Logger logger = LoggerFactory.getLogger(Server.class);

    public static void main(String[] args) {
        int port = 7000;

        for (String arg: args){
            try {
                port = Integer.decode(arg);
            }
            catch (Exception e){
                logger.warn("Invalid port value");
            }
        }

        ServerDAO serverDAO = new InMemoryStore();

        ObjectMapper objectMapper = new ObjectMapper();

        Javalin app = Javalin.create(javalinConfig -> {
            //javalinConfig.addStaticFiles("public");
            javalinConfig.requestLogger((ctx, ms) -> {
                logger.info(ctx.method() + " " + ctx.url() + " " + ms + "milliseconds");
            });
        }).start(port);

        // Runs before EVERY request
        app.before(ctx -> {

        });

        // Runs before request to "/"
        app.before("/", ctx -> {

        });

        // Endpoint handlers matched in order defined
        app.get("/", ctx -> {
            ctx.json("Hello World");
            ctx.status(200);
        });

        app.get("/alive", ctx -> {
            ctx.status(200);
        });

        app.get("/game-list", ctx -> {
            GameListResponse gameListResponse = serverDAO.getGameList();
            ctx.json(gameListResponse.getObject());
            ctx.status(gameListResponse.getStatusCode());
        });

        app.post("/save-game", ctx -> {
            Game game = objectMapper.readValue(ctx.body(), Game.class);
            boolean saved = serverDAO.saveGame(game);
            ctx.status(saved? 200: 500);
        });

        /*
        app.get("/hello/:name", ctx -> {
            ctx.result("Hello: " + ctx.pathParam("name"));
        });
         */

        /*
        app.routes(() -> {
            path("users", () -> {
                get(UserController::getAllUsers);
                post(UserController::createUser);
                path(":id", () -> {
                    get(UserController::getUser);
                    patch(UserController::updateUser);
                    delete(UserController::deleteUser);
                });
                ws("events", userController::webSocketEvents);
            });
        });
         */

        //app.post("/", ctx -> {throw new ForbiddenResponse("Off limits!");});

        //app.error(404, ViewUtil.notFound);

        // Websockets
        /*
        app.ws("/websocket/:path", ws -> {
            ws.onConnect(ctx -> System.out.println("Connected"));
            // ws.onConnect(WsConnectContext)
            // ws.onError(WsErrorContext)
            // ws.onClose(WsCloseContext)
            // ws.onMessage(WsMessageContext)
            // ws.onBinaryMessage(WsBinaryMessageContext)
        });
         */

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            app.stop();
        }));

        app.events(event -> {
            event.serverStopping(() -> { /* shutdown handler */ });
            event.serverStopped(() -> { /* shutdown handler */ });
        });
    }
}
