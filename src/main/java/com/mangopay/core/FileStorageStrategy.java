package com.mangopay.core;

import com.mangopay.core.interfaces.StorageStrategy;

import java.io.*;
import java.util.logging.*;

/**
 * File token storage strategy implementation.
 */
public class FileStorageStrategy implements StorageStrategy {

    private String tempDir = null;
    
    /**
     * Instantiates FileStorageStrategy object.
     * @param tempDir Temporary directory path.
     */
    public FileStorageStrategy(String tempDir) {
        this.tempDir = tempDir;
    }
    
    /**
     * Gets the currently stored token.
     * @param envKey Environment key for token.
     * @return Currently stored token instance or null.
     */
    @Override
    public OAuthToken get(String envKey) {
        try
        {
           FileInputStream fileIn = new FileInputStream(getFilePath(envKey));
           ObjectInputStream in = new ObjectInputStream(fileIn);
           OAuthToken token = (OAuthToken) in.readObject();
           in.close();
           fileIn.close();
           return token;
        } catch (Exception ex)
        {
            return null; // it's not an error: e.g. file not found cause not stored yet
        }
    }

    /**
     * Stores authorization token passed as an argument.
     * @param token Token instance to be stored.
     * @param envKey Environment key for token.
     */
    @Override
    public void store(OAuthToken token, String envKey) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(getFilePath(envKey));
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(token);
            out.close();
            fileOut.close();
        } catch (Exception ex) {
            Logger.getLogger(FileStorageStrategy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String getFilePath(String envKey) { 
        return tempDir + getClass().getName() + envKey + ".tmp";
    }
}
