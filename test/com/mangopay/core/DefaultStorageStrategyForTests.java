package com.mangopay.core;

/**
 * Default token storage strategy implementation for tests.
 */
public class DefaultStorageStrategyForTests implements IStorageStrategy {

    private static OAuthToken _oAuthToken = null;
    
    /**
     * Gets the currently stored token.
     * @return Currently stored token instance or null.
     */
    @Override
    public OAuthToken get() {
        return _oAuthToken;
    }

    /**
     * Stores authorization token passed as an argument.
     * @param token Token instance to be stored.
     */
    @Override
    public void store(OAuthToken token) {
        _oAuthToken = token;
    }
    
}