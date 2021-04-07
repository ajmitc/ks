package ks.client.view;

import ks.client.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private static final String MAINMENU = "mainmenu";
    private static final String CREATE_LOCAL_GAME = "createlocal";
    private static final String LOBBY = "lobby";
    private static final String GAME = "game";

    private Model model;
    private JFrame frame;

    private MainMenuPanel mainMenuPanel;
    private GameCreatorPanel gameCreatorPanel;
    private LobbyPanel lobbyPanel;
    private GamePanel gamePanel;

    public View(Model model){
        this.model = model;
        this.frame = new JFrame();

        this.frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.frame.setLocation(0, 0);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setTitle("Kriegsspiel");

        mainMenuPanel    = new MainMenuPanel(model, this);
        gameCreatorPanel = new GameCreatorPanel(model, this);
        lobbyPanel       = new LobbyPanel(model, this);
        gamePanel        = new GamePanel(model, this);

        this.frame.getContentPane().setLayout(new CardLayout());
        this.frame.getContentPane().add(mainMenuPanel, MAINMENU);
        this.frame.getContentPane().add(gameCreatorPanel, CREATE_LOCAL_GAME);
        this.frame.getContentPane().add(lobbyPanel, LOBBY);
        this.frame.getContentPane().add(gamePanel, GAME);
    }

    public void showMainMenu(){
        showCard(MAINMENU);
    }

    public void showCreateLocalGame(){
        showCard(CREATE_LOCAL_GAME);
    }

    public void showLobby(){
        showCard(LOBBY);
    }

    public void showGame(){
        showCard(GAME);
    }

    private void showCard(String name){
        ((CardLayout) this.frame.getContentPane().getLayout()).show(this.frame.getContentPane(), name);
    }

    public JFrame getFrame() {
        return frame;
    }

    public MainMenuPanel getMainMenuPanel() {
        return mainMenuPanel;
    }

    public LobbyPanel getLobbyPanel() {
        return lobbyPanel;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public GameCreatorPanel getGameCreatorPanel() {
        return gameCreatorPanel;
    }
}
