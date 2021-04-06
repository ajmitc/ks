package ks.common.model.game;

import ks.common.model.force.Force;
import ks.common.model.message.MessageRecipient;
import ks.common.model.message.UnitMessage;
import ks.common.model.side.Side;
import ks.common.model.terrain.Battlefield;
import ks.common.model.unit.Messenger;
import ks.common.model.unit.Unit;
import ks.common.model.user.User;
import ks.common.model.user.UserRole;

import java.util.*;
import java.util.stream.Collectors;

public class Game {
    // Unique ID for this game
    private String id;

    // Current game status
    private GameStatus status = GameStatus.PENDING;

    // Display name for this game
    private String name;

    // Description of game shared with all players
    private String commonDescription;

    // Descriptions shared with each side
    private Map<String, String> sideDescriptions = new HashMap<>();

    // Battlefield
    private Battlefield battlefield;

    // List of all sides involved
    private List<Side> sides = new ArrayList<>();

    // List of all forces involved
    private List<Force> forces = new ArrayList<>();

    // List of all Messengers currently delivering messages
    private List<Messenger> messengers = new ArrayList<>();

    // List of all users playing this game
    private List<User> users = new ArrayList<>();

    // Messages not yet delivered
    private List<UnitMessage> activeMessages = new ArrayList<>();

    // Messages that have been delivered
    private List<UnitMessage> deliveredMessages = new ArrayList<>();

    private GameSettings settings = new GameSettings();

    public Game(){
    }

    public Game(String name){
        super();
        this.id = "" + UUID.randomUUID();
        this.name = name;
    }

    /**
     * Return a list of UserRoles that are currently not filled
     * @return
     */
    public List<OpenRoleDescription> getOpenRoles(){
        // Must have 1+ umpires, generals >= # sides
        long numUmpires = users.stream().filter(user -> user.getRole() == UserRole.UMPIRE).count();
        long numGenerals = users.stream().filter(user -> user.getRole() == UserRole.GENERAL).count();
        List<OpenRoleDescription> openRoles = new ArrayList<>();
        if (numUmpires == 0){
            openRoles.add(new OpenRoleDescription(UserRole.UMPIRE, null));
        }
        if (numGenerals < sides.size()){
            // Determine which sides don't have a General
            Set<Side> sidesWithNoGeneral = sides.stream().filter(side -> side.getUserIds().isEmpty()).collect(Collectors.toSet());
            // Add open roles
            for (Side sideWithNoGeneral: sidesWithNoGeneral){
                openRoles.add(new OpenRoleDescription(UserRole.GENERAL, sideWithNoGeneral));
            }
        }
        return openRoles;
    }

    public Force findForce(String id){
        for (Force force: forces){
            if (force.getId().equals(id))
                return force;
        }
        return null;
    }

    public Unit findUnit(String id){
        for (Force force: forces){
            for (Unit unit: force.getUnits()){
                if (unit.getId().equals(id)) {
                    return unit;
                }
            }
        }
        return null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonDescription() {
        return commonDescription;
    }

    public void setCommonDescription(String commonDescription) {
        this.commonDescription = commonDescription;
    }

    public Map<String, String> getSideDescriptions() {
        return sideDescriptions;
    }

    public void setSideDescriptions(Map<String, String> sideDescriptions) {
        this.sideDescriptions = sideDescriptions;
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

    /**
     * Get Side by name
     * @param name
     * @return
     */
    public Side getSideByName(String name){
        for (Side side: sides) {
            if (side.getName().equalsIgnoreCase(name))
                return side;
        }
        return null;
    }

    /**
     * Get Side controlled by User
     * @param userId
     * @return
     */
    public Side getUsersSide(String userId){
        for (Side side: sides) {
            if (side.getUserIds().contains(userId))
                return side;
        }
        return null;
    }

    public List<Force> getForces() {
        return forces;
    }

    public void setForces(List<Force> forces) {
        this.forces = forces;
    }

    public List<Messenger> getMessengers() {
        return messengers;
    }

    public void setMessengers(List<Messenger> messengers) {
        this.messengers = messengers;
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

    public List<UnitMessage> getActiveMessages() {
        return activeMessages;
    }

    public List<UnitMessage> getDeliveredMessages() {
        return deliveredMessages;
    }

    public MessageRecipient findMessageRecipient(String recipientId){
        Unit unit = findUnit(recipientId);
        if (unit != null)
            return unit;
        Force force = findForce(recipientId);
        if (force != null)
            return force;
        return null;
    }
}
