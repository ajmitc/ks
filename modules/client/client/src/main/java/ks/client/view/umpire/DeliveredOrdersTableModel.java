package ks.client.view.umpire;

import ks.client.Model;
import ks.common.model.message.MessageRecipient;
import ks.common.model.message.UnitMessage;
import ks.common.model.message.UnitMessageStatus;
import ks.common.model.message.UnitMessageType;
import ks.common.model.user.User;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This table shows the Umpire all messages that the General has submitted.
 * The Umpire uses this table to tell the Messenger where to deliver the message.
 */
public class DeliveredOrdersTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{
            "Destination",
            "Message",
            "Report",
            "" // Send button
    };
    private Model model;
    private List<UnitMessage> messages = new ArrayList<>();
    private Map<String, String> pendingReports = new HashMap<>();
    private User user;

    public DeliveredOrdersTableModel(Model model){
        super();
        this.model = model;
    }

    public UnitMessage getRowAt(int row){
        if (messages != null && messages.size() > row)
            return messages.get(row);
        return null;
    }

    public String getReportForMessage(String messageId){
        if (pendingReports.containsKey(messageId))
            return pendingReports.get(messageId);
        return null;
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return messages.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        UnitMessage message = messages.get(row);
        switch (col){
            case 0: // Destination
                MessageRecipient messageRecipient = model.getCurrentGame().findMessageRecipient(message.getRecipientId());
                return "<html>" + messageRecipient.getName() + "</html>";
            case 1: // Message
                return "<html>" + message.getContent() + "</html>";
            case 2: // Report Text Area
                return pendingReports.containsKey(message.getId())? pendingReports.get(message.getId()): "";
            case 3: // Send button
                return "Send";
        }
        return "";
    }

    public void setValueAt(Object value, int row, int col) {
        UnitMessage message = messages.get(row);
        if (col == 2){
            pendingReports.put(message.getId(), "" + value);
            fireTableCellUpdated(row, col);
        }
    }


    public Class getColumnClass(int c) {
        if (messages.isEmpty())
            return null;
        return getValueAt(0, c).getClass();
    }

    /*
     * Don't need to implement this method unless your table's
     * editable.
     */
    public boolean isCellEditable(int row, int col) {
        return col >= 2;
    }

    public void update(List<UnitMessage> activeMessages) {
        int currentSize = messages.size();
        for (UnitMessage activeMessage: activeMessages) {
            // Only accept messages that are ORDERS and PENDING
            if (activeMessage.getType() == UnitMessageType.ORDER && activeMessage.getStatus() == UnitMessageStatus.DELIVERED && activeMessage.getUserId().equals(user.getId())) {
                // Check to see if this message is in our list
                boolean found = false;
                for (UnitMessage message : messages) {
                    if (activeMessage.getId().equals(message.getId())) {
                        found = true;
                        break;
                    }
                }

                if (found)
                    continue;

                // Add message
                this.messages.add(activeMessage);
            }
        }
        if (messages.size() > currentSize)
            fireTableRowsInserted(currentSize, messages.size() - 1);
    }

    public void removeMessage(UnitMessage message){
        int row = messages.indexOf(message);
        if (row < 0)
            return;
        messages.remove(message);
        fireTableRowsDeleted(row, row);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
