package ks.client.view;

import ks.client.Model;

public class GameCreatorDialog extends BaseDialog {

    private GameCreatorPanel gameCreatorPanel;

    public GameCreatorDialog(Model model, View view){
        super(view.getFrame(), "Create New Game", true, 800, 600);

        gameCreatorPanel = new GameCreatorPanel(model, view);
        setContent(gameCreatorPanel);

        setCloseText("Create");
    }

    public GameCreatorPanel getGameCreatorPanel() {
        return gameCreatorPanel;
    }
}
