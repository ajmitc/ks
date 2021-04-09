package ks.client.map_pack;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MapPackManifest {
    private List<MapInfo> maps;

    public List<MapInfo> getMaps() {
        return maps;
    }

    public void setMaps(List<MapInfo> maps) {
        this.maps = maps;
    }

    public static class MapInfo{
        private String id;
        private String name;
        private String directory;
        private List<ImageInfo> images;
        private int width;
        private int height;
        @JsonProperty("terrain-file")
        private String terrainFile;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDirectory() {
            return directory;
        }

        public void setDirectory(String directory) {
            this.directory = directory;
        }

        public List<ImageInfo> getImages() {
            return images;
        }

        public void setImages(List<ImageInfo> images) {
            this.images = images;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public String getTerrainFile() {
            return terrainFile;
        }

        public void setTerrainFile(String terrainFile) {
            this.terrainFile = terrainFile;
        }
    }

    public static class ImageInfo {
        private String filename;
        private int gridx;
        private int gridy;

        public String getFilename() {
            return filename;
        }

        public void setFilename(String filename) {
            this.filename = filename;
        }

        public int getGridx() {
            return gridx;
        }

        public void setGridx(int gridx) {
            this.gridx = gridx;
        }

        public int getGridy() {
            return gridy;
        }

        public void setGridy(int gridy) {
            this.gridy = gridy;
        }
    }
}
