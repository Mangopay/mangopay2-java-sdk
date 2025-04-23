package com.mangopay.core;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

/**
 * Response exception class.
 */
public class ResponseException extends Exception {

    /**
     * HTTP error code.
     */
    @SerializedName("ResponseHttpCode")
    private int responseHttpCode;

    /**
     * HTTP error description.
     */
    @SerializedName("ResponseHttpDescription")
    private String responseHttpDescription;

    /**
     * API error message.
     */
    @SerializedName("ApiMessage")
    private String apiMessage;

    /**
     * API error type.
     */
    @SerializedName("Type")
    private String type;

    /**
     * API error identifier.
     */
    @SerializedName("Id")
    private String id;

    /**
     * API error timestamp.
     */
    @SerializedName("Date")
    private int date;

    /**
     * List of detailed errors.
     */
    @SerializedName("Errors")
    private HashMap<String, String> errors;

    /**
     * Additional data related to the exception
     */
    private Map<String, String> data;

    /**
     * Instantiates new ResponseException object.
     */
    public ResponseException() {
        this.errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     *
     * @param message JSON data that came as a response from API.
     */
    public ResponseException(String message) {
        super(message);
        this.errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     *
     * @param cause Throwable object.
     */
    public ResponseException(Throwable cause) {
        super(cause);
        this.errors = new HashMap<>();
    }

    /**
     * Instantiates new ResponseException object.
     *
     * @param message JSON data that came as a response from API.
     * @param cause   Throwable object.
     */
    public ResponseException(String message, Throwable cause) {
        super(message, cause);
        this.errors = new HashMap<>();
    }

    public int getResponseHttpCode() {
        return responseHttpCode;
    }

    public void setResponseHttpCode(int responseHttpCode) {
        this.responseHttpCode = responseHttpCode;
    }

    public String getResponseHttpDescription() {
        return responseHttpDescription;
    }

    public void setResponseHttpDescription(String responseHttpDescription) {
        this.responseHttpDescription = responseHttpDescription;
    }

    public String getApiMessage() {
        return apiMessage;
    }

    public void setApiMessage(String apiMessage) {
        this.apiMessage = apiMessage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}
