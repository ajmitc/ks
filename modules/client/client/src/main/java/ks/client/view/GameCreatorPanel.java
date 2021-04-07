package ks.client.view;

import ks.client.Model;
import ks.client.view.util.FieldLabel;
import ks.client.view.util.TitleLabel;

import javax.swing.*;
import java.awt.*;

public class GameCreatorPanel extends JPanel {
    private Model model;
    private View view;

    private JTextField tfGameName;
    private JTextArea taCommonDescription;
    private JTextArea taSideADescription;
    private JTextArea taSideBDescription;
    private JComboBox cbBattlefield;
    private JTextField tfSideAName;
    private JTextField tfSideBName;
    private JComboBox<String> cbSideAColor;
    private JComboBox<String> cbSideBColor;
    private JList listAllForces;
    private JList sideAForces;
    private JList sideBForces;
    private JButton btnCreate;
    private JButton btnCancel;

    public GameCreatorPanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        tfGameName = new JTextField(10);
        taCommonDescription = new JTextArea();
        taSideADescription = new JTextArea();
        taSideBDescription = new JTextArea();
        cbBattlefield = new JComboBox();
        tfSideAName = new JTextField(10);
        tfSideBName = new JTextField(10);
        cbSideAColor = new JComboBox();
        cbSideBColor = new JComboBox();
        listAllForces = new JList();
        sideAForces = new JList();
        sideBForces = new JList();
        btnCreate = new JButton("Create");
        btnCancel = new JButton("Cancel");

        tfGameName.setText("Local Game");

        taCommonDescription.setColumns(30);
        taCommonDescription.setRows(10);

        taSideADescription.setColumns(15);
        taSideADescription.setRows(8);

        taSideBDescription.setColumns(15);
        taSideBDescription.setRows(8);

        cbSideAColor.addItem("Blue");
        cbSideAColor.addItem("Red");

        cbSideBColor.addItem("Red");
        cbSideBColor.addItem("Blue");

        listAllForces.setVisibleRowCount(10);
        sideAForces.setVisibleRowCount(10);
        sideBForces.setVisibleRowCount(10);

        JLabel lblTitle = new TitleLabel("Create Game");
        JLabel lblName = new FieldLabel("Game Name");
        JLabel lblCommonDesc = new FieldLabel("Common Description");
        JLabel lblSideADesc = new FieldLabel("Side A Description");
        JLabel lblSideBDesc = new FieldLabel("Side B Description");
        JLabel lblBattlefield = new FieldLabel("Battlefield");
        JLabel lblSideAName = new FieldLabel("Side A Name");
        JLabel lblSideBName = new FieldLabel("Side B Name");
        JLabel lblSideAUnits = new FieldLabel("Side A Units");
        JLabel lblSideBUnits = new FieldLabel("Side B Units");

        JPanel commonPanel = new JPanel();
        JPanel sideAPanel = new JPanel();
        JPanel sideBPanel = new JPanel();

        new GridBagLayoutHelper(commonPanel, true)
                .setAnchor(GridBagConstraints.NORTHWEST)
                .setGridWidth(2)
                .add(lblTitle).nextRow()
                .resetGridWidth()
                .add(lblName).add(tfGameName).nextRow()
                .setGridWidth(2)
                .add(lblCommonDesc).nextRow()
                .add(new JScrollPane(taCommonDescription)).nextRow()
                .add(lblBattlefield).nextRow()
                .add(cbBattlefield).nextRow()
                ;

        new GridBagLayoutHelper(sideAPanel, true)
                .setAnchor(GridBagConstraints.NORTHWEST)
                .add(lblSideAName).add(tfSideAName).add(cbSideAColor).nextRow()
                .setGridWidth(3)
                .add(lblSideADesc).nextRow()
                .add(new JScrollPane(taSideADescription)).nextRow()
                .add(lblSideAUnits).nextRow()
                .add(new JScrollPane(sideAForces)).nextRow()
                ;

        new GridBagLayoutHelper(sideBPanel, true)
                .setAnchor(GridBagConstraints.NORTHWEST)
                .add(lblSideBName).add(tfSideBName).add(cbSideBColor).nextRow()
                .setGridWidth(3)
                .add(lblSideBDesc).nextRow()
                .add(new JScrollPane(taSideBDescription)).nextRow()
                .add(lblSideBUnits).nextRow()
                .add(new JScrollPane(sideBForces)).nextRow()
        ;

        JPanel contentpane = new JPanel();
        new GridBagLayoutHelper(contentpane, true)
                .setGridWidth(2)
                .add(commonPanel).nextRow()
                .resetGridWidth()
                .add(sideAPanel).add(sideBPanel).nextRow()
                ;

        JPanel buttonpanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonpanel.add(btnCancel);
        buttonpanel.add(btnCreate);

        add(contentpane, BorderLayout.CENTER);
        add(buttonpanel, BorderLayout.SOUTH);
    }

    public JTextField getTfGameName() {
        return tfGameName;
    }

    public JTextArea getTaCommonDescription() {
        return taCommonDescription;
    }

    public JTextArea getTaSideADescription() {
        return taSideADescription;
    }

    public JTextArea getTaSideBDescription() {
        return taSideBDescription;
    }

    public JComboBox getCbBattlefield() {
        return cbBattlefield;
    }

    public JTextField getTfSideAName() {
        return tfSideAName;
    }

    public JTextField getTfSideBName() {
        return tfSideBName;
    }

    public JComboBox getCbSideAColor() {
        return cbSideAColor;
    }

    public JComboBox getCbSideBColor() {
        return cbSideBColor;
    }

    public JList getListAllForces() {
        return listAllForces;
    }

    public JList getSideAForces() {
        return sideAForces;
    }

    public JList getSideBForces() {
        return sideBForces;
    }

    public JButton getBtnCreate() {
        return btnCreate;
    }

    public JButton getBtnCancel() {
        return btnCancel;
    }
}
