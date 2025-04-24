package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.LineItem;
import com.mangopay.core.Money;
import com.mangopay.core.Shipping;
import com.mangopay.core.enumerations.CultureCode;
import com.mangopay.core.enumerations.ShippingPreference;

import java.util.List;

public class RecurringPayPalPayInMIT extends Dto {

    /**
     * The unique identifier of the recurring pay-in registration.
     */
    @SerializedName("RecurringPayinRegistrationId")
    private String recurringPayInRegistrationId;

    /**
     * The amount of the subsequent recurring pay-in. If this field is empty, the amount entered in
     * the NextTransactionDebitedFunds of the Recurring PayIn Registration is taken into account.
     * <p></p>
     * Required if the registration’s NextTransactionDebitedFunds is empty.
     */
    @SerializedName("DebitedFunds")
    private Money debitedFunds;

    /**
     * The amount of the subsequent fees. If this field is empty, the amount entered in
     * the NextTransactionFees of the Recurring PayIn Registration is taken into account.
     * <p></p>
     * Required if the registration’s NextTransactionFees is empty.
     */
    @SerializedName("Fees")
    private Money fees;

    /**
     * Custom data that you can add to this object.
     */
    @SerializedName("Tag")
    private String tag;

    /**
     * The URL to which the user is returned after the payment, whether the transaction is successful or not.
     */
    @SerializedName("ReturnURL")
    private String returnUrl;

    /**
     * The URL to which the user is returned after canceling the payment.
     * If not provided, the Cancel button returns the user to the RedirectURL.
     */
    @SerializedName("CancelURL")
    private String cancelUrl;

    /**
     * Custom description to appear on the user’s bank statement along with the platform name
     */
    @SerializedName("StatementDescriptor")
    private String statementDescriptor;

    /**
     * Information about the end user’s shipping address, managed by ShippingPreference.
     * Required if ShippingPreference is SET_PROVIDED_ADDRESS and the shipping information is not present in the
     * recurring registration object.
     */
    @SerializedName("Shipping")
    private Shipping shipping;

    /**
     * Information about the items purchased in the transaction
     */
    @SerializedName("LineItems")
    private List<LineItem> lineItems;

    /**
     * The language in which the PayPal payment page is to be displayed.
     */
    @SerializedName("Culture")
    private CultureCode culture;

    /**
     * Information about the shipping address behavior on the PayPal payment page:
     * <p>
     * SET_PROVIDED_ADDRESS - The Shipping parameter becomes required and its values are displayed to the end user, who is not able to modify them.
     * <p>
     * GET_FROM_FILE – The Shipping parameter is ignored and the end user can choose from registered addresses.
     * <p>
     * NO_SHIPPING – No shipping address section is displayed.
     */
    @SerializedName("ShippingPreference")
    private ShippingPreference shippingPreference;

    /**
     * The platform’s order reference for the transaction.
     */
    @SerializedName("Reference")
    private String reference;

    public String getRecurringPayInRegistrationId() {
        return recurringPayInRegistrationId;
    }

    public RecurringPayPalPayInMIT setRecurringPayInRegistrationId(String recurringPayInRegistrationId) {
        this.recurringPayInRegistrationId = recurringPayInRegistrationId;
        return this;
    }

    public Money getDebitedFunds() {
        return debitedFunds;
    }

    public RecurringPayPalPayInMIT setDebitedFunds(Money debitedFunds) {
        this.debitedFunds = debitedFunds;
        return this;
    }

    public Money getFees() {
        return fees;
    }

    public RecurringPayPalPayInMIT setFees(Money fees) {
        this.fees = fees;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public RecurringPayPalPayInMIT setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public RecurringPayPalPayInMIT setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
        return this;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public RecurringPayPalPayInMIT setCancelUrl(String cancelUrl) {
        this.cancelUrl = cancelUrl;
        return this;
    }

    public String getStatementDescriptor() {
        return statementDescriptor;
    }

    public RecurringPayPalPayInMIT setStatementDescriptor(String statementDescriptor) {
        this.statementDescriptor = statementDescriptor;
        return this;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public RecurringPayPalPayInMIT setShipping(Shipping shipping) {
        this.shipping = shipping;
        return this;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public RecurringPayPalPayInMIT setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
        return this;
    }

    public CultureCode getCulture() {
        return culture;
    }

    public RecurringPayPalPayInMIT setCulture(CultureCode culture) {
        this.culture = culture;
        return this;
    }

    public ShippingPreference getShippingPreference() {
        return shippingPreference;
    }

    public RecurringPayPalPayInMIT setShippingPreference(ShippingPreference shippingPreference) {
        this.shippingPreference = shippingPreference;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public RecurringPayPalPayInMIT setReference(String reference) {
        this.reference = reference;
        return this;
    }
}
