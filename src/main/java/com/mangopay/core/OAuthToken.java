package com.mangopay.core;

import java.io.Serializable;

/**
 * OAuth entity.
 */
public class OAuthToken extends Dto implements Serializable {

    /**
     * Creation time.
     *
     * @deprecated Use {@link #getCreateTime()} and {@link #setCreateTime(Long)} instead.
     */
    @Deprecated
    public Long create_time;

    /**
     * Value of token.
     *
     * @deprecated Use {@link #getAccessToken()} and {@link #setAccessToken(String)} instead.
     */
    @Deprecated
    public String access_token;

    /**
     * Token type.
     *
     * @deprecated Use {@link #getTokenType()} and {@link #setToken_type(String)} instead.
     */
    @Deprecated
    public String token_type;

    /**
     * Denotes how long the token is valid, in seconds.
     *
     * @deprecated Use {@link #getExpiresIn()} and {@link #setExpiresIn(int)} instead.
     */
    @Deprecated
    public int expires_in;

    /**
     * Instantiates new OAuthToken object.
     */
    public OAuthToken() {
        this.create_time = System.currentTimeMillis() - 5000;
    }

    public Long getCreateTime() {
        return create_time;
    }

    public void setCreateTime(Long createTime) {
        this.create_time = createTime;
    }

    public String getAccessToken() {
        return access_token;
    }

    public void setAccessToken(String accessToken) {
        this.access_token = accessToken;
    }

    public String getTokenType() {
        return token_type;
    }

    public void setToken_type(String tokenType) {
        this.token_type = tokenType;
    }

    public int getExpiresIn() {
        return expires_in;
    }

    public void setExpiresIn(int expiresIn) {
        this.expires_in = expiresIn;
    }

    /**
     * Checks if current token is expired.
     *
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
