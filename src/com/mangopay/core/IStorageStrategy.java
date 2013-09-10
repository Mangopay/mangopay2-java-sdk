package com.mangopay.core;

/**
 * Storage strategy interface.
 */
public interface IStorageStrategy {
    
    OAuthToken get();
    
    void store(OAuthToken token);
    
}
