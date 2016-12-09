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
 * @author Hector Espert hespert@peertopark.com
 */
public class TransactionTest {
    
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
     * Test of getStatus method, of class Transaction.
     */
    @Test
    public void testGetStatus() {
        Transaction transaction = new Transaction();
        assertEquals(TransactionStatus.NotSpecified, transaction.getStatus());
        transaction.Status = TransactionStatus.SUCCEEDED;
        assertEquals(TransactionStatus.SUCCEEDED, transaction.getStatus());
    }
    
    
    @Test
    public void testIsCreated() {
        Transaction transaction = new Transaction();
        assertFalse(transaction.isCreated());
        transaction.Status = TransactionStatus.NotSpecified;
        assertFalse(transaction.isCreated());
        transaction.Status = TransactionStatus.CREATED;
        assertTrue(transaction.isCreated());
    }
    
    @Test
    public void testIsFailed() {
        Transaction transaction = new Transaction();
        assertFalse(transaction.isFailed());
        transaction.Status = TransactionStatus.CREATED;
        assertFalse(transaction.isFailed());
        transaction.Status = TransactionStatus.FAILED;
        assertTrue(transaction.isFailed());
    }
    
    @Test
    public void testIsSucceeded() {
        Transaction transaction = new Transaction();
        assertFalse(transaction.isSucceeded());
        transaction.Status = TransactionStatus.CREATED;
        assertFalse(transaction.isSucceeded());
        transaction.Status = TransactionStatus.SUCCEEDED;
        assertTrue(transaction.isSucceeded());
    }
    
}
