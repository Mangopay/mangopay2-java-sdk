package com.mangopay.core;

/**
 * Response exception class.
 */
public class ResponseException extends Exception {
    
    /**
     * Instantiates new ResponseException object.
     */
    public ResponseException() { }

    /**
     * Instantiates new ResponseException object.
     * @param message   JSON data that came as a response from API.
     */
    public ResponseException(String message) {
        super(message);
    }

    /**
     * Instantiates new ResponseException object.
     * @param cause     Throwable object.
     */
    public ResponseException(Throwable cause) {
        super(cause);
    }

    /**
     * Instantiates new ResponseException object.
     * @param message   JSON data that came as a response from API.
     * @param cause     Throwable object.
     */
    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
