package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.OAuthApi;
import com.mangopay.core.AuthenticationHelper;
import com.mangopay.core.OAuthToken;
import com.mangopay.core.RestTool;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * API for OAuth.
 */
public class OAuthApiImpl extends ApiBase implements OAuthApi {

    /**
     * Instantiates new OAuthApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public OAuthApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public OAuthToken createToken() throws Exception {

        String urlMethod = this.getRequestUrl("authentication_oauth");
        String requestType = this.getRequestType("authentication_oauth");
        Map<String, String> requestData = new HashMap<String, String>() {{
            put("grant_type", "client_credentials");
        }};

        RestTool rest = new RestTool(this.root, false, false);
        AuthenticationHelper authHlp = new AuthenticationHelper(root);

        try {
            rest.addRequestHttpHeader("Host", (new URL(root.getConfig().getBaseUrl())).getHost());
        } catch (MalformedURLException ex) {
            Logger.getLogger(OAuthApiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rest.addRequestHttpHeader("Authorization", "Basic " + authHlp.getHttpHeaderBasicKey());
        } catch (Exception ex) {
            Logger.getLogger(OAuthApiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        rest.addRequestHttpHeader("Content-Type", "application/x-www-form-urlencoded");
        rest.addRequestHttpHeader("User-Agent",  String.format("MangoPay V2 SDK Java %s", getRoot().getConfig().getVersion()));
        OAuthToken response = rest.request(OAuthToken.class, null, urlMethod, requestType, requestData);

        return response;
    }

}
