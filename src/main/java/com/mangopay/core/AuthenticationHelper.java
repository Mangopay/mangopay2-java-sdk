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
        if (root.Config.ClientId == null || root.Config.ClientId.length() == 0)
            throw new Exception ("MangoPay.Config.ClientId is not set.");
        
        if (root.Config.ClientPassword == null || root.Config.ClientPassword.length() == 0)
            throw new Exception ("MangoPay.Config.ClientPassword is not set.");
        
        String signature = root.Config.ClientId + ':' + root.Config.ClientPassword;
        
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
        
        final OAuthToken token = root.OAuthTokenManager.getToken();
        
        if (token == null || token.access_token.length() == 0 || token.token_type.length() == 0)
            throw new Exception ("OAuth token is not created (or is invalid) for strong authentication");
                
        return new HashMap<String, String>(){{
            put("Authorization", token.token_type + " " + token.access_token);
        }};
    }
}
