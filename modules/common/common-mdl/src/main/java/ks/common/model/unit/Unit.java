package ks.common.model.unit;

import ks.common.model.message.MessageRecipient;
import ks.common.model.unit.action.UnitAction;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Represents a single unit on the map
 */
public class Unit implements MessageRecipient {
    // Unique ID for this unit
    private String id;

    // ID of Force which this unit is assigned to
    private String forceId;

    // Side for which this unit is loyal
    private String sideId;

    // Name of unit
    private String name;

    // Type of unit
    private UnitType unitType;

    // Unit location on map
    private int x;
    private int y;

    // Unit's status (Ready, Routed, Defeated)
    private UnitStatus status;

    // Unit's stance (Hold, Defensive, Offensive)
    private UnitStance stance;

    // How far can this unit see?
    private int visibilityDistanceMeters;

    // Minimum distance to enemy unit that this unit can attack
    private int minAttackRangeMeters;

    // Maximum distance to enemy unit that this unit can attack
    private int maxAttackRangeMeters;

    // Speed of this unit on flat clear ground (should be modified based on terrain)
    private int speedMetersPerSecond;

    // List of actions this unit is attempting to carry out
    // The action at index 0 is the unit's current action (ie. move). Once complete, that action will be popped and
    // the unit will begin executing the next action, if any.
    private List<UnitAction> actions = new ArrayList<>();

    public Unit(){

    }

    public Unit(String id, String sideId, String forceId, String name, UnitType unitType){
        this.id = id;
        this.sideId = sideId;
        this.forceId = forceId;
        this.id = "" + UUID.randomUUID();
        this.name = name;
        this.unitType = unitType;
        this.status = UnitStatus.READY;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getForceId() {
        return forceId;
    }

    public void setForceId(String forceId) {
        this.forceId = forceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(UnitType unitType) {
        this.unitType = unitType;
    }

    public String getSideId() {
        return sideId;
    }

    public void setSideId(String sideId) {
        this.sideId = sideId;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public UnitStatus getStatus() {
        return status;
    }

    public void setStatus(UnitStatus status) {
        this.status = status;
    }

    public UnitStance getStance() {
        return stance;
    }

    public void setStance(UnitStance stance) {
        this.stance = stance;
    }

    public int getVisibilityDistanceMeters() {
        return visibilityDistanceMeters;
    }

    public void setVisibilityDistanceMeters(int visibilityDistanceMeters) {
        this.visibilityDistanceMeters = visibilityDistanceMeters;
    }

    public int getMinAttackRangeMeters() {
        return minAttackRangeMeters;
    }

    public void setMinAttackRangeMeters(int minAttackRangeMeters) {
        this.minAttackRangeMeters = minAttackRangeMeters;
    }

    public int getMaxAttackRangeMeters() {
        return maxAttackRangeMeters;
    }

    public void setMaxAttackRangeMeters(int maxAttackRangeMeters) {
        this.maxAttackRangeMeters = maxAttackRangeMeters;
    }

    public int getSpeedMetersPerSecond() {
        return speedMetersPerSecond;
    }

    public void setSpeedMetersPerSecond(int speedMetersPerSecond) {
        this.speedMetersPerSecond = speedMetersPerSecond;
    }

    public List<UnitAction> getActions() {
        return actions;
    }

    public void setActions(List<UnitAction> actions) {
        this.actions = actions;
    }
}
