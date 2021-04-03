package ks.common.model.game;

import ks.common.model.side.Side;
import ks.common.model.user.UserRole;

public class OpenRoleDescription {
    private UserRole role;
    private Side side;

    public OpenRoleDescription(UserRole role, Side side){
        this.role = role;
        this.side = side;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public Side getSide() {
        return side;
    }

    public void setSide(Side side) {
        this.side = side;
    }

    public String toString(){
        if (role == UserRole.GENERAL){
            return "GENERAL of " + side.getName();
        }
        return role.toString();
    }
}
