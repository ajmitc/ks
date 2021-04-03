package ks.client;

import ks.client.server.ServerConnection;
import ks.common.model.game.Game;
import ks.common.model.user.User;
import ks.common.server.GameList;

public class Model {
    private ServerConnection serverConnection = new ServerConnection();
    private GameList availableGames;
    private User me;

    private Game currentGame;

    public Model(){
        me = new User("ajmitc");
    }

    public ServerConnection getServerConnection() {
        return serverConnection;
    }

    public GameList getAvailableGames() {
        return availableGames;
    }

    public void setAvailableGames(GameList availableGames) {
        this.availableGames = availableGames;
    }

    public User getMe() {
        return me;
    }

    public void setMe(User me) {
        this.me = me;
    }

    public Game getCurrentGame() {
        return currentGame;
    }

    public void setCurrentGame(Game currentGame) {
        this.currentGame = currentGame;
    }
}
