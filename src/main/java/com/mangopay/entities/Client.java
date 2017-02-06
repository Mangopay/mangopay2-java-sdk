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
     *
     * @deprecated Use {@link #getClientId()} and {@link #setClientId(String)} instead.
     */
    @Deprecated
    public String ClientId;

    /**
     * Name of this client.
     *
     * @deprecated Use {@link #getName()} and {@link #setName(String)} instead.
     */
    @Deprecated
    public String Name;

    /**
     * Your branding colour to use for theme pages.
     *
     * @deprecated Use {@link #getPrimaryThemeColour()} and {@link #setPrimaryThemeColour(String)} instead.
     */
    @Deprecated
    public String PrimaryThemeColour;

    /**
     * Your branding colour to use for call to action buttons.
     *
     * @deprecated Use {@link #getPrimaryButtonColour()} and {@link #setPrimaryButtonColour(String)} instead.
     */
    @Deprecated
    public String PrimaryButtonColour;

    /**
     * The URL of your MANGOPAY hosted logo.
     *
     * @deprecated Use {@link #getLogo()} and {@link #setLogo(String)} instead.
     */
    @Deprecated
    public String Logo;

    /**
     * A list of email addresses to use when contacting you for technical issues/communications.
     *
     * @deprecated Use {@link #getTechEmails()} and {@link #setTechEmails(ArrayList)} instead.
     */
    @Deprecated
    public ArrayList<String> TechEmails;

    /**
     * A list of email addresses to use when contacting you for admin/commercial issues/communications.
     *
     * @deprecated Use {@link #getAdminEmails()} and {@link #setAdminEmails(ArrayList)} instead.
     */
    @Deprecated
    public ArrayList<String> AdminEmails;

    /**
     * A list of email addresses to use when contacting you for fraud/compliance issues/communications.
     *
     * @deprecated Use {@link #getFraudEmails()} and {@link #setFraudEmails(ArrayList)} instead.
     */
    @Deprecated
    public ArrayList<String> FraudEmails;

    /**
     * A list of email addresses to use when contacting you for billing issues/communications.
     *
     * @deprecated Use {@link #getBillingEmails()} and {@link #setBillingEmails(ArrayList)} instead.
     */
    @Deprecated
    public ArrayList<String> BillingEmails;

    /**
     * A description of what your platform does.
     *
     * @deprecated Use {@link #getPlatformDescription()} and {@link #setPlatformDescription(String)} instead.
     */
    @Deprecated
    public String PlatformDescription;

    /**
     * The type of platform.
     *
     * @deprecated Use {@link #getPlatformType()} and {@link #setPlatformType(PlatformType)} instead.
     */
    @Deprecated
    public PlatformType PlatformType;

    /**
     * The URL for your website.
     *
     * @deprecated Use {@link #getPlatformURL()} and {@link #setPlatformURL(String)} instead.
     */
    @Deprecated
    public String PlatformURL;

    /**
     * The address of the company’s headquarters.
     *
     * @deprecated Use {@link #getHeadquartersAddress()} and {@link #setHeadquartersAddress(Address)} instead.
     */
    @Deprecated
    public Address HeadquartersAddress;

    /**
     * The tax (or VAT) number for your company.
     *
     * @deprecated Use {@link #getTaxNumber()} and {@link #setTaxNumber(String)} instead.
     */
    @Deprecated
    public String TaxNumber;

    public String getClientId() {
        return ClientId;
    }

    public void setClientId(String clientId) {
        this.ClientId = clientId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPrimaryThemeColour() {
        return PrimaryThemeColour;
    }

    public void setPrimaryThemeColour(String primaryThemeColour) {
        this.PrimaryThemeColour = primaryThemeColour;
    }

    public String getPrimaryButtonColour() {
        return PrimaryButtonColour;
    }

    public void setPrimaryButtonColour(String primaryButtonColour) {
        this.PrimaryButtonColour = primaryButtonColour;
    }

    public String getLogo() {
        return Logo;
    }

    public void setLogo(String logo) {
        this.Logo = logo;
    }

    public ArrayList<String> getTechEmails() {
        return TechEmails;
    }

    public void setTechEmails(ArrayList<String> techEmails) {
        this.TechEmails = techEmails;
    }

    public ArrayList<String> getAdminEmails() {
        return AdminEmails;
    }

    public void setAdminEmails(ArrayList<String> adminEmails) {
        this.AdminEmails = adminEmails;
    }

    public ArrayList<String> getFraudEmails() {
        return FraudEmails;
    }

    public void setFraudEmails(ArrayList<String> fraudEmails) {
        this.FraudEmails = fraudEmails;
    }

    public ArrayList<String> getBillingEmails() {
        return BillingEmails;
    }

    public void setBillingEmails(ArrayList<String> billingEmails) {
        this.BillingEmails = billingEmails;
    }

    public String getPlatformDescription() {
        return PlatformDescription;
    }

    public void setPlatformDescription(String platformDescription) {
        this.PlatformDescription = platformDescription;
    }

    public PlatformType getPlatformType() {
        return PlatformType;
    }

    public void setPlatformType(PlatformType platformType) {
        this.PlatformType = platformType;
    }

    public String getPlatformURL() {
        return PlatformURL;
    }

    public void setPlatformURL(String platformURL) {
        this.PlatformURL = platformURL;
    }

    public Address getHeadquartersAddress() {
        return HeadquartersAddress;
    }

    public void setHeadquartersAddress(Address headquartersAddress) {
        this.HeadquartersAddress = headquartersAddress;
    }

    public String getTaxNumber() {
        return TaxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.TaxNumber = taxNumber;
    }
}
