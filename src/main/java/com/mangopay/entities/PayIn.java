package com.mangopay.entities;

import com.mangopay.entities.subentities.*;
import com.mangopay.core.interfaces.*;
import com.mangopay.core.enumerations.*;
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
     * Type of payment.
     */
    public PayInPaymentType PaymentType;
    
    /**
     * One of PayInPaymentDetails implementations, depending on PaymentType.
     */
    public IPayInPaymentDetails PaymentDetails;
    
    /**
     * Type of execution.
     */
    public PayInExecutionType ExecutionType;
    
    /**
     * One of PayInExecutionDetails implementations, depending on ExecutionType.
     */
    public IPayInExecutionDetails ExecutionDetails;
    
    /**
     * Gets the structure that maps which property depends on other property.
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
                    put("PREAUTHORIZED", new HashMap<String, Class<?>>() {{
                            put("PaymentDetails", PayInPaymentDetailsPreAuthorized.class);
                        }}
                    );
                    put("BANK_WIRE", new HashMap<String, Class<?>>() {{
                            put("PaymentDetails", PayInPaymentDetailsBankWire.class);
                        }}
                    );
                    put("DIRECT_DEBIT", new HashMap<String, Class<?>>() {{
                            put("PaymentDetails", PayInPaymentDetailsDirectDebit.class);
                        }}
                    );
                    put("PAYPAL", new HashMap<String, Class<?>>() {{
                            put("PaymentDetails", PayInPaymentDetailsPayPal.class);
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
     * Gets the collection of read-only fields names.
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {
        
        ArrayList<String> result = super.getReadOnlyProperties();
        
        result.add("PaymentType");
        result.add("ExecutionType");
        
        return result;
    }

    @Override
    public String toString() {
        return "PayIn{" + "Id=" + super.Id + ", CreditedWalletId=" + CreditedWalletId + ", Status=" + super.Status + ", ResultCode=" + super.ResultCode + ", ResultMessage=" + super.ResultMessage + '}';
    }
    
    
}
