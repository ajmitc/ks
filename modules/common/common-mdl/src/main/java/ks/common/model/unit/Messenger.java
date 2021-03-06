package ks.common.model.unit;

import ks.common.model.message.UnitMessage;

import java.util.UUID;

public class Messenger extends Unit{
    protected UnitMessage message;

    public Messenger(){
        super();
    }

    public Messenger(String sideId, String forceId, String name){
        super("" + UUID.randomUUID(), sideId, forceId, name, UnitType.MESSENGER);
    }

    public UnitMessage getMessage() {
        return message;
    }

    public void setMessage(UnitMessage message) {
        this.message = message;
    }
}
