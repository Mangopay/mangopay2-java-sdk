package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

/**
 * Holds document page viewing data.
 */
public class DocumentPageConsult extends Dto {

    /**
     * URL where this document page can be viewed.
     */
    @SerializedName("Url")
    private String url;

    /**
     * Time in millis when the page consult will expire.
     */
    @SerializedName("ExpirationDate")
    private long expirationDate;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public long getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(long expirationDate) {
        this.expirationDate = expirationDate;
    }
}
