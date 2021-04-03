package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;

import javax.swing.*;
import java.awt.*;

public class UmpireGamePanel extends JPanel {
    private Model model;
    private View view;

    private UmpireMapPanel mapPanel;
    private MessagePanel messagePanel;

    public UmpireGamePanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        mapPanel = new UmpireMapPanel(model, view);
        messagePanel = new MessagePanel(model, view);

        add(mapPanel, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.EAST);
    }

    public void refresh(){

    }
}
