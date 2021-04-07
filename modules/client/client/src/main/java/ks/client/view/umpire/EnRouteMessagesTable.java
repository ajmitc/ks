package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;

import javax.swing.*;

public class EnRouteMessagesTable extends JTable {
    private Model model;
    private View view;

    public EnRouteMessagesTable(Model model, View view, EnRouteMessagesTableModel tableModel){
        super(tableModel);
        this.model = model;
        this.view = view;

        setRowHeight(getRowHeight() + 40);
    }
}
