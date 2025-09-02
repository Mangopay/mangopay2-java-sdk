package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * OAuth entity.
 */
public class OAuthToken extends Dto implements Serializable {

    /**
     * Creation time.
     */
    @SerializedName("create_time")
    private Long createTime;

    /**
     * Value of token.
     */
    @SerializedName("access_token")
    private String accessToken;

    /**
     * Token type.
     */
    @SerializedName("token_type")
    private String tokenType;

    /**
     * Denotes how long the token is valid, in seconds.
     */
    @SerializedName("expires_in")
    private int expiresIn;

    /**
     * Instantiates new OAuthToken object.
     */
    public OAuthToken() {
        this.createTime = System.currentTimeMillis() - 30000;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public int getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(int expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * Checks if current token is expired.
     *
     * @return Returns true if token has expired, or false if token is still valid.
     */
    public Boolean IsExpired() {
        return (System.currentTimeMillis() >= (createTime + (expiresIn * 1000)));
    }

    // for debug purposes
    @Override
    public String toString() {

        return "access_token = " + this.accessToken + ", token_type: " + this.tokenType + ", expires_in: " + this.expiresIn;

    }
}
