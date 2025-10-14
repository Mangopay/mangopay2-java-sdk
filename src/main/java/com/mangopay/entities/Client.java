package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.EntityBase;
import com.mangopay.core.PlatformCategorization;

import java.util.ArrayList;

/**
 * Client entity.
 */
public class Client extends EntityBase {

    /**
     * Client identifier.
     */
    @SerializedName("ClientId")
    private String clientId;

    /**
     * Name of this client.
     */
    @SerializedName("Name")
    private String name;

    /**
     * Your branding colour to use for theme pages.
     */
    @SerializedName("PrimaryThemeColour")
    private String primaryThemeColour;

    /**
     * Your branding colour to use for call to action buttons.
     */
    @SerializedName("PrimaryButtonColour")
    private String primaryButtonColour;

    /**
     * The URL of your MANGOPAY hosted logo.
     */
    @SerializedName("Logo")
    private String logo;

    /**
     * A list of email addresses to use when contacting you for technical issues/communications.
     */
    @SerializedName("TechEmails")
    private ArrayList<String> techEmails;

    /**
     * A list of email addresses to use when contacting you for admin/commercial issues/communications.
     */
    @SerializedName("AdminEmails")
    private ArrayList<String> adminEmails;

    /**
     * A list of email addresses to use when contacting you for fraud/compliance issues/communications.
     */
    @SerializedName("FraudEmails")
    private ArrayList<String> fraudEmails;

    /**
     * A list of email addresses to use when contacting you for billing issues/communications.
     */
    @SerializedName("BillingEmails")
    private ArrayList<String> billingEmails;

    /**
     * A description of what your platform does.
     */
    @SerializedName("PlatformDescription")
    private String platformDescription;

    /**
     * The categorization of the platform
     */
    @SerializedName("PlatformCategorization")
    private PlatformCategorization platformCategorization;
    /**
     * The URL for your website.
     */
    @SerializedName("PlatformURL")
    private String platformUrl;

    /**
     * The address of the company’s headquarters.
     */
    @SerializedName("HeadquartersAddress")
    private Address headquartersAddress;

    /**
     * The phone number of the client's headquarters
     */
    @SerializedName("HeadquartersPhoneNumber")
    private String headquartersPhoneNumber;

    /**
     * The tax (or VAT) number for your company.
     */
    @SerializedName("TaxNumber")
    private String taxNumber;

    /**
     * The licensor of the platform’s company account, indicating the Mangopay entity the platform contracted with
     */
    @SerializedName("Licensor")
    private String licensor;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrimaryThemeColour() {
        return primaryThemeColour;
    }

    public void setPrimaryThemeColour(String primaryThemeColour) {
        this.primaryThemeColour = primaryThemeColour;
    }

    public String getPrimaryButtonColour() {
        return primaryButtonColour;
    }

    public void setPrimaryButtonColour(String primaryButtonColour) {
        this.primaryButtonColour = primaryButtonColour;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public ArrayList<String> getTechEmails() {
        return techEmails;
    }

    public void setTechEmails(ArrayList<String> techEmails) {
        this.techEmails = techEmails;
    }

    public ArrayList<String> getAdminEmails() {
        return adminEmails;
    }

    public void setAdminEmails(ArrayList<String> adminEmails) {
        this.adminEmails = adminEmails;
    }

    public ArrayList<String> getFraudEmails() {
        return fraudEmails;
    }

    public void setFraudEmails(ArrayList<String> fraudEmails) {
        this.fraudEmails = fraudEmails;
    }

    public ArrayList<String> getBillingEmails() {
        return billingEmails;
    }

    public void setBillingEmails(ArrayList<String> billingEmails) {
        this.billingEmails = billingEmails;
    }

    public String getPlatformDescription() {
        return platformDescription;
    }

    public void setPlatformDescription(String platformDescription) {
        this.platformDescription = platformDescription;
    }

    public PlatformCategorization getPlatformCategorization() {
        return platformCategorization;
    }

    public void setPlatformCategorization(PlatformCategorization platformCategorization) {
        this.platformCategorization = platformCategorization;
    }

    public String getPlatformUrl() {
        return platformUrl;
    }

    public void setPlatformUrl(String platformUrl) {
        this.platformUrl = platformUrl;
    }

    public Address getHeadquartersAddress() {
        return headquartersAddress;
    }

    public void setHeadquartersAddress(Address headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    public String getTaxNumber() {
        return taxNumber;
    }

    public void setTaxNumber(String taxNumber) {
        this.taxNumber = taxNumber;
    }

    public String getHeadquartersPhoneNumber() {
        return headquartersPhoneNumber;
    }

    public Client setHeadquartersPhoneNumber(String headquartersPhoneNumber) {
        this.headquartersPhoneNumber = headquartersPhoneNumber;
        return this;
    }

    public String getLicensor() {
        return licensor;
    }

    public Client setLicensor(String licensor) {
        this.licensor = licensor;
        return this;
    }
}
