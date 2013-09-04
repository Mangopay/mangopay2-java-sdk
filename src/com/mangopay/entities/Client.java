package com.mangopay.entities;

import com.mangopay.core.EntityBase;

/**
 * Client entity.
 */
public class Client extends EntityBase {
    
    /**
     * Client identifier.
     */
    public String ClientId;
    
    /**
     * Name of this client.
     */
    public String Name;
    
    /**
     * Email of this client.
     */
    public String Email;
    
    /**
     * Password for this client.
     */
    public String Passphrase;
    
}
