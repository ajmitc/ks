package ks.client.view;

import ks.client.Model;

import javax.swing.*;

public class MainMenuPanel extends JPanel {
    // Start a new game running the server locally
    private JButton btnNewLocalGame;

    // Connect the client to a remote server
    private JButton btnConnectToRemoteServer;

    public MainMenuPanel(Model model, View view){
        super();

        btnNewLocalGame = new JButton("New Local Game");
        btnConnectToRemoteServer = new JButton("Connect to Remote Server");

        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        add(btnNewLocalGame);
        add(btnConnectToRemoteServer);
    }

    public JButton getBtnConnectToRemoteServer() {
        return btnConnectToRemoteServer;
    }

    public JButton getBtnNewLocalGame() {
        return btnNewLocalGame;
    }
}
