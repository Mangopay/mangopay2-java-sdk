package com.mangopay.entities;

import com.mangopay.core.Address;
import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.PlatformType;
import java.util.ArrayList;

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

    /**
     * A list of email addresses to use when contacting you for technical issues/communications.
     */
    public ArrayList<String> TechEmails;

    /**
     * A list of email addresses to use when contacting you for admin/commercial issues/communications.
     */
    public ArrayList<String> AdminEmails;

    /**
     * A list of email addresses to use when contacting you for fraud/compliance issues/communications.
     */
    public ArrayList<String> FraudEmails;

    /**
     * A list of email addresses to use when contacting you for billing issues/communications.
     */
    public ArrayList<String> BillingEmails;

    /**
     * A description of what your platform does.
     */
    public String PlatformDescription;

    /**
     * The type of platform.
     */
    public PlatformType PlatformType;

    /**
     * The URL for your website.
     */
    public String PlatformURL;

    /**
     * The address of the company’s headquarters.
     */
    public Address HeadquartersAddress;

    /**
     * The tax (or VAT) number for your company.
     */
    public String TaxNumber;
}
