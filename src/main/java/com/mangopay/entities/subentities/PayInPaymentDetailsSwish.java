package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the SWISH type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsSwish extends Dto implements PayInPaymentDetails {

    /**
     * Custom description to show on the user's bank statement.
     * It can be up to 10 char alphanumeric and space.
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * The mobile URL to which to redirect the user to complete the payment in an app-to-app flow.
     */
    @SerializedName("DeepLinkURL")
    private String deepLinkUrl;

    /**
     * The PNG file of the Swish QR code as a Base64-encoded string.
     */
    @SerializedName("QRCodeURL")
    private String qrCodeUrl;

    /**
     * <p>Allowed values: WEB, APP</p>
     * <p>Default value: WEB</p>
     * <p>The platform environment of the post-payment flow. The PaymentFlow value combines with the ReturnURL to manage the redirection behavior after payment:</p>
     * <p>Set the value to APP to send the user to your platform’s mobile app</p>
     * <p>Set the value to WEB to send the user to a web browser</p>
     * <p>In both cases you need to provide the relevant ReturnURL, whether to your app or website.</p>
     */
    @SerializedName("PaymentFlow")
    private String paymentFlow;

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public PayInPaymentDetailsSwish setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public String getDeepLinkUrl() {
        return deepLinkUrl;
    }

    public PayInPaymentDetailsSwish setDeepLinkUrl(String deepLinkUrl) {
        this.deepLinkUrl = deepLinkUrl;
        return this;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public PayInPaymentDetailsSwish setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
        return this;
    }

    public String getPaymentFlow() {
        return paymentFlow;
    }

    public PayInPaymentDetailsSwish setPaymentFlow(String paymentFlow) {
        this.paymentFlow = paymentFlow;
        return this;
    }
}
