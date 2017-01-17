package com.mangopay.core;

import com.mangopay.MangoPayApi;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for holding authentication token in instance
 */
public class TokensTest extends BaseTest {

    @Test
    public void forceToken() throws Exception {

        OAuthToken oldToken = this.api.getOAuthTokenManager().getToken();
        OAuthToken newToken = this.api.getAuthenticationManager().createToken();

        assertFalse(oldToken.getAccessToken().equals(newToken.getAccessToken()));

        this.api.getOAuthTokenManager().storeToken(newToken);
        OAuthToken storedToken = this.api.getOAuthTokenManager().getToken();

        assertEquals(newToken.getAccessToken(), storedToken.getAccessToken());
    }

    @Test
    public void standardUseOfToken() throws Exception {
        this.api.getUsers().getAll();
        OAuthToken token = this.api.getOAuthTokenManager().getToken();
        this.api.getUsers().getAll();

        assertEquals(token.getAccessToken(), this.api.getOAuthTokenManager().getToken().getAccessToken());
    }

    @Test
    public void shareTokenBetweenInstances() throws Exception {
        MangoPayApi api = this.buildNewMangoPayApi();

        OAuthToken token1 = this.api.getOAuthTokenManager().getToken();
        OAuthToken token2 = api.getOAuthTokenManager().getToken();

        assertEquals(token1.getAccessToken(), token2.getAccessToken());
    }

    @Test
    public void isolateTokensBetweenEnvironments() throws Exception {
        MangoPayApi api = new MangoPayApi();
        api.getConfig().setClientId("sdk-unit-tests");
        api.getConfig().setClientPassword("cqFfFrWfCcb7UadHNxx2C9Lo6Djw8ZduLi7J9USTmu8bhxxpju");
        api.getConfig().setBaseUrl("https://api.sandbox.mangopay.com");

        OAuthToken token1 = api.getOAuthTokenManager().getToken();

        api.getConfig().setClientId("sdk_example");
        api.getConfig().setClientPassword("Vfp9eMKSzGkxivCwt15wE082pTTKsx90vBenc9hjLsf5K46ciF");
        api.getConfig().setBaseUrl("https://api.sandbox.mangopay.com");

        OAuthToken token2 = api.getOAuthTokenManager().getToken();

        assertNotEquals(token1.getAccessToken(), token2.getAccessToken());

        api.getConfig().setClientId("sdk-unit-tests");
        api.getConfig().setClientPassword("cqFfFrWfCcb7UadHNxx2C9Lo6Djw8ZduLi7J9USTmu8bhxxpju");
        api.getConfig().setBaseUrl("https://api.sandbox.mangopay.com");

        OAuthToken token3 = api.getOAuthTokenManager().getToken();

        assertEquals(token1.getAccessToken(), token3.getAccessToken());
    }
}
