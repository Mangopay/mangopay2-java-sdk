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
     * Set to true for uk traffic
     * @deprecated Will be removed in future versions
     */
    @Deprecated
    private boolean ukHeaderFlag = false;
    

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

    public boolean isUkHeaderFlag() {
        return ukHeaderFlag;
    }

    public void setUkHeaderFlag(boolean ukHeaderFlag) {
        this.ukHeaderFlag = ukHeaderFlag;
    }

    /**
     * Get Mangopay SDK Version
     * @return String Mangopay Version
     */
    public String getVersion() {
        if (ObjectTool.isNull(version)) {
            version = readMangopayVersion();
        }
        return version;
    }

    /**
     * Read Mangopay version from mangopay properties
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
