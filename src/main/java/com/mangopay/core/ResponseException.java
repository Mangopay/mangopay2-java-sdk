package com.mangopay.core;

import java.util.HashMap;

/**
 * Response exception class.
 */
public class ResponseException extends Exception {

    /**
     * HTTP error code.
     *
     * @deprecated Use {@link #getResponseHttpCode()} and {@link #setResponseHttpCode(int)} instead.
     */
    @Deprecated
    public int ResponseHttpCode;

    /**
     * HTTP error description.
     *
     * @deprecated Use {@link #getResponseHttpDescription()} and {@link #setResponseHttpDescription(String)} instead.
     */
    @Deprecated
    public String ResponseHttpDescription;

    /**
     * API error message.
     *
     * @deprecated Use {@link #getApiMessage()} and {@link #setApiMessage(String)} instead.
     */
    @Deprecated
    public String ApiMessage;

    /**
     * API error type.
     *
     * @deprecated Use {@link #getType()} and {@link #setType(String)} instead.
     */
    @Deprecated
    public String Type;

    /**
     * API error identifier.
     *
     * @deprecated Use {@link #getId()} and {@link #setId(String)} instead.
     */
    @Deprecated
    public String Id;

    /**
     * API error timestamp.
     *
     * @deprecated Use {@link #getDate()} and {@link #setDate(int)} instead.
     */
    @Deprecated
    public int Date;

    /**
     * List of detailed errors.
     *
     * @deprecated Use {@link #getErrors()} and {@link #setErrors(HashMap)} instead.
     */
    @Deprecated
    public HashMap<String, String> Errors;

    /**
     * Instantiates new ResponseException object.
     */
    public ResponseException() {
        Errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     *
     * @param message JSON data that came as a response from API.
     */
    public ResponseException(String message) {
        super(message);
        Errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     *
     * @param cause Throwable object.
     */
    public ResponseException(Throwable cause) {
        super(cause);
        Errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     *
     * @param message JSON data that came as a response from API.
     * @param cause   Throwable object.
     */
    public ResponseException(String message, Throwable cause) {
        super(message, cause);
        Errors = new HashMap<>();
    }

    public int getResponseHttpCode() {
        return ResponseHttpCode;
    }

    public void setResponseHttpCode(int responseHttpCode) {
        this.ResponseHttpCode = responseHttpCode;
    }

    public String getResponseHttpDescription() {
        return ResponseHttpDescription;
    }

    public void setResponseHttpDescription(String responseHttpDescription) {
        this.ResponseHttpDescription = responseHttpDescription;
    }

    public String getApiMessage() {
        return ApiMessage;
    }

    public void setApiMessage(String apiMessage) {
        this.ApiMessage = apiMessage;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        this.Id = id;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        this.Date = date;
    }

    public HashMap<String, String> getErrors() {
        return Errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.Errors = errors;
    }
}
