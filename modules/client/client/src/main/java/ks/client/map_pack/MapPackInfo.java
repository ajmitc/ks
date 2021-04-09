package ks.client.map_pack;

public class MapPackInfo {
    private String archiveFile;
    private MapPackManifest manifest;

    public MapPackInfo(String archiveFile, MapPackManifest manifest){
        this.archiveFile = archiveFile;
        this.manifest = manifest;
    }

    public String getArchiveFile() {
        return archiveFile;
    }

    public void setArchiveFile(String archiveFile) {
        this.archiveFile = archiveFile;
    }

    public MapPackManifest getManifest() {
        return manifest;
    }

    public void setManifest(MapPackManifest manifest) {
        this.manifest = manifest;
    }
}
