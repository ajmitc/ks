package ks.common.server;

import ks.common.model.game.Game;

import java.util.ArrayList;
import java.util.List;

public class GameList {
    private List<Game> games = new ArrayList<>();

    public GameList(){}

    public List<Game> getGames() {
        return games;
    }

    public void setGames(List<Game> games) {
        this.games = games;
    }
}
