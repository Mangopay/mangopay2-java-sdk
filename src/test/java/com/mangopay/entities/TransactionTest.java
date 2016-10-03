/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mangopay.entities;

import com.mangopay.core.enumerations.TransactionStatus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hector
 */
public class TransactionTest {
    
    public TransactionTest() {
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
     * Test of isStatusFailed method, of class Transaction.
     */
    @Test
    public void testIsStatusFailed() {
        Transaction transaction = new Transaction();
        transaction.Status = TransactionStatus.FAILED;
        assertTrue(transaction.isStatusFailed());
        transaction.Status = TransactionStatus.CREATED;
        assertFalse(transaction.isStatusFailed());
    }
    
    @Test
    public void testGetResultCode() {
        Transaction transaction = new Transaction(); 
        assertNull(transaction.getResultCode()); 
        transaction.ResultCode = "000000";
        assertEquals(Integer.valueOf(0), transaction.getResultCode());
        transaction.ResultCode = "001002";
        assertEquals(Integer.valueOf(1002), transaction.getResultCode());
    }
    
}
