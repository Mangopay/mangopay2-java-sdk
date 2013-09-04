package com.mangopay.core;

import com.mangopay.MangoPayApi;
import java.util.HashMap;
import java.util.Map;

/**
 * AuthenticationHelper class
 */
class AuthenticationHelper {
    
    /**
     * Root/parent instance that holds the OAuthToken and Configuration instance
     */
    private MangoPayApi _root;
    
    /**
     * Construct
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public AuthenticationHelper(MangoPayApi root) throws Exception {
        this._root = root;
    }
    
    /**
     * Get HTTP header value with authorization string
     */
    public Map<String, String> getHttpHeaderKey() throws Exception {
        return getHttpHeaderStrong();
//        switch (_root.Config.AuthenticationType) {
//            case Basic:
//                return this.getHttpHeaderBasic();
//            case Strong:
//                return this.getHttpHeaderStrong();
//            default:
//                return new HashMap<>();
    }
    
    /**
     * Get basic key for HTTP header
     */
    public String getHttpHeaderBasicKey() throws Exception {
        if (_root.Config.ClientId == null || _root.Config.ClientId.length() == 0)
            throw new Exception ("MangoPay.Config.ClientId is not set.");
        
        if (_root.Config.ClientPassword == null || _root.Config.ClientPassword.length() == 0)
            throw new Exception ("MangoPay.Config.ClientPassword is not set.");
        
        String signature = _root.Config.ClientId + ':' + _root.Config.ClientPassword;
        
        return Base64Encoder.encode(signature);
    }
    
    /**
     * Get HTTP header value with authorization string for basic authentication
     */
    private Map<String, String> getHttpHeaderBasic() throws Exception {
        
        return new HashMap<String, String>(){{
            put("Authorization", "Basic " + getHttpHeaderBasicKey());
        }};
    }
    
    /**
     * Get HTTP header value with authorization string for strong authentication
     */
    private Map<String, String> getHttpHeaderStrong() throws Exception{
        if (_root.OAuthToken == null || _root.OAuthToken.access_token.length() == 0 || _root.OAuthToken.token_type.length() == 0)
            throw new Exception ("OAuth token is not created (or is invalid) for strong authentication");
                
        return new HashMap<String, String>(){{
            put("Authorization", _root.OAuthToken.token_type + " " + _root.OAuthToken.access_token);
        }};
    }
}
