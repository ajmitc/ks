package ks.common.model.terrain;

/**
 * Represents a single "chunk" of land on the Battlefield.
 */
public class TerrainPlot {
    // Location of this plot
    private int x, y;

    // Elevation of this plot
    // > 0: hills, etc
    //   0: ground level
    // < 0: below ground
    private int elevation = 0;

    // Type of terrain
    private TerrainType terrainType = TerrainType.CLEAR;

    public TerrainPlot(){

    }

    public TerrainPlot(int x, int y){
        this(x, y, 0, TerrainType.CLEAR);
    }

    public TerrainPlot(int x, int y, int elevation, TerrainType terrainType){
        this.x = x;
        this.y = y;
        this.elevation = elevation;
        this.terrainType = terrainType;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getElevation() {
        return elevation;
    }

    public void setElevation(int elevation) {
        this.elevation = elevation;
    }

    public TerrainType getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(TerrainType terrainType) {
        this.terrainType = terrainType;
    }
}
