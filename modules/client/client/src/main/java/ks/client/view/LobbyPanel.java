package ks.client.view;

import ks.client.Model;
import ks.common.model.game.Game;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class LobbyPanel extends JPanel {
    private Model model;
    private View view;

    private JTextField tfServerHostname;
    private JTextField tfServerPort;
    private JButton btnConnectToServer;
    private JPanel serverConnectPanel;

    private GameListTableModel gameListTableModel;
    private JTable tblGameList;

    private GameDetailsPanel gameDetailsPanel;

    public LobbyPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        tfServerHostname   = new JTextField("localhost");
        tfServerPort       = new JTextField("7000");
        btnConnectToServer = new JButton("Connect");

        serverConnectPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        serverConnectPanel.setBorder(BorderFactory.createTitledBorder("Server - Not Connected"));
        serverConnectPanel.add(tfServerHostname);
        serverConnectPanel.add(tfServerPort);
        serverConnectPanel.add(btnConnectToServer);

        gameListTableModel = new GameListTableModel();
        tblGameList = new JTable(gameListTableModel);
        tblGameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(serverConnectPanel);
        leftPanel.add(new JScrollPane(tblGameList));

        gameDetailsPanel = new GameDetailsPanel();

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(gameDetailsPanel, BorderLayout.CENTER);
    }

    public JButton getBtnConnectToServer() {
        return btnConnectToServer;
    }

    public JTextField getTfServerHostname() {
        return tfServerHostname;
    }

    public JTextField getTfServerPort() {
        return tfServerPort;
    }

    public GameListTableModel getGameListTableModel() {
        return gameListTableModel;
    }

    public JTable getTblGameList() {
        return tblGameList;
    }

    public GameDetailsPanel getGameDetailsPanel() {
        return gameDetailsPanel;
    }

    public void updateServerConnectedStatus(){
        ((TitledBorder) serverConnectPanel.getBorder()).setTitle("Server - " + (model.getServerConnection().isConnected()? "Connected": "Not connected"));
        btnConnectToServer.setText(model.getServerConnection().isConnected()? "Disconnect": "Connect");
    }

    public void updateGameList(){
        gameListTableModel.setGameList(model.getAvailableGames());
        gameListTableModel.fireTableDataChanged();
    }


    public static class GameDetailsPanel extends JPanel{
        private Game game;

        private JLabel titleName;
        private JTextField tfName;

        public GameDetailsPanel(){
            super();

            titleName = new JLabel("Name");
            tfName = new JTextField();

            new GridBagLayoutHelper(this, true)
                    .add(titleName).add(tfName).nextRow()
                    ;
        }

        public void setGame(Game game){
            this.game = game;
        }

        public void refresh(){
            if (game == null)
                return;
            tfName.setText(game.getName());
        }
    }
}
