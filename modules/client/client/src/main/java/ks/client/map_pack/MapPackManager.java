package ks.client.map_pack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

/**
 * This class manages available map-packs
 *
 * Map-Packs are separate jar files that
 */
public class MapPackManager {
    private static Logger logger = LoggerFactory.getLogger(MapPackManager.class);

    private static final String MAP_PACK_REGISTRY_DIRECTORY = "~/.ks/map-packs";

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Get all available map-packs
     * @return List of Map Pack Info
     */
    public static List<MapPackInfo> getAvailableMapPacks(){
        List<MapPackInfo> mapPackInfos = new ArrayList<>();

        File registry = new File(MAP_PACK_REGISTRY_DIRECTORY);
        if (!createRegistryDirectory())
            return null;

        // Read the files in the registry directory
        File[] files = registry.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".jar");
            }
        });
        for (File file: files){
            mapPackInfos.addAll(inspectMapPackJar(file));
        }
        return mapPackInfos;
    }


    public static List<MapPackInfo> inspectMapPackJar(File file){
        List<MapPackInfo> mapPackInfos = new ArrayList<>();
        try {
            JarFile jarFile = new JarFile(file);
            Enumeration<? extends JarEntry> enumeration = jarFile.entries();

            // Iterates into the files in the jar file
            while (enumeration.hasMoreElements()) {
                ZipEntry zipEntry = enumeration.nextElement();
                // Is this the manifest file?
                if (zipEntry.getName().endsWith("manifest.json")) {
                    // Relative path of file into the jar.
                    String manifestPath = zipEntry.getName();
                    InputStream in = jarFile.getInputStream(zipEntry);
                    byte[] contentBytes = new byte[in.available()];
                    in.read(contentBytes);
                    String content = new String(contentBytes);
                    MapPackManifest manifest = objectMapper.readValue(content, new TypeReference<MapPackManifest>() {});
                    mapPackInfos.add(new MapPackInfo(file.getAbsolutePath(), manifest));
                }
            }
            return mapPackInfos;
        }
        catch (JsonProcessingException jpe){
            logger.error("Unable to read registry", jpe);
            return null;
        }
        catch (IOException ioe){
            logger.error("Unable to read registry", ioe);
            return null;
        }
    }

    /**
     * Create the registry file, if it doesn't exist
     * @return
     */
    public static boolean createRegistryDirectory(){
        File registry = new File(MAP_PACK_REGISTRY_DIRECTORY);
        if (!registry.getParentFile().isDirectory()){
            registry.getParentFile().mkdir();
        }
        if (!registry.isDirectory()){
            registry.mkdir();
        }
        return true;
    }

    private MapPackManager(){}
}
