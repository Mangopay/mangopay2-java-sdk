package com.mangopay.core;

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
}
