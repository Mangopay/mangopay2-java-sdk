package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * IdempotencyResponse entity.
 */
public class IdempotencyResponse extends EntityBase {

    /**
     * @deprecated Use {@link #getStatusCode()} and {@link #setStatusCode(String)} instead.
     */
    @Deprecated
    public String StatusCode;

    /**
     * @deprecated Use {@link #getContentLength()} and {@link #setContentLength(String)} instead.
     */
    @Deprecated
    public String ContentLength;

    /**
     * @deprecated Use {@link #getContentType()} and {@link #setContentType(String)} instead.
     */
    @Deprecated
    public String ContentType;

    /**
     * @deprecated Use {@link #getDate()} and {@link #setDate(String)} instead.
     */
    @Deprecated
    public String Date;

    /**
     * @deprecated Use {@link #getResource()}  and {@link #setResource(Object)} instead.
     */
    @Deprecated
    public Object Resource;

    /**
     * @deprecated Use {@link #getRequestURL()} and {@link #setRequestURL(String)}  instead.
     */
    @Deprecated
    public String RequestURL;

    public String getStatusCode() {
        return StatusCode;
    }

    public void setStatusCode(String statusCode) {
        this.StatusCode = statusCode;
    }

    public String getContentLength() {
        return ContentLength;
    }

    public void setContentLength(String contentLength) {
        this.ContentLength = contentLength;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String contentType) {
        this.ContentType = contentType;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        this.Date = date;
    }

    public Object getResource() {
        return Resource;
    }

    public void setResource(Object resource) {
        this.Resource = resource;
    }

    public String getRequestURL() {
        return RequestURL;
    }

    public void setRequestURL(String requestURL) {
        this.RequestURL = requestURL;
    }
}
