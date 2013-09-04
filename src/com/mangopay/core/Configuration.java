package com.mangopay.core;

/**
 * Configuration settings
 */
public class Configuration {

    /**
     * Client Id
     */
    public String ClientId = "";
    
    /**
     * Client password
     */
    public String ClientPassword = "";
    
    /**
     * Base URL to MangoPay API
     */
    public String BaseUrl = "https://mangopay-api-inte.leetchi.com";
    
    /**
     * [INTERNAL USAGE ONLY] Switch debug mode: log all request and response data
     */
    public boolean DebugMode = false;
    
//    /**
//     * [readonly] Authentication type - always of value "Strong"
//     */
//    public String AuthenticationType = "Strong";

}
