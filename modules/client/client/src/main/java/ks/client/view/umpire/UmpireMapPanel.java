package ks.client.view.umpire;

import ks.client.Model;
import ks.client.map_pack.MapPackInfo;
import ks.client.map_pack.MapPackManifest;
import ks.client.view.ImageUtil;
import ks.client.view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class UmpireMapPanel extends JPanel {
    public static final String MODE_SELECT = "select";
    public static final String MODE_MEASURE = "measure";

    private Model model;
    private View view;

    private MapPackInfo mapPackInfo;

    private String mode = MODE_SELECT;

    public UmpireMapPanel(Model model, View view){
        super();
        this.model = model;
        this.view = view;
    }

    public void refresh(){
        repaint();
    }

    @Override
    public void paintComponent(Graphics graphics){
        if (model.getCurrentGame() != null)
            return;

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
    }

    public void setMode(String mode){
        this.mode = mode;

        // TODO Change cursor based on mode
    }
}
