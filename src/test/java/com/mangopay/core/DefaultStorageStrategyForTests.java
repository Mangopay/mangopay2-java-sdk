package com.mangopay.core;

import com.mangopay.core.interfaces.StorageStrategy;
import java.util.HashMap;
import java.util.Map;

/**
 * Default token storage strategy implementation for tests.
 */
public class DefaultStorageStrategyForTests implements StorageStrategy {

    private static Map<String, OAuthToken> _oAuthToken = new HashMap<>();
    
    /**
     * Gets the currently stored token.
     * @param envKey Environment key for token.
     * @return Currently stored token instance or null.
     */
    @Override
    public OAuthToken get(String envKey) {
        if (!_oAuthToken.containsKey(envKey)) return null;
        
        return _oAuthToken.get(envKey);
    }

    /**
     * Stores authorization token passed as an argument.
     * @param token Token instance to be stored.
     * @param envKey Environment key for token.
     */
    @Override
    public void store(OAuthToken token, String envKey) {
        _oAuthToken.put(envKey, token);
    }
    
}