package ks.client.view.umpire;

import ks.client.Model;
import ks.common.model.message.MessageRecipient;
import ks.common.model.message.UnitMessage;
import ks.common.model.message.UnitMessageStatus;
import ks.common.model.message.UnitMessageType;
import ks.common.model.user.User;
import ks.common.util.CommonUtil;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

/**
 * This table shows the Umpire all messages that the General has submitted.
 * The Umpire uses this table to tell the Messenger where to deliver the message.
 */
public class EnRouteMessagesTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{
            "Source",
            "Destination",
            "Message",
            "Sent",
            "ETA"
    };
    private Model model;
    private List<UnitMessage> messages = new ArrayList<>();
    private User user;

    public EnRouteMessagesTableModel(Model model){
        super();
        this.model = model;
    }

    public UnitMessage getRowAt(int row){
        if (messages != null && messages.size() > row)
            return messages.get(row);
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
        MessageRecipient messageRecipient = model.getCurrentGame().findMessageRecipient(message.getRecipientId());
        switch (col){
            case 0: // Source
                if (message.getType() == UnitMessageType.ORDER) {
                    return "<html>HQ</html>";
                }
                else {
                    return "<html>" + messageRecipient.getName() + "</html>";
                }
            case 1: // Destination
                if (message.getType() == UnitMessageType.ORDER) {
                    return "<html>" + messageRecipient.getName() + "</html>";
                }
                else{
                    return "<html>HQ</html>";
                }
            case 2: // Message
                return "<html>" + message.getContent() + "</html>";
            case 3: // Sent Time
                return "<html>" + CommonUtil.formatDateTime(message.getCreatedTimestamp()) + "</html>";
            case 4: // ETA
                // TODO How is this estimated?
                //return "<html>" + CommonUtil.formatDateTime(message.getDeliveryTimestamp()) + "</html>";
                return "";
        }
        return "";
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
        return false;
    }

    public void update(List<UnitMessage> activeMessages) {
        int currentSize = messages.size();
        for (UnitMessage activeMessage: activeMessages) {
            // Only accept messages that are ORDERS and PENDING
            if (activeMessage.getStatus() == UnitMessageStatus.EN_ROUTE && activeMessage.getUserId().equals(user.getId())) {
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
        removeRow(row);
    }

    public void removeRow(int row){
        if (row < 0)
            return;
        messages.remove(row);
        fireTableRowsDeleted(row, row);
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
