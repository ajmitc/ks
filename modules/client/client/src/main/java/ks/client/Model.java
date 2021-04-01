package ks.client;

import ks.client.server.ServerConnection;
import ks.common.server.GameList;

public class Model {
    private ServerConnection serverConnection = new ServerConnection();
    private GameList availableGames;

    public Model(){

    }

    public ServerConnection getServerConnection() {
        return serverConnection;
    }

    public GameList getAvailableGames() {
        return availableGames;
    }

    public void setAvailableGames(GameList availableGames) {
        this.availableGames = availableGames;
    }
}
