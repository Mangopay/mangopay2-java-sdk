package com.mangopay.core;

/**
 * Response exception class.
 */
public class ResponseException extends Exception {
    
    public ResponseException() { }

    public ResponseException(String message) {
        super(message);
    }

    public ResponseException(Throwable cause) {
        super(cause);
    }

    public ResponseException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
