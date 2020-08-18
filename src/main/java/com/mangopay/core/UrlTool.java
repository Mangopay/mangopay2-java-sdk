package com.mangopay.core;

import com.mangopay.MangoPayApi;

import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Helper class to manage URLs.
 */
class UrlTool {

    /**
     * Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    private MangoPayApi root;

    /**
     * Instantiates new UrlTool object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public UrlTool(MangoPayApi root) {
        this.root = root;
    }

    private String getHost() throws Exception {

        if (root.getConfig().getBaseUrl() == null || root.getConfig().getBaseUrl().length() == 0)
            throw new Exception("MangoPayApi.config.BaseUrl setting is not defined.");

        URL baseUrl = new URL(root.getConfig().getBaseUrl());

        return baseUrl.getHost();
    }

    /**
     * Gets REST url.
     *
     * @param urlKey Url key.
     * @return Final REST url.
     * @throws UnsupportedEncodingException
     */
    public String getRestUrl(String urlKey) throws UnsupportedEncodingException {
        return getRestUrl(urlKey, true, null, null);
    }

    /**
     * Gets REST url.
     *
     * @param urlKey      Url key.
     * @param addClientId Denotes whether client identifier should be composed into final url.
     * @return Final REST url.
     * @throws UnsupportedEncodingException
     */
    public String getRestUrl(String urlKey, Boolean addClientId) throws UnsupportedEncodingException {
        return getRestUrl(urlKey, addClientId, null, null);
    }

    /**
     * Gets REST url.
     *
     * @param urlKey      Url key.
     * @param addClientId Denotes whether client identifier should be composed into final url.
     * @param pagination  Pagination object.
     * @return Final REST url.
     * @throws UnsupportedEncodingException
     */
    public String getRestUrl(String urlKey, Boolean addClientId, Pagination pagination) throws UnsupportedEncodingException {
        return getRestUrl(urlKey, addClientId, pagination, null);
    }

    /**
     * Gets REST url.
     *
     * @param urlKey              Url key.
     * @param addClientId         Denotes whether client identifier should be composed into final url.
     * @param pagination          Pagination object.
     * @param additionalUrlParams Additional parameters.
     * @return Final REST url.
     * @throws UnsupportedEncodingException
     */
    public String getRestUrl(String urlKey, Boolean addClientId, Pagination pagination, Map<String, String> additionalUrlParams) throws UnsupportedEncodingException {

        String url;

        if (!addClientId) {
            url = "/v2.01" + urlKey;
        } else {
            url = "/v2.01/" + root.getConfig().getClientId() + urlKey;
        }

        Boolean paramsAdded = false;
        if (pagination != null) {
            url += "?page=" + pagination.getPage() + "&per_page=" + pagination.getItemsPerPage();
            paramsAdded = true;
        }

        if (additionalUrlParams != null) {
            for (Entry<String, String> entry : additionalUrlParams.entrySet()) {
                url += paramsAdded ? "&" : "?";
                url += entry.getKey() + "=" + URLEncoder.encode(entry.getValue(), "ISO-8859-1");
                paramsAdded = true;
            }
        }

        return url;
    }

    /**
     * Gets complete url.
     *
     * @param restUrl Rest url.
     * @return Complete url.
     */
    public String getFullUrl(String restUrl) {

        String result = "";

        try {
            int port = new URL(root.getConfig().getBaseUrl()).getPort();
            String protocol = new URL(root.getConfig().getBaseUrl()).getProtocol() + "://" + this.getHost();
            if (port > 0) {
                result = protocol + ":" + port + restUrl;
            } else {
                result = protocol + restUrl;
            }
        } catch (Exception ex) {
        }

        return result;
    }
}
