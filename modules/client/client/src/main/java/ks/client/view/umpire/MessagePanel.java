package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;
import ks.common.model.user.User;

import javax.swing.*;

/**
 * A MessagePanel displays the Orders from one particular User and also provides an interface for the Umpire to send reports
 *
 * Tables:
 * 1) Orders submitted by General
 *       type == ORDER
 *       status == PENDING
 *       order by createdTimestamp
 *     | Destination | Message | Time Created | Button("Send") |
 *       Select order "Send" button and click on Map to send messenger
 *          Remove from this table and set status = EN_ROUTE
 *          Add to en-route table
 *
 * 2) Orders that need to be carried out by Umpire
 *       type == ORDER
 *       status == DELIVERED
 *       order by deliveryTimestamp
 *     | Destination | Message | Report | Button("Send Report") |
 *       Type report into Report column text area, click "Send Report", then click General on Map
 *       Link Report to Order and add Report to en-route table
 *
 * 3) Order/Reports en-route to General/destination
 *       type == ORDER or REPORT
 *       status == EN_ROUTE
 *       order by createdTimestamp
 *     | Source | Destination | Message | Sent Timestamp | Expected Delivery Timestamp |
 *       When delivered,
 *          set status = DELIVERED
 *          if ORDER, remove from this table and add to table #2
 *          if REPORT, remove from this table and sent to General
 *
 *  4) Delivered Messages
 *        type == ORDER or REPORT
 *        status == DELIVERED
 *        order by deliveredTimestamp
 *      | Source | Destination | Message | Sent Timestamp | Delivered Timestamp | Linked Messages |
 */
public class MessagePanel extends JPanel {
    private Model model;
    private View view;

    private User user;

    private PendingOrdersTableModel pendingOrdersTableModel;
    private DeliveredOrdersTableModel deliveredOrdersTableModel;
    private PendingOrdersTable tblPendingOrders;
    private JTable tblDeliveredOrders;
    private JTable tblEnRouteMessages;
    private JTable tblDeliveredMessages;

    public MessagePanel(Model model, View view){
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.model = model;
        this.view = view;

        pendingOrdersTableModel = new PendingOrdersTableModel(user);
        deliveredOrdersTableModel = new DeliveredOrdersTableModel(user);

        tblPendingOrders = new PendingOrdersTable(model, view, pendingOrdersTableModel);
        tblDeliveredOrders = new JTable(deliveredOrdersTableModel);
        tblEnRouteMessages = new JTable();
        tblDeliveredMessages = new JTable();

        add(new JScrollPane(tblPendingOrders));
        add(new JScrollPane(tblDeliveredOrders));
        add(new JScrollPane(tblEnRouteMessages));
        add(new JScrollPane(tblDeliveredMessages));
    }

    public void refresh(){
        pendingOrdersTableModel.update(model.getCurrentGame().getActiveMessages());
        deliveredOrdersTableModel.update(model.getCurrentGame().getActiveMessages());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PendingOrdersTable getPendingOrdersTable() {
        return tblPendingOrders;
    }
}
