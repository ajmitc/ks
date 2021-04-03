package ks.client.view;

import ks.client.Model;
import ks.client.util.Util;
import ks.common.model.game.Game;
import ks.common.model.side.Side;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.stream.Collectors;

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
    private JButton btnJoinGame;

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

        btnJoinGame = new JButton("Join");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(btnJoinGame);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(gameDetailsPanel, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
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

    public JButton getBtnJoinGame() {
        return btnJoinGame;
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
        private JLabel name;

        private JLabel titleDesc;
        private JLabel description;

        private JLabel titleMapName;
        private JLabel mapName;

        private JLabel titleSides;
        private JLabel sides;

        private JLabel titleSettings;
        private JLabel settings;

        public GameDetailsPanel(){
            super();

            titleName = new JLabel("Name");
            name = new JLabel();

            titleDesc = new JLabel("Description");
            description = new JLabel();

            titleMapName = new JLabel("Map");
            mapName = new JLabel("");

            titleSides = new JLabel("Sides");
            sides = new JLabel();

            titleSettings = new JLabel("Settings");
            settings = new JLabel();

            new GridBagLayoutHelper(this, true)
                    .add(titleName).add(name).nextRow()
                    .setGridWidth(2)
                    .add(titleDesc).nextRow()
                    .add(description).nextRow()
                    .resetGridWidth()
                    .add(titleMapName).add(mapName).nextRow()
                    .setGridWidth(2)
                    .add(titleSides).nextRow()
                    .add(sides).nextRow()
                    .add(titleSettings).nextRow()
                    .add(settings).nextRow()
                    .resetGridWidth()
                    ;
        }

        public void setGame(Game game){
            this.game = game;
        }

        public Game getGame() {
            return game;
        }

        public void refresh(){
            if (game == null)
                return;
            name.setText(game.getName());
            description.setText(game.getCommonDescription());
            mapName.setText(game.getBattlefield().getMapName());
            sides.setText(formatSides());
            settings.setText(formatSettings());
        }

        private String formatSides(){
            StringBuilder sb = new StringBuilder();
            sb.append("<html>");
            for (Side side: game.getSides()) {
                sb.append("<b>");
                sb.append(side.getName());
                sb.append("</b> (");
                sb.append(Util.getColorName(side.getColor()));
                sb.append(") [");
                sb.append(side.getUserIds().stream().collect(Collectors.joining(", ")));
                sb.append(" ]");
                sb.append("<br/>");
            }
            sb.append("</html>");
            return sb.toString();
        }

        private String formatSettings(){
            StringBuilder sb = new StringBuilder();

            return sb.toString();
        }
    }
}
