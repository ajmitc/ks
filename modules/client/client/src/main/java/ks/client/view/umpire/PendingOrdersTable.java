package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;
import ks.client.view.ViewUtil;
import ks.client.view.util.ButtonColumn;
import ks.common.model.message.UnitMessage;
import ks.common.model.message.UnitMessageStatus;
import ks.common.model.unit.Messenger;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PendingOrdersTable extends JTable {
    private Model model;
    private View view;

    public PendingOrdersTable(Model model, View view, PendingOrdersTableModel tableModel){
        super(tableModel);
        this.model = model;
        this.view = view;

        Action buttonAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTable table = (JTable) actionEvent.getSource();
                int modelRow = Integer.valueOf(actionEvent.getActionCommand());

                UnitMessage message = ((PendingOrdersTableModel) table.getModel()).getRowAt(modelRow);
                message.setStatus(UnitMessageStatus.EN_ROUTE);
                // TODO Create and send Messenger
                Messenger messenger = new Messenger(null, null, "Messenger");
                messenger.setMessage(message);

                ViewUtil.popupNotify("Message Sent");
                ((PendingOrdersTableModel) table.getModel()).removeRow(modelRow);
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(this, buttonAction, 3);
        //buttonColumn.setMnemonic(KeyEvent.VK_D);
    }
}
