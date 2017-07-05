package com.mangopay.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Configuration settings.
 */
public class Configuration {

    public static final String
            VERSION_2 = "v2",
            VERSION_2_01 = "v2.01";

    /**
     * Client identifier.
     */
    private String clientId = "";

    /**
     * Client password.
     */
    private String clientPassword = "";

    /**
     * Base URL to MangoPay API.
     */
    private String baseUrl = "https://api.sandbox.mangopay.com";

    /**
     * [INTERNAL USAGE ONLY] Switch debug mode: log all request and response data.
     */
    private boolean debugMode = false;

    /**
     * Connection Timeout.
     */
    private int connectTimeout = 60000;

    /**
     * Connection Read Timeout.
     */
    private int readTimeout = 60000;

    /**
     * Mangopay SDK Version
     */
    private String version;

    /**
     * Mangopay API Version
     */
    private String apiVersion = VERSION_2_01;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public boolean isDebugMode() {
        return debugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.debugMode = debugMode;
    }

    /**
     * Get Connection Timeout
     *
     * @return int Connection Timeout in millis.
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Set Connection Timeout
     *
     * @param connectTimeout connection timeout in millis.
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * Get Connection Read Timeout
     *
     * @return int Connection Timeout in millis.
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Set Connection Read Timeout
     *
     * @param readTimeout connection read timeout in millis.
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }


    /**
     * Get Mangopay SDK Version
     *
     * @return String Mangopay Version
     */
    public String getVersion() {
        if (ObjectTool.isNull(version)) {
            version = readMangopayVersion();
        }
        return version;
    }

    /**
     * Get Mangopay API Version
     *
     * @return String Mangopay API Version
     */
    public String getApiVersion() {
        return apiVersion;
    }

    /**
     * Set the Mangopay API Version to use
     *
     * @param apiVersion The API Version to use (as defined in {@link Configuration}
     */
    public void setApiVersion(String apiVersion) {
        if (!(apiVersion.equals(VERSION_2) || apiVersion.equals(VERSION_2_01))) {
            throw new RuntimeException("Invalid API Version");
        }
        this.apiVersion = apiVersion;
    }

    /**
     * Read Mangopay version from mangopay properties
     *
     * @return String Mangopay Version
     */
    private String readMangopayVersion() {
        try {
            Properties prop = new Properties();
            InputStream input = getClass().getResourceAsStream("mangopay.properties");
            prop.load(input);
            return prop.getProperty("version");
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "unknown";
    }
}
