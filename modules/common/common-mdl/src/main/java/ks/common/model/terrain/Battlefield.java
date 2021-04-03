package ks.common.model.terrain;

import java.awt.image.BufferedImage;

/**
 * Represents the entire battlefield on which the users play
 */
public class Battlefield {
    // Human-readable name for the map
    private String mapName;

    // Image displayed on background
    private BufferedImage backgroundImage;

    // URL to download the background image from the server to the client
    // Server should never populate backgroundImage above, only this URL callback.
    private String backgroundImageUrlCallback;

    // Logical subsections of map
    private TerrainPlot[][] plots;

    public Battlefield(int width, int height){
        plots = new TerrainPlot[height][width];

        for (int x = 0; x < width; ++x){
            for (int y = 0; y < height; ++y){
                plots[y][x] = new TerrainPlot(x, y);
            }
        }
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String mapName) {
        this.mapName = mapName;
    }

    public BufferedImage getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(BufferedImage backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public TerrainPlot getPlot(int x, int y){
        if (x < 0 || y < 0 || y >= plots.length || x >= plots[0].length)
            return null;
        return plots[y][x];
    }

    public String getBackgroundImageUrlCallback() {
        return backgroundImageUrlCallback;
    }

    public void setBackgroundImageUrlCallback(String backgroundImageUrlCallback) {
        this.backgroundImageUrlCallback = backgroundImageUrlCallback;
    }

    public TerrainPlot[][] getPlots() {
        return plots;
    }

    public void setPlots(TerrainPlot[][] plots) {
        this.plots = plots;
    }
}
