package ks.client;

import ks.client.view.View;
import ks.common.model.game.Game;
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
                // TODO Stop threads (ie. server)
            }
        });

        this.view.getMainMenuPanel().getBtnNewLocalGame().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

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
                    GameListResponse gameListResponse = model.getServerConnection().getGameList();
                    if (gameListResponse.getStatusCode() == ResponseMessage.OK){
                        // Populate game list in lobby
                        model.setAvailableGames(gameListResponse.getObject());
                        view.getLobbyPanel().updateGameList();
                    }
                    else {
                        logger.error("Unable to get game list: " + gameListResponse);
                    }
                }
            }
        });

        this.view.getLobbyPanel().getGameListTableModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent tableModelEvent) {
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
    }
}
