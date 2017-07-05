package com.mangopay.core.APIs;

import com.mangopay.core.OAuthToken;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface OAuthApi {

    /**
     * Gets the new token used for requests authentication.
     *
     * @return OAuth object with token information.
     */
    OAuthToken createToken() throws Exception;
}
