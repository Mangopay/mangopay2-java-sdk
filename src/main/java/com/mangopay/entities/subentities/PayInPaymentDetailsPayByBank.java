package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the PAY_BY_BANK type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsPayByBank extends Dto implements PayInPaymentDetails {

    /**
     * Custom description to appear on the user’s bank statement along with the platform name.
     * Different banks may show more or less information
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * The country of residence of the user.
     */
    @SerializedName("Country")
    private CountryIso country;

    /**
     * The BIC of the user’s bank account, which is only returned if it was sent.
     * <p>If both the IBAN and BIC are provided, one of the two authentication steps required by certain banks may be avoided.</p>
     */
    @SerializedName("BIC")
    private String bic;

    /**
     * The IBAN of the user’s bank account, which is only returned if it was sent.
     * <p>If both the IBAN and BIC are provided, one of the two authentication steps required by certain banks may be avoided.</p>
     */
    @SerializedName("IBAN")
    private String iban;

    /**
     * The platform environment of the post-payment flow.
     * The PaymentFlow value combines with the ReturnURL to manage the redirection behavior after payment:
     * <p>- WEB: For web browser usage(default setting)</p>
     * <p>- APP: For mobile application usage</p>
     * <p>In both cases you need to provide the relevant ReturnURL, whether to your app or website.</p>
     */
    @SerializedName("PaymentFlow")
    private String paymentFlow;

    /**
     * Name of the end-user’s bank
     */
    @SerializedName("BankName")
    private String bankName;

    /**
     * The scheme to use to process the payment. Note that some banks may charge additional fees
     * to the user for instant payment schemes.
     * <p>Please note that the scheme is mandatory for the Danish market (”Country” : “DK”)</p>
     */
    @SerializedName("Scheme")
    private String scheme;

    /**
     * Parameter that is only returned once the bank wire has been successfully authenticated and initiated by the user
     * but has not yet been received by Mangopay. When the funds are received, the Status changes from CREATED to
     * SUCCEEDED and the ProcessingStatus is no longer returned.
     * <p>For non-instant schemes, processing can take up to 72 hours but is typically completed within 2 days.</p>
     * <p>Possible value: PENDING_SUCCEEDED</p>
     */
    @SerializedName("ProcessingStatus")
    private String processingStatus;

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsPayByBank setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public CountryIso getCountry() {
        return country;
    }

    public PayInPaymentDetailsPayByBank setCountry(CountryIso country) {
        this.country = country;
        return this;
    }

    public String getBic() {
        return bic;
    }

    public PayInPaymentDetailsPayByBank setBic(String bic) {
        this.bic = bic;
        return this;
    }

    public String getIban() {
        return iban;
    }

    public PayInPaymentDetailsPayByBank setIban(String iban) {
        this.iban = iban;
        return this;
    }

    public String getPaymentFlow() {
        return paymentFlow;
    }

    public PayInPaymentDetailsPayByBank setPaymentFlow(String paymentFlow) {
        this.paymentFlow = paymentFlow;
        return this;
    }

    public String getBankName() {
        return bankName;
    }

    public PayInPaymentDetailsPayByBank setBankName(String bankName) {
        this.bankName = bankName;
        return this;
    }

    public String getScheme() {
        return scheme;
    }

    public PayInPaymentDetailsPayByBank setScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

    public String getProcessingStatus() {
        return processingStatus;
    }

    public PayInPaymentDetailsPayByBank setProcessingStatus(String processingStatus) {
        this.processingStatus = processingStatus;
        return this;
    }
}
