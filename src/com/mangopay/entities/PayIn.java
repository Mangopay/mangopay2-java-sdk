package com.mangopay.entities;

import com.mangopay.core.*;
import java.util.*;

/**
 * PayIn entity.
 */
public class PayIn extends Transaction {
    
    /**
     * Credited wallet identifier.
     */
    public String CreditedWalletId;
    
    /**
     * PaymentType {CARD, BANK_WIRE, AUTOMATIC_DEBIT, DIRECT_DEBIT }
     */
    public String PaymentType;
    
    /**
     * One of PayInPaymentDetails implementations, depending on PaymentType.
     */
    public IPayInPaymentDetails PaymentDetails;
    
    /**
     * ExecutionType { WEB, TOKEN, DIRECT, PREAUTHORIZED, RECURRING_ORDER_EXECUTION }
     */
    public String ExecutionType;
    
    /**
     * One of PayInExecutionDetails implementations, depending on ExecutionType.
     */
    public IPayInExecutionDetails ExecutionDetails;
    
    /**
     * Gets the structure that maps which property depends on other property.
     * To be overridden in child class if has any dependent objects.
     * @return 
     */
    @Override
    public Map<String, Map<String, Map<String, Class<?>>>> getDependentObjects() {
        
        return new HashMap<String, Map<String, Map<String, Class<?>>>>(){{ 
            put("PaymentType", new HashMap<String, Map<String, Class<?>>>()
                {{
                    put("CARD", new HashMap<String, Class<?>>() {{
                            put("PaymentDetails", PayInPaymentDetailsCard.class);
                        }}
                    );
                    // ...and more in future...
                }}
            );
            put("ExecutionType", new HashMap<String, Map<String, Class<?>>>()
                {{
                    put("WEB", new HashMap<String, Class<?>>() {{
                            put("ExecutionDetails", PayInExecutionDetailsWeb.class);
                        }}
                    );
                    put("DIRECT", new HashMap<String, Class<?>>() {{
                            put("ExecutionDetails", PayInExecutionDetailsDirect.class);
                        }}
                    );
                    // ...and more in future...
                }}
            );
        }};
    }
    
    /**
     * Gets the collection of read-only fields names
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("PaymentType");
        result.add("ExecutionType");
        
        return result;
    }
}
