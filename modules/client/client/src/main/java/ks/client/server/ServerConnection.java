package ks.client.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    public GameListResponse getGameList(){
        String response = restConnection.get("/game-list");
        GameListResponse gameListResponse = null;
        try {
            gameListResponse = objectMapper.readValue(response, new TypeReference<GameListResponse>() {});
        }
        catch (Exception e){
            logger.error("Unable to unpack game list", e);
        }
        return gameListResponse;
    }

    public boolean isConnected(){
        return restConnection.isConnected();
    }
}
