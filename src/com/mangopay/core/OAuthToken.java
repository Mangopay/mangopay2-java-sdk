package com.mangopay.core;

import com.mangopay.core.Dto;
import java.io.Serializable;

/**
 * OAuth entity.
 */
public class OAuthToken extends Dto implements Serializable {

    /**
     * Created time.
     */
    private Long create_time;
    
    /**
     * Value of token.
     */
    public String access_token;
    
    /**
     * Token type.
     */
    public String token_type;
    
    /**
     * How long the token is valid, in seconds.
     */
    public int expires_in;
    
    /**
     * Constructor.
     */
    public OAuthToken() {
        create_time = System.currentTimeMillis() - 5000;
    }
    
    /**
     * Checks if current token is expired.
     */
    public Boolean IsExpired() {
        return (System.currentTimeMillis() >= (create_time + (expires_in * 1000)));
    }
    
    // for debug purposes
    @Override
    public String toString() {
        
        return "access_token = " + this.access_token + ", token_type: " + this.token_type + ", expires_in: " + this.expires_in;
        
    }
}
