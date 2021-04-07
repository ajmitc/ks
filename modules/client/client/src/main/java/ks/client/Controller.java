package ks.client;

import ks.client.server.LocalServerProcess;
import ks.client.view.GameListTableModel;
import ks.client.view.View;
import ks.client.view.util.ViewUtil;
import ks.common.model.force.Force;
import ks.common.model.game.Game;
import ks.common.model.game.GameStatus;
import ks.common.model.game.OpenRoleDescription;
import ks.common.model.message.UnitMessage;
import ks.common.model.message.UnitMessageStatus;
import ks.common.model.message.UnitMessageType;
import ks.common.model.side.Side;
import ks.common.model.terrain.Battlefield;
import ks.common.model.user.User;
import ks.common.model.user.UserRole;
import ks.common.server.protocol.GameListResponse;
import ks.common.server.protocol.ResponseMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class Controller {
    private static Logger logger = LoggerFactory.getLogger(Controller.class);

    private Model model;
    private View view;

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;

        this.view.getFrame().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                try {
                    LocalServerProcess.stop();
                }
                catch (Exception ex){
                    logger.error("Failed to stop local server process", ex);
                }
            }
        });

        this.view.getMainMenuPanel().getBtnNewLocalGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.showCreateLocalGame();
            }
        });

        this.view.getGameCreatorPanel().getBtnCreate().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                startLocalGame();
            }
        });

        this.view.getGameCreatorPanel().getBtnCancel().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.showMainMenu();
            }
        });

        this.view.getMainMenuPanel().getBtnConnectToRemoteServer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                view.showLobby();
            }
        });

        this.view.getLobbyPanel().getBtnConnectToServer().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String hostname = view.getLobbyPanel().getTfServerHostname().getText();
                int port        = Integer.decode(view.getLobbyPanel().getTfServerPort().getText());
                // Attempt to connect to server and update title and Connect button text
                model.getServerConnection().connect(hostname, port);
                view.getLobbyPanel().updateServerConnectedStatus();

                if (model.getServerConnection().isConnected()){
                    try {
                        GameListResponse gameListResponse = model.getServerConnection().getGameList();
                        if (gameListResponse.getStatusCode() == ResponseMessage.OK) {
                            // Populate game list in lobby
                            model.setAvailableGames(gameListResponse.getObject());
                            view.getLobbyPanel().updateGameList();
                        } else {
                            logger.error("Unable to get game list: " + gameListResponse);
                        }
                    }
                    catch (Exception e){
                        logger.error("Unable to get game list: " + e);
                    }
                }
            }
        });

        this.view.getLobbyPanel().getGameListTableModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tableModelEvent) {
                int row = tableModelEvent.getFirstRow();
                int column = tableModelEvent.getColumn();
                GameListTableModel model = (GameListTableModel) tableModelEvent.getSource();
                String columnName = model.getColumnName(column);
                Object data = model.getValueAt(row, column);

                // Do something when the game list changes
            }
        });

        this.view.getLobbyPanel().getTblGameList().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                // Do something when user clicks on game in game list
                int row = view.getLobbyPanel().getTblGameList().getSelectedRow();
                Game game = view.getLobbyPanel().getGameListTableModel().getRowAt(row);
                view.getLobbyPanel().getGameDetailsPanel().setGame(game);
                view.getLobbyPanel().getGameDetailsPanel().refresh();
            }
        });

        this.view.getLobbyPanel().getBtnJoinGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                joinGame();
            }
        });
    }

    /**
     * Create and start the local game
     */
    public void startLocalGame() {
        // Run server in process
        try {
            LocalServerProcess.start();
        }
        catch (IOException ioe){
            logger.error("Failed to start local server process", ioe);
            return;
        }

        // Create Game object
        User userA = new User("General A", UserRole.GENERAL);
        User userB = new User("General B", UserRole.GENERAL);

        Game game = new Game(view.getGameCreatorPanel().getTfGameName().getText());
        game.getUsers().add(model.getMe());
        game.getUsers().add(userA);
        game.getUsers().add(userB);

        // TODO Get from GameCreatorPanel
        game.setBattlefield(new Battlefield(100, 100));

        game.setCommonDescription(view.getGameCreatorPanel().getTaCommonDescription().getText());

        Side sideA = new Side("" + UUID.randomUUID(), view.getGameCreatorPanel().getTfSideAName().getText(), ViewUtil.toColor("" + view.getGameCreatorPanel().getCbSideAColor().getSelectedItem()));
        Side sideB = new Side("" + UUID.randomUUID(), view.getGameCreatorPanel().getTfSideBName().getText(), ViewUtil.toColor("" + view.getGameCreatorPanel().getCbSideBColor().getSelectedItem()));
        game.getSides().add(sideA);
        game.getSides().add(sideB);

        Force forceA = new Force("" + UUID.randomUUID(), sideA.getId(), userA.getId());
        Force forceB = new Force("" + UUID.randomUUID(), sideB.getId(), userB.getId());
        game.getForces().add(forceA);
        game.getForces().add(forceB);

        // TODO Add units from GameCreatorPanel

        UnitMessage message = new UnitMessage(UnitMessageType.ORDER, userA.getId(), forceA.getId(), "New Order", "That is an order!");
        message.setStatus(UnitMessageStatus.PENDING);
        game.getActiveMessages().add(message);

        message = new UnitMessage(UnitMessageType.ORDER, userB.getId(), forceB.getId(), "Delivered Order", "Order has been delivered!");
        message.setDelivered();
        game.getActiveMessages().add(message);

        // TODO Send game to server

        // Join game as Umpire
        UserRole role = UserRole.UMPIRE;

        model.setCurrentGame(game);
        view.getGamePanel().init();
        view.getGamePanel().showPanel(role);
        view.showGame();
        view.getGamePanel().refresh();
    }

    /**
     * User clicked to Join a Game
     */
    public void joinGame(){
        Game game = view.getLobbyPanel().getGameDetailsPanel().getGame();

        if (game.getStatus() == GameStatus.ENDED){
            ViewUtil.popupNotify("Game has ended, cannot join");
            return;
        }

        // check if user already belongs to this game
        boolean belongsToGame = false;
        for (User user: game.getUsers()){
            if (user.getId().equals(model.getMe().getId())){
                belongsToGame = true;
                break;
            }
        }

        if (!belongsToGame) {
            // If game is in-progress, join as observer
            if (game.getStatus() == GameStatus.IN_PROGRESS) {
                game.getUsers().add(new User(model.getMe(), UserRole.OBSERVER));
            }
            else {
                // If game is NOT in-progress (pending), ask what role they want
                List<OpenRoleDescription> openRoleDescriptions = game.getOpenRoles();
                if (openRoleDescriptions.size() == 1){
                    // Ask user if they want to join this role
                    if (ViewUtil.popupConfirm("Join Game", "Join this game as " + openRoleDescriptions.get(0).toString())){
                        game.getUsers().add(new User(model.getMe(), openRoleDescriptions.get(0).getRole()));
                    }
                    else {
                        return;
                    }
                }
                else {
                    // Ask which role to join as
                    OpenRoleDescription selected = (OpenRoleDescription) ViewUtil.popupDropdown("Join Game", "Choose Role", openRoleDescriptions.toArray());
                    if (selected == null)
                        return;
                    game.getUsers().add(new User(model.getMe(), selected.getRole()));
                    if (selected.getRole() == UserRole.GENERAL){
                        // Assign user as general
                        selected.getSide().getUserIds().add(model.getMe().getId());
                        for (Force force: game.getForces()){
                            if (force.getSideId().equals(selected.getSide().getId()) && force.getUserId() == null){
                                force.setUserId(model.getMe().getId());
                            }
                        }
                    }
                }
            }

            // Save the game
            model.getServerConnection().saveGame(game);
        }
        // open the gamepanel in whatever role they currently have
        model.setCurrentGame(game);
        UserRole role = game.getUsers().stream().filter(user -> user.getId().equals(model.getMe().getId())).map(user -> user.getRole()).findFirst().get();
        view.getGamePanel().init();
        view.getGamePanel().showPanel(role);
        view.showGame();
        view.getGamePanel().refresh();
    }
}
