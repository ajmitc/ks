package ks.common.model.unit.util;

public class CloseCombatResult {
    private CloseCombatResultEnum closeCombatResultEnum;
    private int casualtyPoints;

    public CloseCombatResult(CloseCombatResultEnum closeCombatResultEnum, int casualtyPoints){
        this.closeCombatResultEnum = closeCombatResultEnum;
        this.casualtyPoints = casualtyPoints;
    }

    public CloseCombatResultEnum getCloseCombatResultEnum() {
        return closeCombatResultEnum;
    }

    public int getCasualtyPoints() {
        return casualtyPoints;
    }
}
