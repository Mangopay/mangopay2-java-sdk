package com.mangopay.core.enumerations;

/**
 * Dispute status enumeration.
 */
public enum DisputeStatus {
    
    /**
     * CREATED dispute status.
     */
    CREATED, 
    
    /**
     * PENDING_CLIENT_ACTION dispute status.
     */
    PENDING_CLIENT_ACTION, 
    
    /**
     * SUBMITTED dispute status.
     */
    SUBMITTED, 
    
    /**
     * PENDING_BANK_ACTION dispute status.
     */
    PENDING_BANK_ACTION, 
    
    /**
     * REOPENED_PENDING_CLIENT_ACTION dispute status.
     */
    REOPENED_PENDING_CLIENT_ACTION,
    
    /**
     * CLOSED dispute status.
     */
    CLOSED
}
