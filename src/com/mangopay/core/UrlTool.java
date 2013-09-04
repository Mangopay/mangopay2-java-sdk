package com.mangopay.core;

import com.mangopay.MangoPayApi;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Class to manage URLs.
 */
class UrlTool {

    /**
     * Root/parent instance that holds the OAuthToken and Configuration instance
     */
    private MangoPayApi _root;

    /**
     * Creates new UrlTool object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public UrlTool(MangoPayApi root) {
        this._root = root;
    }
    
    private String getHost() throws Exception{
        
        if (_root.Config.BaseUrl == null || _root.Config.BaseUrl.length() == 0)
            throw new Exception ("MangoPayApi.Config.BaseUrl setting is not defined.");
        
        URL baseUrl = new URL(_root.Config.BaseUrl);
        
        return baseUrl.getHost();
    }
    
    /**
     * 
     * @param urlKey
     * @return
     * @throws UnsupportedEncodingException 
     */
    public String getRestUrl(String urlKey) throws UnsupportedEncodingException {
        return getRestUrl(urlKey, true, null, null);
    }
    
    /**
     * 
     * @param urlKey
     * @param addClientId
     * @return
     * @throws UnsupportedEncodingException 
     */
    public String getRestUrl(String urlKey, Boolean addClientId) throws UnsupportedEncodingException {
        return getRestUrl(urlKey, addClientId, null, null);
    }
    
    /**
     * 
     * @param urlKey
     * @param addClientId
     * @param pagination
     * @return
     * @throws UnsupportedEncodingException 
     */
    public String getRestUrl(String urlKey, Boolean addClientId, Pagination pagination) throws UnsupportedEncodingException {
        return getRestUrl(urlKey, addClientId, pagination, null);
    }
    
    /**
     * 
     * @param urlKey
     * @param addClientId
     * @param pagination
     * @param additionalUrlParams
     * @return
     * @throws UnsupportedEncodingException 
     */
    public String getRestUrl(String urlKey, Boolean addClientId, Pagination pagination, Map<String, String> additionalUrlParams) throws UnsupportedEncodingException {

        String url;
        
        if (!addClientId) {
            url = "/v2" + urlKey;
        } else {
            url = "/v2/" + _root.Config.ClientId + urlKey;
        }

        Boolean paramsAdded = false;
        if (pagination != null) {
            url += "?page=" + pagination.Page + "&per_page=" + pagination.ItemsPerPage;
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
     * 
     * @param restUrl
     * @return 
     */
    public String getFullUrl(String restUrl) {
        
        String result = "";
        
        try {
            result = (new URL(_root.Config.BaseUrl)).getProtocol() + "://" + this.getHost() + restUrl;
        }
        catch (Exception ex) { }
        
        return result;
    } 
}
