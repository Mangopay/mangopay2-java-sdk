package com.mangopay.core;
import org.junit.Test;
import static org.junit.Assert.*;
import com.mangopay.MangoPayApi;

/**
 * Tests for holding authentication token in instance
 */
public class TokensTest extends BaseTest {

    @Test
    public void test_ForceToken() throws Exception {
        
        OAuthToken oldToken = this._api.OAuthTokenManager.getToken();
        OAuthToken newToken = this._api.AuthenticationManager.createToken();
        
        assertFalse(oldToken.access_token.equals(newToken.access_token));
        
        this._api.OAuthTokenManager.storeToken(newToken);
        OAuthToken storedToken = this._api.OAuthTokenManager.getToken();
        
        assertEquals(newToken.access_token, storedToken.access_token);
    }
    
    @Test
    public void test_StandardUseToken() throws Exception {
        this._api.Users.getAll();
        OAuthToken token = this._api.OAuthTokenManager.getToken();
        this._api.Users.getAll();
        
        assertEquals(token.access_token, this._api.OAuthTokenManager.getToken().access_token);
    }
    
    @Test
    public void test_ShareTokenBetweenInstances() throws Exception {
        MangoPayApi api = this.buildNewMangoPayApi();
        
        OAuthToken token1 = this._api.OAuthTokenManager.getToken();
        OAuthToken token2 = api.OAuthTokenManager.getToken();
        
        assertEquals(token1.access_token, token2.access_token);
    }
    
    @Test
    public void test_IsolateTokensBetweenEnvironments() throws Exception {
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
