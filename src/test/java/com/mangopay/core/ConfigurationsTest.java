package com.mangopay.core;

import static org.junit.Assert.*;
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
    
    @Test
    public void getVersionTest() {
        // First load from properties files
        assertNotNull(getApi().getConfig().getVersion());
        // Second load from memory
        assertNotNull(getApi().getConfig().getVersion());
    }
}
