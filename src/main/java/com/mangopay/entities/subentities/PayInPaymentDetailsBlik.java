package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the BLIK type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsBlik extends Dto implements PayInPaymentDetails {

    /**
     * An optional value to be specified on the user's bank statement
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;


    /// Blik with "code" ///

    /**
     * The 6-digit code from the user’s banking application.
     * Required when creating a Blik PayIn with code.
     */
    @SerializedName("Code")
    private String code;

    /**
     * The IP address of the end user initiating the transaction, in IPV4 or IPV6 format.
     * Required when creating a Blik PayIn with code.
     */
    @SerializedName("IpAddress")
    private String ipAddress;

    /**
     * Information about the browser used by the end user (author) to perform the payment.
     * Required when creating a Blik PayIn with code.
     */
    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;
    
    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsBlik setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public PayInPaymentDetailsBlik setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public PayInPaymentDetailsBlik setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getCode() {
        return code;
    }

    public PayInPaymentDetailsBlik setCode(String code) {
        this.code = code;
        return this;
    }
}
