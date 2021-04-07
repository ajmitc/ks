package ks.client.server;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Enables the client to talk to the Server
 */
public class RestConnection {
    private static Logger logger = LoggerFactory.getLogger(RestConnection.class);

    private String hostname;
    private int port;
    private boolean connected = false;

    private HttpClient httpClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    public RestConnection(){

    }

    /**
     * Connect to remote server
     * @return true if connected, false otherwise
     */
    public boolean connect(){
        httpClient = new DefaultHttpClient();
        final HttpGet httpGet = new HttpGet(buildUrl("/alive"));
        try {
            httpClient.execute(httpGet);
            connected = true;
        } catch (IOException ex) {
            logger.info("Unable to connect to " + buildUrl("/alive"), ex);
            connected = false;
        }
        return connected;
    }

    public RestResponse get(String path){
        final HttpGet httpGet = new HttpGet(buildUrl(path));
        HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (IOException ex) {
            logger.error("Unable to connect to server", ex.getMessage());
            throw new RuntimeException("Unable to connect to server", ex);
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            logger.error("Unable to read from server", ex);
            throw new RuntimeException("Unable to read from server", ex);
        }

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException ex) {
                logger.error("Failure while reading from server", ex);
                throw new RuntimeException("Failure while reading from server", ex);
            }
            stringBuilder.append(line);
        }
        return new RestResponse(response.getStatusLine().getStatusCode(), stringBuilder.toString());
    }

    public RestResponse post(String path, Object body){
        final HttpPost httpPost = new HttpPost(buildUrl(path));

        StringEntity input = null;
        try {
            input = new StringEntity(objectMapper.writeValueAsString(body));
        } catch (UnsupportedEncodingException ex) {
            logger.error("Exception caught while building POST call", ex);
        }
        catch (JsonProcessingException jpe){
            logger.error("Exception caught while building POST call", jpe);
        }
        httpPost.setEntity(input);

        HttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
        } catch (IOException ex) {
            logger.error("Exception caught while executing POST call", ex);
        }

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        } catch (IOException ex) {
            logger.error("Exception caught while reading POST response", ex);
        }

        StringBuilder stringBuilder = new StringBuilder();
        String line = "";
        while (true) {
            try {
                if (!((line = reader.readLine()) != null)) break;
            } catch (IOException ex) {
                logger.info("The method is down." + ex.getMessage());
            }
            stringBuilder.append(line);
        }

        return new RestResponse(response.getStatusLine().getStatusCode(), stringBuilder.toString());
    }

    private String buildUrl(String path){
        if (!path.startsWith("/"))
            path = "/" + path;
        return "http://" + hostname + ":" + port + path;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public boolean isConnected() {
        return connected;
    }

    public static class RestResponse{
        private int statusCode;
        private String body;

        public RestResponse(int statusCode, String body){
            this.statusCode = statusCode;
            this.body = body;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }
    }
}
