package com.mangopay.entities;

import com.mangopay.core.BankAccountDetailsCA;
import com.mangopay.core.BankAccountDetailsGB;
import com.mangopay.core.BankAccountDetailsIBAN;
import com.mangopay.core.BankAccountDetailsOTHER;
import com.mangopay.core.BankAccountDetailsUS;
import com.mangopay.core.EntityBase;
import com.mangopay.core.IBankAccountDetails;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Bank Account entity.
 */
public class BankAccount extends EntityBase {
    
    /**
     * User identifier.
     */
    public String UserId;
    
    /**
     * Type of bank account.
     */
    public String Type;
    
    /**
     * Owner name.
     */
    public String OwnerName;
    
    /**
     * Owner address.
     */
    public String OwnerAddress;
    
    /**
     * One of BankAccountDetails implementations, depending on Type.
     */
    public IBankAccountDetails Details;
    
    /**
     * Gets the structure that maps which property depends on other property.
     * @return 
     */
    @Override
    public Map<String, Map<String, Map<String, Class<?>>>> getDependentObjects() {
        
        return new HashMap<String, Map<String, Map<String, Class<?>>>>(){{ 
            put("Type", new HashMap<String, Map<String, Class<?>>>()
                {{
                    put("IBAN", new HashMap<String, Class<?>>() {{
                            put("Details", BankAccountDetailsIBAN.class);
                        }}
                    );
                    put("GB", new HashMap<String, Class<?>>() {{
                            put("Details", BankAccountDetailsGB.class);
                        }}
                    );
                    put("US", new HashMap<String, Class<?>>() {{
                            put("Details", BankAccountDetailsUS.class);
                        }}
                    );
                    put("CA", new HashMap<String, Class<?>>() {{
                            put("Details", BankAccountDetailsCA.class);
                        }}
                    );
                    put("OTHER", new HashMap<String, Class<?>>() {{
                            put("Details", BankAccountDetailsOTHER.class);
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
        
        result.add("UserId");
        result.add("Type");
        
        return result;
    }
}
