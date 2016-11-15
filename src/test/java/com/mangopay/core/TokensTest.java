package com.mangopay.core;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mangopay.MangoPayApi;

/**
 * Tests for holding authentication token in instance
 */
public class TokensTest extends BaseTest {

    @Test
    public void forceToken() throws Exception {
        
        OAuthToken oldToken = this.api.OAuthTokenManager.getToken();
        OAuthToken newToken = this.api.AuthenticationManager.createToken();
        
        assertFalse(oldToken.access_token.equals(newToken.access_token));
        
        this.api.OAuthTokenManager.storeToken(newToken);
        OAuthToken storedToken = this.api.OAuthTokenManager.getToken();
        
        assertEquals(newToken.access_token, storedToken.access_token);
    }
    
    @Test
    public void standardUseOfToken() throws Exception {
        this.api.Users.getAll();
        OAuthToken token = this.api.OAuthTokenManager.getToken();
        this.api.Users.getAll();
        
        assertEquals(token.access_token, this.api.OAuthTokenManager.getToken().access_token);
    }
    
    @Test
    public void shareTokenBetweenInstances() throws Exception {
        MangoPayApi api = this.buildNewMangoPayApi();
        
        OAuthToken token1 = this.api.OAuthTokenManager.getToken();
        OAuthToken token2 = api.OAuthTokenManager.getToken();
        
        assertEquals(token1.access_token, token2.access_token);
    }
    
    @Test
    public void isolateTokensBetweenEnvironments() throws Exception {
        MangoPayApi api = new MangoPayApi();
        api.Config.ClientId = "sdk-unit-tests";
        api.Config.ClientPassword = "cqFfFrWfCcb7UadHNxx2C9Lo6Djw8ZduLi7J9USTmu8bhxxpju";
        api.Config.BaseUrl = "https://api.sandbox.mangopay.com";
        
        OAuthToken token1 = api.OAuthTokenManager.getToken();
        
        api.Config.ClientId = "sdk_example";
        api.Config.ClientPassword = "Vfp9eMKSzGkxivCwt15wE082pTTKsx90vBenc9hjLsf5K46ciF";
        api.Config.BaseUrl = "https://api.sandbox.mangopay.com";
        
        OAuthToken token2 = api.OAuthTokenManager.getToken();
        
        assertNotEquals(token1.access_token, token2.access_token);
        
        api.Config.ClientId = "sdk-unit-tests";
        api.Config.ClientPassword = "cqFfFrWfCcb7UadHNxx2C9Lo6Djw8ZduLi7J9USTmu8bhxxpju";
        api.Config.BaseUrl = "https://api.sandbox.mangopay.com";
        
        OAuthToken token3 = api.OAuthTokenManager.getToken();
        
        assertEquals(token1.access_token, token3.access_token);
    }
}
