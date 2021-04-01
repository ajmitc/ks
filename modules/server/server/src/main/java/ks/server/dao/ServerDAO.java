package ks.server.dao;

import ks.common.server.protocol.GameListResponse;

public interface ServerDAO {
    GameListResponse getGameList();
}
