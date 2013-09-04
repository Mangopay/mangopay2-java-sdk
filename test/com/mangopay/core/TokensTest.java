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
        // create token
        OAuthToken token = this._api.AuthenticationManager.createToken();
        // overwrite token in API
        this._api.OAuthToken = token;
        this._api.Users.getAll();
        assertEquals(token.access_token, this._api.OAuthToken.access_token);
    }
    
    @Test
    public void test_StadnardUseToken() throws Exception {
        this._api.Users.getAll();
        OAuthToken token = this._api.OAuthToken;
        this._api.Users.getAll();
        assertEquals(token.access_token, this._api.OAuthToken.access_token);
    }
    
    @Test
    public void test_IsTokenLeaking() throws Exception {
        // create separate api
       MangoPayApi api = buildNewMangoPayApi();
        this._api.Users.getAll();
        api.Users.getAll();
        assertFalse(api.OAuthToken.access_token.equals(this._api.OAuthToken.access_token));
    }    
}
