package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class BrowserInfo extends Dto {
    @SerializedName("AcceptHeader")
    private String acceptHeader;

    @SerializedName("JavaEnabled")
    private Boolean javaEnabled;

    @SerializedName("JavascriptEnabled")
    private Boolean javascriptEnabled;

    @SerializedName("Language")
    private String language;

    @SerializedName("ColorDepth")
    private Integer colorDepth;

    @SerializedName("ScreenHeight")
    private Integer screenHeight;

    @SerializedName("ScreenWidth")
    private Integer screenWidth;

    @SerializedName("TimeZoneOffset")
    private String timeZoneOffset;

    @SerializedName("UserAgent")
    private String userAgent;

    public String getAcceptHeader() {
        return acceptHeader;
    }

    public BrowserInfo setAcceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
        return this;
    }

    public Boolean getJavaEnabled() {
        return javaEnabled;
    }

    public BrowserInfo setJavaEnabled(Boolean javaEnabled) {
        this.javaEnabled = javaEnabled;
        return this;
    }

    public Boolean getJavascriptEnabled() {
        return javascriptEnabled;
    }

    public BrowserInfo setJavascriptEnabled(Boolean javascriptEnabled) {
        this.javascriptEnabled = javascriptEnabled;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public BrowserInfo setLanguage(String language) {
        this.language = language;
        return this;
    }

    public int getColorDepth() {
        return colorDepth;
    }

    public BrowserInfo setColorDepth(Integer colorDepth) {
        this.colorDepth = colorDepth;
        return this;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public BrowserInfo setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
        return this;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public BrowserInfo setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
        return this;
    }

    public String getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public BrowserInfo setTimeZoneOffset(String timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
        return this;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public BrowserInfo setUserAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }
}
