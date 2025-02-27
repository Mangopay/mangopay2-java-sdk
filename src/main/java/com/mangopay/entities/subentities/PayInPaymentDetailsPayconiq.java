package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

public class PayInPaymentDetailsPayconiq extends Dto implements PayInPaymentDetails {

    @SerializedName("Country")
    private String country;

    @SerializedName("DebitedWalletId")
    private String debitedWalletId;

    @SerializedName("ExpirationDate")
    private String expirationDate;

    @SerializedName("DeepLinkURL")
    private String deepLinkUrl;


    // v2 //

    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    @SerializedName("QRCodeURL")
    private String qrCodeUrl;

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public String getDebitedWalletId() {
        return debitedWalletId;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getDeepLinkUrl() {
        return deepLinkUrl;
    }

    public void setDebitedWalletId(String debitedWalletId) {
        this.debitedWalletId = debitedWalletId;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public void setDeepLinkUrl(String deepLinkUrl) {
        this.deepLinkUrl = deepLinkUrl;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }
}
