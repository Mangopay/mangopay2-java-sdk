package com.mangopay.core;

import java.util.HashMap;

/**
 * Response exception class.
 */
public class ResponseException extends Exception {
    
    /**
     * Instantiates new ResponseException object.
     */
    public ResponseException() {
        Errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     * @param message   JSON data that came as a response from API.
     */
    public ResponseException(String message) {
        super(message);
        Errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     * @param cause     Throwable object.
     */
    public ResponseException(Throwable cause) {
        super(cause);
        Errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     * @param message   JSON data that came as a response from API.
     * @param cause     Throwable object.
     */
    public ResponseException(String message, Throwable cause) {
        super(message, cause);
        Errors = new HashMap<>();
    }
    
    /**
     * HTTP error code.
     */
    public int ResponseHttpCode;
    
    /**
     * HTTP error description.
     */
    public String ResponseHttpDescription;
    
    /**
     * API error message.
     */
    public String ApiMessage;
    
    /**
     * API error type.
     */
    public String Type;
    
    /**
     * API error identifier.
     */
    public String Id;
    
    /**
     * API error timestamp.
     */
    public int Date;
    
    /**
     * List of detailed errors.
     */
    public HashMap<String, String> Errors;
}
