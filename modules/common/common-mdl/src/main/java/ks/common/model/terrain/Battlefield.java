package ks.common.model.terrain;

/**
 * Represents the entire battlefield on which the users play
 */
public class Battlefield {
    private TerrainPlot[][] plots;

    public Battlefield(int width, int height){
        plots = new TerrainPlot[height][width];

        for (int x = 0; x < width; ++x){
            for (int y = 0; y < height; ++y){
                plots[y][x] = new TerrainPlot(x, y);
            }
        }
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
