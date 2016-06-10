package com.mangopay.entities;

import com.mangopay.core.Address;
import com.mangopay.entities.subentities.BankAccountDetailsCA;
import com.mangopay.entities.subentities.BankAccountDetailsGB;
import com.mangopay.entities.subentities.BankAccountDetailsIBAN;
import com.mangopay.entities.subentities.BankAccountDetailsOTHER;
import com.mangopay.entities.subentities.BankAccountDetailsUS;
import com.mangopay.core.enumerations.BankAccountType;
import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.interfaces.IBankAccountDetails;
import java.lang.reflect.Type;
import java.util.*;

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
    public BankAccountType Type;
    
    /**
     * Owner name.
     */
    public String OwnerName;
    
    /**
     * Owner address.
     */
    public Address OwnerAddress;
    
    /**
     * Denotes whether bank account is active or not.
     */
    public Boolean Active;
    
    /**
     * One of BankAccountDetails implementations, depending on Type.
     */
    public IBankAccountDetails Details;
    
    /**
     * Gets map which property is an object and what type of object.
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {
        
        Map<String, Type> result = super.getSubObjects();
        
        result.put("OwnerAddress", Address.class);
        
        return result;
    }
    
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
