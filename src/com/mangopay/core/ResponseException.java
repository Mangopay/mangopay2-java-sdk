package com.mangopay.core;

import java.util.HashMap;
import java.util.Map;

/**
 * Response exception class.
 */
public class ResponseException extends Exception {
    
    /**
     * 
     * @param code 
     */
    public ResponseException(int code) {
        this(code, null);
    }
    
    /**
     * 
     * @param code
     * @param errorInfo 
     */
    public ResponseException(int code, Error errorInfo) {
        
        this._responseCodes = new HashMap<Integer, String>() {{

            put(200, "OK");
            put(206, "PartialContent");
            put(400, "Bad request");
            put(401, "Unauthorized");
            put(403, "Prohibition to use the method");
            put(404, "Not found");
            put(405, "Method not allowed");
            put(413, "Request entity too large");
            put(422, "Unprocessable entity");
            put(500, "Internal server error");
            put(501, "Not implemented");

        }};
        
//        this._code = code;
//        
//        if (_responseCodes.get(code) != null && _responseCodes.get(code).length() > 0) {
//            errorMsg = this._responseCodes.get(code);
//        } else {
//            errorMsg = "Unknown response error";
//        }
//        
//        if (errorInfo != null) {
//            errorMsg += ". " + errorInfo.Message;
//            this._errorInfo = errorInfo;
//        }
//        
//        parent::__construct($errorMsg, $code);
    }
    
    /**
     * Array with response code and corresponding response message
     * @var array 
     */
    private Map<Integer, String> _responseCodes;
    
    /**
     * Error details
     * @var Error 
     */
    private Error _errorInfo;
    
    /**
     * Get Error object returned by REST API
     * @return Error
     */
    public Error getErrorDetails(){
        return this._errorInfo;
    }
    
}
