package com.mangopay.core;

/**
 * Configuration settings.
 */
public class Configuration {

    /**
     * Client identifier.
     *
     * @deprecated Use {@link #getClientId()} and {@link #setClientId(String)} instead.
     */
    @Deprecated
    public String ClientId = "";

    /**
     * Client password.
     *
     * @deprecated Use {@link #getClientPassword()} and {@link #setClientPassword(String)} instead.
     */
    @Deprecated
    public String ClientPassword = "";

    /**
     * Base URL to MangoPay API.
     *
     * @deprecated Use {@link #getBaseUrl()} and {@link #setBaseUrl(String)} instead.
     */
    @Deprecated
    public String BaseUrl = "https://api.sandbox.mangopay.com";

    /**
     * [INTERNAL USAGE ONLY] Switch debug mode: log all request and response data.
     *
     * @deprecated Use {@link #isDebugMode()} and {@link #setDebugMode(boolean)} instead.
     */
    @Deprecated
    public boolean DebugMode = true;

    /**
     * Connection Timeout.
     */
    private int connectTimeout = 60000;

    /**
     * Connection Read Timeout.
     */
    private int readTimeout = 60000;

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        this.ClientId = clientId;
    }

    public String getClientPassword() {
        return ClientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.ClientPassword = clientPassword;
    }

    public String getBaseUrl() {
        return BaseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.BaseUrl = baseUrl;
    }

    public boolean isDebugMode() {
        return DebugMode;
    }

    public void setDebugMode(boolean debugMode) {
        this.DebugMode = debugMode;
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
