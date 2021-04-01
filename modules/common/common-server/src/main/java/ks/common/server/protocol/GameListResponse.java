package ks.common.server.protocol;

import ks.common.server.GameList;

public class GameListResponse extends ResponseMessage<GameList> {
    public GameListResponse(GameList gameList){
        super(gameList);
    }
}
