package ks.client.server;

import ks.common.server.GameList;

/**
 * This class knows how to talk to the server
 */
public class ServerConnection {
    private RestConnection restConnection;

    public ServerConnection(){

    }

    public boolean connect(String host, int port){
        restConnection = new RestConnection();
        restConnection.setHostname(host);
        restConnection.setPort(port);
        return restConnection.connect();
    }

    public GameList getGameList(){
        String response = restConnection.get("/gamelist");
        // TODO Unpack response
        return null;
    }
}
