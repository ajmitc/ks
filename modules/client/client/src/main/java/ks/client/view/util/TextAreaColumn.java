package ks.client.view.util;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.*;

/**
 * The TextAreaColumn class provides a renderer and an editor that looks like a
 * JTextArea. The renderer and editor will then be used for a specified column
 * in the table. The TableModel will contain the String to be displayed in
 * the text area.
 */
public class TextAreaColumn extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, FocusListener {
    private JTable table;
    private Border originalBorder;
    private Border focusBorder;

    private JTextArea renderTextArea;
    private JTextArea editTextArea;
    private JScrollPane scrollPane;
    private Object editorValue;
    private boolean isTextAreaColumnEditor;

    private int lastRowIndex;

    /**
     * Create the TextAreaColumn to be used as a renderer and editor. The
     * renderer and editor will automatically be installed on the TableColumn
     * of the specified column.
     *
     * @param table  the table containing the button renderer/editor
     * @param column the column to which the button renderer/editor is added
     */
    public TextAreaColumn(JTable table, int column) {
        this.table = table;

        renderTextArea = new JTextArea();
        renderTextArea.setWrapStyleWord(true);
        renderTextArea.setLineWrap(true);
        renderTextArea.setRows(3);
        renderTextArea.setEditable(false);

        editTextArea = new JTextArea();
        editTextArea.setWrapStyleWord(true);
        editTextArea.setLineWrap(true);
        editTextArea.setRows(3);

        editTextArea.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                table.setRowHeight(lastRowIndex, (int) (editTextArea.getPreferredSize().getHeight()));
            }
        });
        editTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
                table.setRowHeight(lastRowIndex, (int) (editTextArea.getPreferredSize().getHeight()));
            }
        });

        scrollPane = new JScrollPane(editTextArea);

        originalBorder = editTextArea.getBorder();
        setFocusBorder(new LineBorder(Color.BLUE));

        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(column).setCellRenderer(this);
        columnModel.getColumn(column).setCellEditor(this);
        columnModel.getColumn(column).setResizable(true);
        table.addFocusListener(this);

        table.setRowHeight(table.getRowHeight() + 40);
    }


    /**
     * Get foreground color of the button when the cell has focus
     *
     * @return the foreground color
     */
    public Border getFocusBorder() {
        return focusBorder;
    }

    /**
     * The foreground color of the button when the cell has focus
     *
     * @param focusBorder the foreground color
     */
    public void setFocusBorder(Border focusBorder) {
        this.focusBorder = focusBorder;
        editTextArea.setBorder(focusBorder);
    }

    @Override
    public Component getTableCellEditorComponent(
            JTable table, Object value, boolean isSelected, int row, int column) {
        lastRowIndex = row;

        if (value == null) {
            editTextArea.setText("");
        } else {
            editTextArea.setText(value.toString());
        }

        this.editorValue = value;
        //return editTextArea;
        return scrollPane;
    }

    @Override
    public Object getCellEditorValue() {
        return editTextArea.getText(); // editorValue;
    }

    //
    //  Implement TableCellRenderer interface
    //
    public Component getTableCellRendererComponent(
            JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (isSelected) {
            renderTextArea.setForeground(table.getSelectionForeground());
            renderTextArea.setBackground(table.getSelectionBackground());
        } else {
            renderTextArea.setForeground(table.getForeground());
            renderTextArea.setBackground(UIManager.getColor("Button.background"));
        }

        if (hasFocus) {
            renderTextArea.setBorder(focusBorder);
        } else {
            renderTextArea.setBorder(originalBorder);
        }

        renderTextArea.setText((value == null) ? "" : value.toString());
        return renderTextArea;
    }

    //
    //  Implement FocusListener interface
    //

    /*
     *  When the mouse is pressed the editor is invoked. If you then drag
     *  the mouse to another cell before releasing it, the editor is still
     *  active. Make sure editing is stopped when the focus is lost.
     */
    @Override
    public void focusGained(FocusEvent focusEvent) {
        if (table.isEditing()
                && table.getCellEditor() == this)
            isTextAreaColumnEditor = true;
    }

    @Override
    public void focusLost(FocusEvent focusEvent) {
        if (isTextAreaColumnEditor
                && table.isEditing())
            table.getCellEditor().stopCellEditing();
        isTextAreaColumnEditor = false;
    }
}
