package ks.common.model.message;

public enum UnitMessageStatus {
    PENDING,  // Order submitted by General, but not yet sent by Umpire to destination
    EN_ROUTE, // Order/Report sent by Umpire
    DELIVERED // Order/Report reached destination
}
