/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Hector Espert hespert@peertopark.com
 */
public class ObjectToolTest {
    
    public ObjectToolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of nonNull method, of class ObjectTool.
     */
    @Test
    public void testNonNull() {
        Object object = null;
        assertFalse(ObjectTool.nonNull(object));
        object = new Object();
        assertTrue(ObjectTool.nonNull(object));
    }

    /**
     * Test of isNull method, of class ObjectTool.
     */
    @Test
    public void testIsNull() {
        Object object = null;
        assertTrue(ObjectTool.isNull(object));
        object = new Object();
        assertFalse(ObjectTool.isNull(object));
    }
    
}
