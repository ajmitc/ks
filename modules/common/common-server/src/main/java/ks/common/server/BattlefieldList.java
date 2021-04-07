package ks.common.server;

import ks.common.model.terrain.Battlefield;

import java.util.ArrayList;
import java.util.List;

public class BattlefieldList {
    private List<Battlefield> battlefields = new ArrayList<>();

    public BattlefieldList(){}

    public List<Battlefield> getBattlefields() {
        return battlefields;
    }

    public void setBattlefields(List<Battlefield> battlefields) {
        this.battlefields = battlefields;
    }
}
