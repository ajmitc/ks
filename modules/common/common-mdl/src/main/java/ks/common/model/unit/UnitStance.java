package ks.common.model.unit;

public enum UnitStance {
    HOLD_GROUND,  // Don't attack at all, even if enemy within range, and don't retreat (TODO is this needed?)
    SCOUT,        // Don't attack at all, retreat if attacked by enemy
    DEFENSIVE,    // Attack if enemy within range, don't follow enemy if they retreat
    OFFENSIVE,    // Attack if enemy within sight, follow enemy if they retreat
}
