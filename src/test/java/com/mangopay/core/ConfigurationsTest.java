package com.mangopay.core;

import org.junit.Test;

/**
 * Tests for holding authentication token in instance
 */
public class ConfigurationsTest extends BaseTest {

    @Test(expected = ResponseException.class)
    public void confInConstruct() throws Exception {
        this.api.getConfig().setClientId("test_asd");
        this.api.getConfig().setClientPassword("00000");
        this.api.getUserApi().getAll();
    }
}
