package ks.common.model.terrain;

import java.util.UUID;

/**
 * Represents the entire battlefield on which the users play
 */
public class Battlefield {
    // Unique ID for this battlefield
    private String id;

    // ID of map-pack to use
    private String mapPackId;

    // Logical subsections of map
    private TerrainPlot[][] plots;

    public Battlefield(int width, int height){
        this.id = "" + UUID.randomUUID();

        plots = new TerrainPlot[height][width];

        for (int x = 0; x < width; ++x){
            for (int y = 0; y < height; ++y){
                plots[y][x] = new TerrainPlot(x, y);
            }
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMapPackId() {
        return mapPackId;
    }

    public void setMapPackId(String mapPackId) {
        this.mapPackId = mapPackId;
    }

    public TerrainPlot getPlot(int x, int y){
        if (x < 0 || y < 0 || y >= plots.length || x >= plots[0].length)
            return null;
        return plots[y][x];
    }

    public TerrainPlot[][] getPlots() {
        return plots;
    }

    public void setPlots(TerrainPlot[][] plots) {
        this.plots = plots;
    }
}
