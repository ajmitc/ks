package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;
import ks.client.view.util.ViewUtil;
import ks.client.view.util.ButtonColumn;
import ks.client.view.util.TextAreaColumn;
import ks.common.model.message.UnitMessage;
import ks.common.model.message.UnitMessageStatus;
import ks.common.model.message.UnitMessageType;
import ks.common.model.side.Side;
import ks.common.model.unit.Messenger;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DeliveredOrdersTable extends JTable {
    private Model model;
    private View view;

    public DeliveredOrdersTable(Model model, View view, DeliveredOrdersTableModel tableModel){
        super(tableModel);
        this.model = model;
        this.view = view;

        TextAreaColumn textAreaColumn = new TextAreaColumn(this, 2);

        Action buttonAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JTable table = (JTable) actionEvent.getSource();
                int modelRow = Integer.valueOf(actionEvent.getActionCommand());

                UnitMessage deliveredOrder = ((DeliveredOrdersTableModel) table.getModel()).getRowAt(modelRow);
                model.getCurrentGame().getActiveMessages().remove(deliveredOrder);
                model.getCurrentGame().getDeliveredMessages().add(deliveredOrder);

                String content = ((DeliveredOrdersTableModel) table.getModel()).getReportForMessage(deliveredOrder.getId());
                UnitMessage report = new UnitMessage(UnitMessageType.REPORT, deliveredOrder.getUserId(), deliveredOrder.getRecipientId(), deliveredOrder.getSubject(), content);
                report.setStatus(UnitMessageStatus.EN_ROUTE);
                model.getCurrentGame().getActiveMessages().add(report);

                // Create and send Messenger
                Side side = model.getCurrentGame().getUsersSide(((DeliveredOrdersTableModel) getModel()).getUser().getId());
                Messenger messenger = new Messenger(side.getId(), null, "Messenger");
                messenger.setMessage(report);
                model.getCurrentGame().getMessengers().add(messenger);

                ViewUtil.popupNotify("Message Sent");
                ((PendingOrdersTableModel) table.getModel()).removeRow(modelRow);

                view.getGamePanel().refresh();
            }
        };
        ButtonColumn buttonColumn = new ButtonColumn(this, buttonAction, 3);
        //buttonColumn.setMnemonic(KeyEvent.VK_D);

    }
}
