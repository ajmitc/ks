package ks.client.view.map_builder;

import ks.client.Model;
import ks.client.view.GridBagLayoutHelper;
import ks.client.view.View;
import ks.client.view.util.FieldLabel;
import ks.common.model.terrain.TerrainType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class MapBuilderPanel extends JPanel {
    private Model model;
    private View view;

    private MapImagePanel mapImagePanel;

    private JTextField tfName;
    private JTextField tfWidth;
    private JTextField tfHeight;
    private JButton btnScaleWidth;

    private int mouseDownX, mouseDownY;

    public MapBuilderPanel(Model model, View view){
        super(new BorderLayout());
        this.model = model;
        this.view = view;

        JButton btnLoadImage = new JButton("Load Image");
        JButton btnAlign     = new JButton("Align");
        JButton btnSave      = new JButton("Save");  // Save work so far in temp directory
        JButton btnExport    = new JButton("Export"); // Create/add-to map-pack jar

        btnLoadImage.setToolTipText("Add image to map");
        btnAlign.setToolTipText("Align images");
        btnSave.setToolTipText("Save to working directory");
        btnExport.setToolTipText("Export to map-pack");

        JToggleButton btnShowGrid = new JToggleButton("Show Grid");
        JLabel lblGridSize        = new FieldLabel("Grid Size");
        JTextField tfGridWidth    = new JTextField(5);
        JTextField tfGridHeight   = new JTextField(5);

        JToggleButton btnElevation = new JToggleButton("Set Elevation");
        JSpinner spnrElevation = new JSpinner();
        ((SpinnerNumberModel) spnrElevation.getModel()).setValue(0);
        ((SpinnerNumberModel) spnrElevation.getModel()).setMinimum(0);
        ((SpinnerNumberModel) spnrElevation.getModel()).setMaximum(10000);
        ((SpinnerNumberModel) spnrElevation.getModel()).setStepSize(10);

        JToggleButton btnTerrainType = new JToggleButton("Set Terrain");
        JComboBox<TerrainType> cbTerrainType = new JComboBox<>();
        Arrays.stream(TerrainType.values()).forEach(tt -> cbTerrainType.addItem(tt));

        JToolBar toolBar = new JToolBar();
        toolBar.add(btnLoadImage);
        toolBar.add(btnAlign);
        toolBar.addSeparator();
        toolBar.add(btnShowGrid);
        toolBar.add(lblGridSize);
        toolBar.add(tfGridWidth);
        toolBar.add(new JLabel("x"));
        toolBar.add(tfGridHeight);
        toolBar.addSeparator();
        toolBar.add(btnElevation);
        toolBar.add(spnrElevation);
        toolBar.add(btnTerrainType);
        toolBar.add(cbTerrainType);
        toolBar.addSeparator();
        toolBar.add(btnSave);
        toolBar.add(btnExport);

        mapImagePanel = new MapImagePanel();

        JLabel titleName   = new FieldLabel("Name");
        JLabel titleWidth  = new FieldLabel("Width");
        JLabel titleHeight = new FieldLabel("Height");

        tfName        = new JTextField(10);
        tfWidth       = new JTextField(10);
        tfHeight      = new JTextField(10);
        btnScaleWidth = new JButton("Scale");

        JPanel detailspanel = new JPanel();
        new GridBagLayoutHelper(detailspanel, true)
                .setAnchor(GridBagConstraints.NORTHWEST)
                .add(titleName)
                .setGridWidth(2)
                .add(tfName).nextRow()
                .resetGridWidth()
                .add(titleWidth).add(tfWidth).add(btnScaleWidth).nextRow()
                .add(titleHeight)
                .setGridWidth(2)
                .add(tfHeight).nextRow()
                .resetGridWidth()
                ;

        add(toolBar, BorderLayout.NORTH);
        add(mapImagePanel, BorderLayout.CENTER);
        add(detailspanel, BorderLayout.EAST);

        mapImagePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (btnElevation.isSelected() || btnTerrainType.isSelected()) {
                    if (btnElevation.isSelected()) {
                        // TODO Calculate grid coordinate and update TerrainPlot[]
                    }
                    if (btnTerrainType.isSelected()) {
                        // TODO Calculate grid coordinate and update TerrainPlot[]
                    }
                }
                else {
                    mapImagePanel.selectImageAt(e.getX(), e.getY());
                    mouseDownX = e.getX();
                    mouseDownY = e.getY();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (btnElevation.isSelected() || btnTerrainType.isSelected()) {
                    if (btnElevation.isSelected()) {
                        // TODO Calculate grid coordinate and update TerrainPlot[]
                    }
                    if (btnTerrainType.isSelected()) {
                        // TODO Calculate grid coordinate and update TerrainPlot[]
                    }
                }
                else {
                    int dx = e.getX() - mouseDownX;
                    int dy = e.getY() - mouseDownY;
                    mapImagePanel.selectedImagePan(dx, dy);
                }
            }
        });

        btnLoadImage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Open filedialog
                // TODO Load selected image
                // TODO draw on MapImagePanel
            }
        });

        btnAlign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Find image in upper-left corner (min x, min y)
                // TODO determine the grid location of each image based on upper-left corner image
                // TODO Pan each image based on upper-left corner image position and image grid position
            }
        });

        btnScaleWidth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mapImagePanel.selectedScaleWidth(Integer.decode(tfWidth.getText()));
            }
        });

        btnShowGrid.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Toggle showing grid on mapImagePanel
            }
        });

        tfGridWidth.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                // TODO Resize grid
            }
        });

        tfGridHeight.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                super.focusLost(e);
                // TODO Resize grid
            }
        });
    }
}
