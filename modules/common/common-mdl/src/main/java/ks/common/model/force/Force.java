package ks.common.model.force;

import ks.common.model.unit.Unit;

import java.util.ArrayList;
import java.util.List;

/**
 * A force is a collection of units assigned to one side of the battle and controlled by one player/user.
 *
 * There may be multiple Forces on a Side, with each Force controlled by a different user.  Furthermore, a user
 * may break up his force into multiple sub-forces to command groups of units.
 */
public class Force {
    // Unique ID for this force
    private String id;

    // Side this force belongs to
    private String sideId;

    // User controlling this force
    private String userId;

    // Units in this force
    private List<Unit> units = new ArrayList<Unit>();

    public Force(){

    }

    public Force(String id, String sideId, String userId){
        this.id = id;
        this.sideId = sideId;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSideId() {
        return sideId;
    }

    public void setSideId(String sideId) {
        this.sideId = sideId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
