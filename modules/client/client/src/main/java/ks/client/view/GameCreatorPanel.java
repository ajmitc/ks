package ks.client.view;

import ks.client.Model;

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

        tfGameName = new JTextField();
        taCommonDescription = new JTextArea();
        taSideADescription = new JTextArea();
        taSideBDescription = new JTextArea();
        cbBattlefield = new JComboBox();
        tfSideAName = new JTextField();
        tfSideBName = new JTextField();
        cbSideAColor = new JComboBox();
        cbSideBColor = new JComboBox();
        listAllForces = new JList();
        sideAForces = new JList();
        sideBForces = new JList();
        btnCreate = new JButton("Create");
        btnCancel = new JButton("Cancel");

        cbSideAColor.addItem("Blue");
        cbSideAColor.addItem("Red");

        cbSideBColor.addItem("Red");
        cbSideBColor.addItem("Blue");

        JLabel lblTitle = new JLabel("Create Game");
        JLabel lblName = new JLabel("Game Name");
        JLabel lblCommonDesc = new JLabel("Common Description");
        JLabel lblSideADesc = new JLabel("Side A Description");
        JLabel lblSideBDesc = new JLabel("Side B Description");
        JLabel lblBattlefield = new JLabel("Battlefield");
        JLabel lblSideAName = new JLabel("Side A Name");
        JLabel lblSideBName = new JLabel("Side B Name");
        JLabel lblSideAUnits = new JLabel("Side A Units");
        JLabel lblSideBUnits = new JLabel("Side B Units");

        JPanel commonPanel = new JPanel();
        JPanel sideAPanel = new JPanel();
        JPanel sideBPanel = new JPanel();

        new GridBagLayoutHelper(commonPanel, true)
                .setGridWidth(2)
                .add(lblTitle).nextRow()
                .resetGridWidth()
                .add(lblName).add(tfGameName).nextRow()
                .setGridWidth(2)
                .add(lblCommonDesc).nextRow()
                .add(taCommonDescription).nextRow()
                .add(lblBattlefield).nextRow()
                .add(cbBattlefield).nextRow()
                ;

        new GridBagLayoutHelper(sideAPanel, true)
                .add(lblSideAName).add(tfSideAName).add(cbSideAColor).nextRow()
                .setGridWidth(3)
                .add(lblSideADesc).nextRow()
                .add(taSideADescription).nextRow()
                .add(lblSideAUnits).nextRow()
                .add(sideAForces).nextRow()
                ;

        new GridBagLayoutHelper(sideBPanel, true)
                .add(lblSideBName).add(tfSideBName).add(cbSideBColor).nextRow()
                .setGridWidth(3)
                .add(lblSideBDesc).nextRow()
                .add(taSideBDescription).nextRow()
                .add(lblSideBUnits).nextRow()
                .add(sideBForces).nextRow()
        ;

        JPanel contentpane = new JPanel();
        new GridBagLayoutHelper(contentpane, true)
                .add(commonPanel).nextRow()
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
