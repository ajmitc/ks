package ks.server.dao;

import ks.common.model.game.Game;
import ks.common.server.protocol.GameListResponse;

public interface ServerDAO {
    GameListResponse getGameList();

    boolean saveGame(Game game);
}
