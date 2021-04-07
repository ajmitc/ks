package ks.client.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import ks.common.model.game.Game;
import ks.common.server.protocol.GameListResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class knows how to talk to the server
 */
public class ServerConnection {
    private static Logger logger = LoggerFactory.getLogger(ServerConnection.class);

    private RestConnection restConnection;

    private ObjectMapper objectMapper = new ObjectMapper();

    public ServerConnection(){

    }

    public boolean connect(String host, int port){
        restConnection = new RestConnection();
        restConnection.setHostname(host);
        restConnection.setPort(port);
        return restConnection.connect();
    }

    public GameListResponse getGameList() throws Exception{
        RestConnection.RestResponse response = restConnection.get("/game-list");
        if (response.getStatusCode() != 200){
            throw new RuntimeException("Failed to get game list (status " + response.getStatusCode() + "): " + response.getBody());
        }
        GameListResponse gameListResponse = null;
        try {
            gameListResponse = objectMapper.readValue(response.getBody(), new TypeReference<GameListResponse>() {});
        }
        catch (Exception e){
            logger.error("Unable to unpack game list", e);
            throw e;
        }
        return gameListResponse;
    }

    public void saveGame(Game game){
        RestConnection.RestResponse response = restConnection.post("/save-game", game);
        if (response.getStatusCode() != 200)
            throw new RuntimeException("Failed to save game (status " + response.getStatusCode() + "): " + response.getBody());
    }

    public boolean isConnected(){
        return restConnection.isConnected();
    }
}
