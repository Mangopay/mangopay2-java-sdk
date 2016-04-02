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
    
    /**
     * Your branding colour to use for theme pages.
     */
    public String PrimaryThemeColour;
    
    /**
     * Your branding colour to use for call to action buttons.
     */
    public String PrimaryButtonColour;
    
    /**
     * The URL of your MANGOPAY hosted logo.
     */
    public String Logo;
}
