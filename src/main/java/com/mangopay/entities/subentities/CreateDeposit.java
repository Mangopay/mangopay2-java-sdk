package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Billing;
import com.mangopay.core.Dto;
import com.mangopay.core.Money;
import com.mangopay.core.Shipping;
import com.mangopay.core.enumerations.CultureCode;

public class CreateDeposit extends Dto {
    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    @SerializedName("CardId")
    private String cardId;

    @SerializedName("SecureModeReturnURL")
    private String secureModeReturnUrl;

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("Culture")
    private CultureCode culture;

    @SerializedName("IpAddress")
    private String ipAddress;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    @SerializedName("Billing")
    private Billing billing;

    @SerializedName("Shipping")
    private Shipping shipping;

    public CreateDeposit(String authorId, Money debitedFunds, String cardId, String secureModeReturnUrl, String ipAddress, BrowserInfo browserInfo) {
        this.authorId = authorId;
        this.debitedFunds = debitedFunds;
        this.cardId = cardId;
        this.secureModeReturnUrl = secureModeReturnUrl;
        this.ipAddress = ipAddress;
        this.browserInfo = browserInfo;
    }

    public CreateDeposit() {
    }

    public String getAuthorId() {
        return authorId;
    }

    public CreateDeposit setAuthorId(String authorId) {
        this.authorId = authorId;
        return this;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public CreateDeposit setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
        return this;
    }

    public String getCardId() {
        return cardId;
    }

    public CreateDeposit setCardId(String cardId) {
        this.cardId = cardId;
        return this;
    }

    public String getSecureModeReturnUrl() {
        return secureModeReturnUrl;
    }

    public CreateDeposit setSecureModeReturnUrl(String secureModeReturnUrl) {
        this.secureModeReturnUrl = secureModeReturnUrl;
        return this;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public CreateDeposit setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public CreateDeposit setCulture(CultureCode culture) {
        this.culture = culture;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public CreateDeposit setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public CreateDeposit setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public Billing getBilling() {
        return billing;
    }

    public CreateDeposit setBilling(Billing billing) {
        this.billing = billing;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public CreateDeposit setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }
}
