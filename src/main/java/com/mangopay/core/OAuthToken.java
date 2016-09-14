package com.mangopay.core;

import java.io.Serializable;

/**
 * OAuth entity.
 */
public class OAuthToken extends Dto implements Serializable {

    /**
     * Creation time.
     */
    public Long create_time;
    
    /**
     * Value of token.
     */
    public String access_token;
    
    /**
     * Token type.
     */
    public String token_type;
    
    /**
     * Denotes how long the token is valid, in seconds.
     */
    public int expires_in;
    
    /**
     * Instantiates new OAuthToken object.
     */
    public OAuthToken() {
        create_time = System.currentTimeMillis() - 5000;
    }
    
    /**
     * Checks if current token is expired.
     * @return Returns true if token has expired, or false if token is still valid.
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
