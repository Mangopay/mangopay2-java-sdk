package com.mangopay.core;
import com.mangopay.entities.*;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.Exception;
import com.mangopay.core.OAuthToken;
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
}
