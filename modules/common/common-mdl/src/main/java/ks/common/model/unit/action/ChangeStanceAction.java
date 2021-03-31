package ks.common.model.unit.action;

import ks.common.model.unit.UnitStance;

public class ChangeStanceAction extends UnitAction{
    // New stance to assign to unit
    private UnitStance stance;

    public ChangeStanceAction(){
        super(UnitActionType.CHANGE_STANCE);
    }

    public UnitStance getStance() {
        return stance;
    }

    public void setStance(UnitStance stance) {
        this.stance = stance;
    }
}
