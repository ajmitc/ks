package ks.client;

import ks.client.view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Controller {
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
            }
        });
    }
}
