package ks.client.view;

import ks.client.Model;
import ks.client.view.general.GeneralGamePanel;
import ks.client.view.umpire.UmpireGamePanel;
import ks.common.model.user.UserRole;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private Model model;
    private View view;

    private boolean showingUmpirePanel = true;
    private UmpireGamePanel umpireGamePanel;
    private GeneralGamePanel generalGamePanel;

    public GamePanel(Model model, View view){
        super(new CardLayout());
        this.model = model;
        this.view = view;

        umpireGamePanel = new UmpireGamePanel(model, view);
        generalGamePanel = new GeneralGamePanel(model, view);

        add(umpireGamePanel, UserRole.UMPIRE.name());
        add(generalGamePanel, UserRole.GENERAL.name());
    }

    public void refresh(){
        if (showingUmpirePanel)
            umpireGamePanel.refresh();
        else
            generalGamePanel.refresh();

    }

    public void showPanel(UserRole role){
        switch (role){
            case UMPIRE:
            case OBSERVER:
                showUmpirePanel();
                showingUmpirePanel = true;
                break;
            case GENERAL:
                showGeneralPanel();
                showingUmpirePanel = false;
                break;
        }
    }

    public void showUmpirePanel(){
        ((CardLayout) getLayout()).show(this, UserRole.UMPIRE.name());
    }

    public void showGeneralPanel(){
        ((CardLayout) getLayout()).show(this, UserRole.GENERAL.name());
    }
}
