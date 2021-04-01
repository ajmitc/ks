package ks.server.dao;

import ks.common.server.GameList;
import ks.common.server.protocol.GameListResponse;

public class InMemoryStore implements ServerDAO {
    private GameList gameList = new GameList();

    public GameListResponse getGameList(){
        return new GameListResponse(gameList);
    }
}
