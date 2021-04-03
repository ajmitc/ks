package ks.client.view.general;

import ks.client.Model;
import ks.client.view.View;

import javax.swing.*;

public class GeneralGamePanel extends JPanel {
    private Model model;
    private View view;

    public GeneralGamePanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;
    }

    public void refresh(){

    }
}
