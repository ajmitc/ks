package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;
import ks.client.view.ViewUtil;
import ks.client.view.util.ButtonColumn;
import ks.common.model.message.UnitMessage;
import ks.common.model.message.UnitMessageStatus;
import ks.common.model.side.Side;
import ks.common.model.unit.Messenger;

import javax.swing.*;
import java.awt.event.ActionEvent;

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
