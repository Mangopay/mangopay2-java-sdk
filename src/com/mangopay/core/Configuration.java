package com.mangopay.core;

/**
 * Configuration settings.
 */
public class Configuration {

    /**
     * Client identifier.
     */
    public String ClientId = "";
    
    /**
     * Client password.
     */
    public String ClientPassword = "";
    
    /**
     * Base URL to MangoPay API.
     */
    public String BaseUrl = "https://api.sandbox.mangopay.com";
    
    /**
     * [INTERNAL USAGE ONLY] Switch debug mode: log all request and response data.
     */
    public boolean DebugMode = false;
    
    /**
     * Connection Timeout.
     */
    private int connectTimeout = 60000;
    
    /**
     * Connection Read Timeout.
     */
    private int readTimeout = 60000;

    /**
     * Get Connection Timeout
     * @return int Connection Timeout in millis.
     */
    public int getConnectTimeout() {
        return connectTimeout;
    }

    /**
     * Set Connection Timeout
     * @param connectTimeout connection timeout in millis.
     */
    public void setConnectTimeout(int connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    /**
     * Get Connection Read Timeout
     * @return int Connection Timeout in millis.
     */
    public int getReadTimeout() {
        return readTimeout;
    }

    /**
     * Set Connection Read Timeout
     * @param readTimeout connection read timeout in millis.
     */
    public void setReadTimeout(int readTimeout) {
        this.readTimeout = readTimeout;
    }
}
