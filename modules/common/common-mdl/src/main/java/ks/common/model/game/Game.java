package ks.common.model.game;

import ks.common.model.force.Force;
import ks.common.model.side.Side;
import ks.common.model.terrain.Battlefield;
import ks.common.model.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    // Unique ID for this game
    private String id;

    // Display name for this game
    private String name;

    // Battlefield
    private Battlefield battlefield;

    // List of all sides involved
    private List<Side> sides = new ArrayList<>();

    // List of all forces involved
    private List<Force> forces = new ArrayList<>();

    // List of all users playing this game
    private List<User> users = new ArrayList<>();

    private GameSettings settings = new GameSettings();

    public Game(){
    }

    public Game(String name){
        super();
        this.id = "" + UUID.randomUUID();
        this.name = name;
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

    public Battlefield getBattlefield() {
        return battlefield;
    }

    public void setBattlefield(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public List<Side> getSides() {
        return sides;
    }

    public void setSides(List<Side> sides) {
        this.sides = sides;
    }

    public List<Force> getForces() {
        return forces;
    }

    public void setForces(List<Force> forces) {
        this.forces = forces;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public GameSettings getSettings() {
        return settings;
    }

    public void setSettings(GameSettings settings) {
        this.settings = settings;
    }
}
