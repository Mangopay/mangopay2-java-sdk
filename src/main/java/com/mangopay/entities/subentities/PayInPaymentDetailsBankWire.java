package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.Money;
import com.mangopay.core.interfaces.IPayInPaymentDetails;
import com.mangopay.entities.BankAccount;
import java.lang.reflect.Type;
import java.util.*;

/**
 * Class representing the BankWire type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsBankWire extends Dto implements IPayInPaymentDetails {
    
    /**
     * Declared debited funds.
     */
    public Money DeclaredDebitedFunds;

    /**
     * Declared fees.
     */
    public Money DeclaredFees;

    /**
     * Bank account details.
     */
    public BankAccount BankAccount;
    
    /**
     * Wire reference. 
     */
    public String WireReference;
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        HashMap<String, Type> result = new HashMap<>();
        
        result.put("DeclaredDebitedFunds", Money.class);
        result.put("DeclaredFees", Money.class);
        result.put("BankAccount", BankAccount.class);
        
        return result;
    }
}
