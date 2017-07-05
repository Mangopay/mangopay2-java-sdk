package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

/**
 * IdempotencyResponse entity.
 */
public class IdempotencyResponse extends EntityBase {

    @SerializedName("StatusCode")
    private String statusCode;

    @SerializedName("ContentLength")
    private String contentLength;

    @SerializedName("ContentType")
    private String contentType;

    @SerializedName("Date")
    private String date;

    @SerializedName("Resource")
    private Object resource;

    @SerializedName("RequestURL")
    private String requestUrl;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getContentLength() {
        return contentLength;
    }

    public void setContentLength(String contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Object getResource() {
        return resource;
    }

    public void setResource(Object resource) {
        this.resource = resource;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
