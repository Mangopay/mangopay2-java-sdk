package com.mangopay.core;
import org.junit.Test;

/**
 * Tests for holding authentication token in instance
 */
public class ConfigurationsTest extends BaseTest {

    @Test(expected = ResponseException.class)
    public void confInConstruct() throws Exception {
        this.api.Config.ClientId = "test_asd";
        this.api.Config.ClientPassword = "00000";        
        this.api.Users.getAll();
    }
}
