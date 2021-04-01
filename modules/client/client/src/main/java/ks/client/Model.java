package ks.client;

import ks.common.server.GameList;

public class Model {
    private GameList availableGames;

    public Model(){

    }

    public GameList getAvailableGames() {
        return availableGames;
    }

    public void setAvailableGames(GameList availableGames) {
        this.availableGames = availableGames;
    }
}
