package com.mangopay.core;

import com.mangopay.MangoPayApi;
import java.util.*;

/**
 * Authentication helper class.
 */
public class AuthenticationHelper {
    
    /**
     * Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    private MangoPayApi root;
    
    /**
     * Instantiates new AuthenticationHelper object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public AuthenticationHelper(MangoPayApi root) throws Exception {
        this.root = root;
    }
    
    /**
     * Gets HTTP header value with authorization string.
     * @return
     * @throws Exception
     */
    public Map<String, String> getHttpHeaderKey() throws Exception {
        return getHttpHeaderStrong();
    }
    
    /**
     * Gets basic key for HTTP header.
     * @return  Authorization string.
     * @throws Exception
     */
    public String getHttpHeaderBasicKey() throws Exception {
        if (root.getConfig().getClientId() == null || root.getConfig().getClientId().length() == 0)
            throw new Exception ("MangoPay.config.ClientId is not set.");
        
        if (root.getConfig().getClientPassword() == null || root.getConfig().getClientPassword().length() == 0)
            throw new Exception ("MangoPay.config.ClientPassword is not set.");
        
        String signature = root.getConfig().getClientId() + ':' + root.getConfig().getClientPassword();
        
        return Base64Encoder.encode(signature);
    }
    
    // gets HTTP header value with authorization string for basic authentication
    private Map<String, String> getHttpHeaderBasic() throws Exception {
        
        return new HashMap<String, String>(){{
            put("Authorization", "Basic " + getHttpHeaderBasicKey());
        }};
    }
    
    // gets HTTP header value with authorization string for strong authentication
    private Map<String, String> getHttpHeaderStrong() throws Exception {
        
        final OAuthToken token = root.getOAuthTokenManager().getToken();
        
        if (token == null || token.getAccessToken().length() == 0 || token.getTokenType().length() == 0)
            throw new Exception ("OAuth token is not created (or is invalid) for strong authentication");
                
        return new HashMap<String, String>(){{
            put("Authorization", token.getTokenType() + " " + token.getAccessToken());
        }};
    }
}
