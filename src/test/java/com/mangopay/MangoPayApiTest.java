package com.mangopay;

import com.mangopay.core.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class MangoPayApiTest extends BaseTest {
    
    @Test
    public void ApiAndUsersConstructionTest() {
        MangoPayApi mangoPayApi = new MangoPayApi();
        assertNotNull(mangoPayApi);
        assertNotNull(mangoPayApi.getUsers());
    }
}