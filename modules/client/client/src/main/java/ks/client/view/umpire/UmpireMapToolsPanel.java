package ks.client.view.umpire;

import ks.client.Model;
import ks.client.map_pack.MapPackInfo;
import ks.client.map_pack.MapPackManifest;
import ks.client.view.ImageUtil;
import ks.client.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UmpireMapToolsPanel extends JPanel {
    private Model model;
    private View view;

    private JToolBar toolBar;

    // Allows the user to select units on the map and drag them around
    private JToggleButton btnEnableSelectionTool;

    // Allows the user to click and drag a line on the map and the distance is displayed
    private JToggleButton btnEnableMeasureTool;

    private UmpireMapPanel umpireMapPanel;

    public UmpireMapToolsPanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        btnEnableSelectionTool = new JToggleButton("Select");
        btnEnableMeasureTool = new JToggleButton("Measure");
        toolBar = new JToolBar();
        toolBar.add(btnEnableSelectionTool);
        toolBar.add(btnEnableMeasureTool);

        umpireMapPanel = new UmpireMapPanel(model, view);

        add(toolBar, BorderLayout.NORTH);
        add(umpireMapPanel, BorderLayout.CENTER);

        ButtonGroup modeGroup = new ButtonGroup();
        modeGroup.add(btnEnableSelectionTool);
        modeGroup.add(btnEnableMeasureTool);
    }

    public void refresh(){
        umpireMapPanel.refresh();
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
