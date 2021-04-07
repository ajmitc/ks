package ks.common.server.protocol;

import ks.common.server.BattlefieldList;

public class BattlefieldListResponse extends ResponseMessage<BattlefieldList> {
    public BattlefieldListResponse(BattlefieldList battlefieldList){
        super(battlefieldList);
    }
}
