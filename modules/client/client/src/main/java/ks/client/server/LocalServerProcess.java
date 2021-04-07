package ks.client.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class LocalServerProcess {
    private static Logger logger = LoggerFactory.getLogger(LocalServerProcess.class);

    private static final int DEFAULT_PORT = 7000;

    private static Process process;
    private static int port = DEFAULT_PORT;

    public static void start() throws IOException{
        if (process == null) {
            process = new ProcessBuilder().command("java", "-jar", "lib/server-0.1.0.jar", "" + port).start();
            logger.info("Started local server on port " + port);
        }
    }

    public static void stop(){
        if (process != null && process.isAlive()){
            logger.info("Stopping local server");
            process.destroy();
            try{Thread.sleep(1000);}catch (Exception e){}
            if (process.isAlive())
                logger.info("Forcibly stopping local server");
                process.destroyForcibly();
        }
    }
}
