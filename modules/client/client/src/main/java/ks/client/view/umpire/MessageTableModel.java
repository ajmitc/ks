package ks.client.view.umpire;

import ks.common.model.message.UnitMessage;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class MessageTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{
            "Destination",
            "Message",
            "Report",
            ""
    };
    private List<UnitMessage> messages = new ArrayList<>();

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
        switch (col){
            case 0: // Destination
                return message.getDestUnitId();
            case 1: // Message
                return message.getContent();
            case 2: // Report
                return "";
            case 3: // Delete button
                return new JButton("Delete");
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
        return col >= 2;
    }

    /*
     *
     */
    public void setValueAt(Object value, int row, int col) {
        UnitMessage message = messages.get(row);
        //if ()
        //   message[col] = value;
        fireTableCellUpdated(row, col);
    }

    public void addMessage(UnitMessage message) {
        this.messages.add(message);
        fireTableRowsInserted(messages.size() - 1, messages.size() - 1);
    }

    public void removeMessage(UnitMessage message){
        int row = messages.indexOf(message);
        if (row < 0)
            return;
        messages.remove(message);
        fireTableRowsDeleted(row, row);
    }
}
