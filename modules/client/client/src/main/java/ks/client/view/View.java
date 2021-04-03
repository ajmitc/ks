package ks.client.view;

import ks.client.Model;

import javax.swing.*;
import java.awt.*;

public class View {
    private static final String MAINMENU = "mainmenu";
    private static final String LOBBY = "lobby";
    private static final String GAME = "game";

    private Model model;
    private JFrame frame;

    private MainMenuPanel mainMenuPanel;
    private LobbyPanel lobbyPanel;
    private GamePanel gamePanel;

    public View(Model model){
        this.model = model;
        this.frame = new JFrame();

        this.frame.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.frame.setLocation(0, 0);
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.frame.setTitle("Kriegsspiel");

        mainMenuPanel = new MainMenuPanel(model, this);
        lobbyPanel    = new LobbyPanel(model, this);
        gamePanel     = new GamePanel(model, this);

        this.frame.getContentPane().setLayout(new CardLayout());
        this.frame.getContentPane().add(mainMenuPanel, MAINMENU);
        this.frame.getContentPane().add(lobbyPanel, LOBBY);
        this.frame.getContentPane().add(gamePanel, GAME);
    }

    public void showMainMenu(){
        ((CardLayout) this.frame.getContentPane().getLayout()).show(this.frame.getContentPane(), MAINMENU);
    }

    public void showLobby(){
        ((CardLayout) this.frame.getContentPane().getLayout()).show(this.frame.getContentPane(), LOBBY);
    }

    public void showGame(){
        ((CardLayout) this.frame.getContentPane().getLayout()).show(this.frame.getContentPane(), GAME);
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
}