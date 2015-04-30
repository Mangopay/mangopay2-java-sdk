package com.mangopay.entities;

import com.mangopay.entities.subentities.*;
import com.mangopay.core.interfaces.*;
import com.mangopay.core.enumerations.*;
import java.util.*;

/**
 * PayOut entity.
 */
public class PayOut extends Transaction {
    
    /**
     * Debited wallet identifier.
     */
    public String DebitedWalletId;
    
    /**
     * Payment type.
     */
    public PayOutPaymentType PaymentType;
    
    /**
     * One of IPayOutPaymentDetails implementations, depending on PaymentType.
     */
    public IPayOutPaymentDetails MeanOfPaymentDetails;
    
    /**
     * Gets the structure that maps which property depends on other property.
     * @return 
     */
    @Override
    public Map<String, Map<String, Map<String, Class<?>>>> getDependentObjects() {
        
        return new HashMap<String, Map<String, Map<String, Class<?>>>>(){{ 
            put("PaymentType", new HashMap<String, Map<String, Class<?>>>()
                {{
                    put("BANK_WIRE", new HashMap<String, Class<?>>() {{
                            put("MeanOfPaymentDetails", PayOutPaymentDetailsBankWire.class);
                        }}
                    );
                    // ...and more in future...
                }}
            );
        }};
    }
    
    /**
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("PaymentType");
        
        return result;
    }
}
