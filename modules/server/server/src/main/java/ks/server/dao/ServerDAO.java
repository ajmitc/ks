package ks.server.dao;

import ks.common.model.game.Game;
import ks.common.server.protocol.BattlefieldListResponse;
import ks.common.server.protocol.GameListResponse;

public interface ServerDAO {
    GameListResponse getGameList();

    BattlefieldListResponse getBattlefieldList();

    boolean saveGame(Game game);
}
