package ks.common.model.side;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Defines one side of the battle.  All units on the same side are considered friendly to each other.
 */
public class Side {
    // Unique ID of side
    private String id;

    // Name of side
    private String name;

    // Color of unit blocks
    private Color color;

    // User IDs of players controlling this side
    // Each player may control all or a subset of the units in the side
    private List<String> userIds = new ArrayList<String>();

    public Side(){

    }

    public Side(String id, String name, Color color){
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public Side(String name, Color color){
        this("" + UUID.randomUUID(), name, color);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }
}
