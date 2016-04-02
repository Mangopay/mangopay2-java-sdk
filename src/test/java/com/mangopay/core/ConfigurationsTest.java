package com.mangopay.core;
import org.junit.Test;

/**
 * Tests for holding authentication token in instance
 */
public class ConfigurationsTest extends BaseTest {

    @Test(expected = ResponseException.class)
    public void test_ConfInConstruct() throws Exception {
        this._api.Config.ClientId = "test_asd";
        this._api.Config.ClientPassword = "00000";        
        this._api.Users.getAll();
    }
}
