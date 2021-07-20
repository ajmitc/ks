package ks.client.view.umpire;

import ks.client.Model;
import ks.client.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UmpireMapToolsPanel extends JPanel {
    private Model model;
    private View view;

    private JToolBar toolBar;

    // Allows the user to select units on the map and drag them around
    private JToggleButton btnEnableSelectionTool;

    // Allows the user to click and drag a line on the map and the distance is displayed
    private JToggleButton btnEnableMeasureTool;

    // Label that displays the measurement value from the measure tool
    private JLabel lblMeasureValue;

    // Panel that actually draws the map
    private UmpireMapPanel umpireMapPanel;

    public UmpireMapToolsPanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        btnEnableSelectionTool = new JToggleButton("Select");
        btnEnableMeasureTool   = new JToggleButton("Measure");

        lblMeasureValue = new JLabel("0");

        toolBar = new JToolBar();
        toolBar.add(btnEnableSelectionTool);
        toolBar.add(btnEnableMeasureTool);
        toolBar.add(lblMeasureValue);

        umpireMapPanel = new UmpireMapPanel(model, view);

        add(toolBar, BorderLayout.NORTH);
        add(umpireMapPanel, BorderLayout.CENTER);

        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(btnEnableSelectionTool);
        modeGroup.add(btnEnableMeasureTool);

        btnEnableSelectionTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                umpireMapPanel.setSelectMode();
            }
        });

        btnEnableMeasureTool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                umpireMapPanel.setMeasureMode();
            }
        });

        umpireMapPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (umpireMapPanel.getMode() == UmpireMapPanel.MODE_MEASURE){
                    measure(umpireMapPanel.getMeasureStart().x, umpireMapPanel.getMeasureStart().y, umpireMapPanel.getMeasureStop().x, umpireMapPanel.getMeasureStop().y);
                }
            }
        });

        umpireMapPanel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (umpireMapPanel.getMode() == UmpireMapPanel.MODE_MEASURE){
                    measure(umpireMapPanel.getMeasureStart().x, umpireMapPanel.getMeasureStart().y, umpireMapPanel.getMeasureStop().x, umpireMapPanel.getMeasureStop().y);
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }

    public void refresh(){
        umpireMapPanel.refresh();
    }

    private void measure(int startMx, int startMy, int stopMx, int stopMy){
        double distance = Math.sqrt(Math.pow(startMx - stopMx, 2) + Math.pow(startMy - stopMy, 2));
        lblMeasureValue.setText(distance + " paces");
    }

    public UmpireMapPanel getUmpireMapPanel() {
        return umpireMapPanel;
    }

    public JToggleButton getBtnEnableSelectionTool() {
        return btnEnableSelectionTool;
    }

    public JToggleButton getBtnEnableMeasureTool() {
        return btnEnableMeasureTool;
    }
}
