package ks.common.model.user;

import java.util.UUID;

/**
 * Defines one player that controls all or part of a Side
 */
public class User {
    // Unique ID for user
    private String id;

    // Display name
    private String displayName;

    // General, Umpire, or Observer
    private UserRole role;

    public User(){

    }

    public User(String name, UserRole role){
        this.id = "" + UUID.randomUUID();
        this.displayName = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
