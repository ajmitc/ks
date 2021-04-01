package ks.client.view;

import ks.client.Model;

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

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.PAGE_AXIS));
        leftPanel.add(serverConnectPanel);

        setLayout(new BorderLayout());
        add(leftPanel, BorderLayout.WEST);
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

    public void updateServerConnectedStatus(){
        ((TitledBorder) serverConnectPanel.getBorder()).setTitle("Server - " + (model.getServerConnection().isConnected()? "Connected": "Not connected"));
        btnConnectToServer.setText(model.getServerConnection().isConnected()? "Disconnect": "Connect");
    }
}
