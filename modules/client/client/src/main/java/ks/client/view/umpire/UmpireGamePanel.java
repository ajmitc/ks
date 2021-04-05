package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;
import ks.common.model.user.User;
import ks.common.model.user.UserRole;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UmpireGamePanel extends JPanel {
    private Model model;
    private View view;

    private UmpireMapPanel mapPanel;
    private MessagePanel leftMessagePanel;
    private MessagePanel rightMessagePanel;

    public UmpireGamePanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        mapPanel = new UmpireMapPanel(model, view);
        leftMessagePanel = new MessagePanel(model, view);
        rightMessagePanel = new MessagePanel(model, view);

        add(mapPanel, BorderLayout.CENTER);
        add(leftMessagePanel, BorderLayout.WEST);
        add(rightMessagePanel, BorderLayout.EAST);
    }

    /**
     * Initialize this panel with the Game in Model
     */
    public void init(){
        List<User> users = model.getCurrentGame().getUsers();
        for (User user: users) {
            if (user.getRole() == UserRole.GENERAL) {
                if (leftMessagePanel.getUser() == null)
                    leftMessagePanel.setUser(user);
                else if (rightMessagePanel.getUser() == null)
                    rightMessagePanel.setUser(user);
            }
        }
    }

    public void refresh(){
        mapPanel.refresh();
        leftMessagePanel.refresh();
        rightMessagePanel.refresh();
    }

    public UmpireMapPanel getMapPanel() {
        return mapPanel;
    }

    public MessagePanel getLeftMessagePanel() {
        return leftMessagePanel;
    }

    public MessagePanel getRightMessagePanel() {
        return rightMessagePanel;
    }
}
