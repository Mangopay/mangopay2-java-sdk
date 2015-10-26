package com.mangopay.entities;

import com.mangopay.core.DisputeReason;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Dispute entity.
 */
public class Dispute extends EntityBase {
    
    /**
     * Identifier of the transaction that was disputed.
     */
    public String InitialTransactionId;

    /**
     * Most transaction type of the original trasaction.
     */
    public InitialTransactionType InitialTransactionType;

    /**
     * Type of dispute.
     */
    public DisputeType DisputeType;

    /**
     * The date by which you must submit docs if they wish to contest the dispute.
     */
    public Long ContestDeadlineDate;

    /**
     * Dispute's reason.
     */
    public DisputeReason DisputeReason;

    /**
     * Disputed funds.
     */
    public Money DisputedFunds;

    /**
     * Contested funds.
     */
    public Money ContestedFunds;

    /**
     * Contested funds.
     */
    public DisputeStatus Status;

    /**
     * Free text used when reopening the dispute.
     */
    public String StatusMessage;

    /**
     * Result code.
     */
    public String ResultCode;

    /**
     * Free text that might be completed when the dispute is closed.
     */
    public String ResultMessage;
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        return new HashMap<String, Type>() {{ 
            put("DisputedFunds", Money.class);
            put("ContestedFunds", Money.class);
            put("DisputeReason", DisputeReason.class);
        }};
    }
}
