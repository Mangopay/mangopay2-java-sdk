package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import java.net.*;
import java.util.*;
import java.util.logging.*;

/**
 * API for OAuth.
 */
public class ApiOAuth extends ApiBase {

    /**
     * Instantiates new ApiOAuth object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiOAuth(MangoPayApi root) { super(root); }

    /**
     * Gets the new token used for requests authentication.
     * @return OAuth object with token information.
     */
    public OAuthToken createToken() throws Exception {
        
        String urlMethod = this.getRequestUrl("authentication_oauth");
        String requestType = this.getRequestType("authentication_oauth");
        Map<String, String> requestData = new HashMap<String, String>(){{
            put("grant_type", "client_credentials");
        }};
        
        RestTool rest = new RestTool(this.root, false);
        AuthenticationHelper authHlp = new AuthenticationHelper(root);
        
        try {
            rest.addRequestHttpHeader("Host", (new URL(root.getConfig().getBaseUrl())).getHost());
        } catch (MalformedURLException ex) {
            Logger.getLogger(ApiOAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rest.addRequestHttpHeader("Authorization", "Basic " + authHlp.getHttpHeaderBasicKey());
        } catch (Exception ex) {
            Logger.getLogger(ApiOAuth.class.getName()).log(Level.SEVERE, null, ex);
        }
        rest.addRequestHttpHeader("Content-Type", "application/x-www-form-urlencoded");
        OAuthToken response = rest.request(OAuthToken.class, null, urlMethod, requestType, requestData);
        
        return response;
    }
}
