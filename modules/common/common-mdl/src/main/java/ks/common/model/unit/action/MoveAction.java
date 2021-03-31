package ks.common.model.unit.action;

public class MoveAction extends UnitAction{
    private int destX, destY;
    private MoveSpeed speed = MoveSpeed.NORMAL;

    public MoveAction(){
        super(UnitActionType.MOVE);
    }

    public int getDestX() {
        return destX;
    }

    public void setDestX(int destX) {
        this.destX = destX;
    }

    public int getDestY() {
        return destY;
    }

    public void setDestY(int destY) {
        this.destY = destY;
    }

    public MoveSpeed getSpeed() {
        return speed;
    }

    public void setSpeed(MoveSpeed speed) {
        this.speed = speed;
    }
}
