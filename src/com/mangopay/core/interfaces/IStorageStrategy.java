package com.mangopay.core.interfaces;

import com.mangopay.core.OAuthToken;

/**
 * Storage strategy interface.
 */
public interface IStorageStrategy {
    
    OAuthToken get(String envKey);
    
    void store(OAuthToken token, String envKey);
    
}
