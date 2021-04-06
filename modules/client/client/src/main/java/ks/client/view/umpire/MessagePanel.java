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

    private JLabel lblUser;
    private JLabel lblPendingOrders;
    private JLabel lblDeliveredOrders;
    private JLabel lblEnRouteOrders;
    private JLabel lblDeliveredMessages;

    private PendingOrdersTableModel pendingOrdersTableModel;
    private DeliveredOrdersTableModel deliveredOrdersTableModel;
    private EnRouteMessagesTableModel enRouteMessagesTableModel;
    private DeliveredMessagesTableModel deliveredMessagesTableModel;

    private PendingOrdersTable tblPendingOrders;
    private DeliveredOrdersTable tblDeliveredOrders;
    private EnRouteMessagesTable tblEnRouteMessages;
    private DeliveredMessagesTable tblDeliveredMessages;

    public MessagePanel(Model model, View view){
        super();
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.model = model;
        this.view = view;

        lblUser = new JLabel();
        lblPendingOrders     = new JLabel("Submitted Orders");
        lblDeliveredOrders   = new JLabel("Orders Delivered");
        lblEnRouteOrders     = new JLabel("Messages En-route");
        lblDeliveredMessages = new JLabel("Messages Delivered");

        pendingOrdersTableModel     = new PendingOrdersTableModel(model);
        deliveredOrdersTableModel   = new DeliveredOrdersTableModel(model);
        enRouteMessagesTableModel   = new EnRouteMessagesTableModel(model);
        deliveredMessagesTableModel = new DeliveredMessagesTableModel(model);

        tblPendingOrders     = new PendingOrdersTable(model, view, pendingOrdersTableModel);
        tblDeliveredOrders   = new DeliveredOrdersTable(model, view, deliveredOrdersTableModel);
        tblEnRouteMessages   = new EnRouteMessagesTable(model, view, enRouteMessagesTableModel);
        tblDeliveredMessages = new DeliveredMessagesTable(model, view, deliveredMessagesTableModel);

        add(lblUser);
        add(lblPendingOrders);
        add(new JScrollPane(tblPendingOrders));
        add(lblDeliveredOrders);
        add(new JScrollPane(tblDeliveredOrders));
        add(lblEnRouteOrders);
        add(new JScrollPane(tblEnRouteMessages));
        add(lblDeliveredMessages);
        add(new JScrollPane(tblDeliveredMessages));
    }

    public void refresh(){
        pendingOrdersTableModel.update(model.getCurrentGame().getActiveMessages());
        deliveredOrdersTableModel.update(model.getCurrentGame().getActiveMessages());
        enRouteMessagesTableModel.update(model.getCurrentGame().getActiveMessages());
        deliveredMessagesTableModel.update(model.getCurrentGame().getActiveMessages());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
        pendingOrdersTableModel.setUser(user);
        deliveredOrdersTableModel.setUser(user);

        lblUser.setText(user.getDisplayName());
    }

    public PendingOrdersTable getPendingOrdersTable() {
        return tblPendingOrders;
    }
}
