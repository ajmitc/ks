package ks.common.model.unit.action;

/**
 * Defines the current order a Unit/Force is executing
 */
public abstract class UnitAction {
    // What action is this unit currently taking
    protected UnitActionType type;

    public UnitAction(){

    }

    public UnitAction(UnitActionType type){
        this.type = type;
    }

    public void setType(UnitActionType type) {
        this.type = type;
    }

    public UnitActionType getType() {
        return type;
    }
}
