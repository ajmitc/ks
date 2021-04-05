package ks.client.view.umpire;

import ks.client.view.ViewUtil;
import ks.client.view.util.ButtonColumn;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeliveredOrdersTable extends JTable {
    public DeliveredOrdersTable(DeliveredOrdersTableModel tableModel){
        super(tableModel);

        Action buttonAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ViewUtil.popupNotify("Button clicked");
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(this, buttonAction, 3);
        //buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
}
