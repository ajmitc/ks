package ks.common.model.unit;

public enum UnitSize {
    // Infantry
    HALF_BATTALION,   // 450 men
    COMPANY,          // There are 2 companies in a Half-Battalion, so 225 men
    ZUG,              // There are 2 Zugs in a Company, so 112-113 men.  I think skirmishers are typically by the Zug

    // Cavalry
    SQUADRON,

    // Artillery
    BATTERY
}
