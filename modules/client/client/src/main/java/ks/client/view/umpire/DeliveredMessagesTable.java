package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;

import javax.swing.*;

public class DeliveredMessagesTable extends JTable {
    private Model model;
    private View view;

    public DeliveredMessagesTable(Model model, View view, DeliveredMessagesTableModel tableModel){
        super(tableModel);
        this.model = model;
        this.view = view;
    }
}
