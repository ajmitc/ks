package ks.client.view.umpire;

import ks.client.Model;
import ks.client.map_pack.MapPackInfo;
import ks.client.map_pack.MapPackManifest;
import ks.client.view.ImageUtil;
import ks.client.view.View;
import ks.common.model.force.Force;
import ks.common.model.unit.Unit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

public class UmpireMapPanel extends JPanel {
    public static final String MODE_SELECT = "select";
    public static final String MODE_MEASURE = "measure";

    private Model model;
    private View view;

    private MapPackInfo mapPackInfo;

    private String mode = MODE_SELECT;

    private Point measureStart = new Point();
    private Point measureStop  = new Point();

    public UmpireMapPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (getMode() == UmpireMapPanel.MODE_MEASURE){
                    measureStart.setLocation(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (getMode() == UmpireMapPanel.MODE_MEASURE){
                    measureStop.setLocation(e.getX(), e.getY());
                }
            }
        });

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setCursorBasedOnMode();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                resetCursor();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                if (mode == MODE_MEASURE && measureStart != null){
                    measureStop.setLocation(e.getX(), e.getY());
                }
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }

    public void refresh(){
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics){
        if (model.getCurrentGame() != null)
            return;

        // Load map pack, if not already loaded
        if (mapPackInfo == null) {
            String mapPackId = model.getCurrentGame().getBattlefield().getMapPackId();
            mapPackInfo = model.getMapPackInfo(mapPackId);
        }

        // Draw the background image
        for (MapPackManifest.MapInfo mapInfo: mapPackInfo.getManifest().getMaps()) {
            for (MapPackManifest.ImageInfo imageInfo: mapInfo.getImages()) {
                BufferedImage image = ImageUtil.get(imageInfo.getFilename());
                int gridx = imageInfo.getGridx();
                int gridy = imageInfo.getGridy();
                graphics.drawImage(image, gridx * image.getWidth(), gridy * image.getHeight(), null);
            }
        }

        // Draw units
        for (Force force: model.getCurrentGame().getForces()){
            for (Unit unit: force.getUnits()){
                //unit.getUnitType()
            }
        }
    }

    private void setMode(String mode){
        this.mode = mode;
        // TODO Change cursor based on mode
    }

    public void resetMode(){
        setSelectMode();
    }

    public void setSelectMode(){
        setMode(MODE_SELECT);
    }

    public void setMeasureMode(){
        setMode(MODE_MEASURE);
    }

    private void setCursorBasedOnMode(){
        switch (mode){
            case MODE_SELECT:
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                break;
            case MODE_MEASURE:
                setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
                break;
        }
    }

    private void resetCursor(){
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    public String getMode() {
        return mode;
    }

    public Point getMeasureStart() {
        return measureStart;
    }

    public void setMeasureStart(int mx, int my) {
        this.measureStart.setLocation(mx, my);
    }

    public Point getMeasureStop() {
        return measureStop;
    }
}
