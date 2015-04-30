package com.mangopay.core.interfaces;

import com.mangopay.core.OAuthToken;

/**
 * Storage strategy interface.
 */
public interface IStorageStrategy {
    
    OAuthToken get();
    
    void store(OAuthToken token);
    
}
