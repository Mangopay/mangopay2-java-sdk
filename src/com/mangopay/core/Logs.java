package com.mangopay.core;

/**
 * Class to manage logs in MangoPay SDK
 */
public class Logs {
    
    /**
     *
     * @param message
     * @param data
     */
    public static void debug(String message, Object data) {
        
        System.out.println(message + ": " + data);
        System.out.println("-------------------------------");
    }
}
