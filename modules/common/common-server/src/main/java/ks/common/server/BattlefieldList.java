package ks.common.server;

import java.util.ArrayList;
import java.util.List;

public class BattlefieldList {
    private List<BattlefieldInfo> battlefields = new ArrayList<>();

    public BattlefieldList(){}

    public List<BattlefieldInfo> getBattlefields() {
        return battlefields;
    }

    public void setBattlefields(List<BattlefieldInfo> battlefields) {
        this.battlefields = battlefields;
    }
}
