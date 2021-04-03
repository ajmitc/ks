package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;

import javax.swing.*;

public class UmpireMapPanel extends JPanel {
    private Model model;
    private View view;

    public UmpireMapPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;
    }

    public void refresh(){

    }
}
