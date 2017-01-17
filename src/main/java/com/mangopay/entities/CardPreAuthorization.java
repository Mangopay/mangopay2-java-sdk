package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.Money;
import com.mangopay.core.enumerations.PaymentStatus;
import com.mangopay.core.enumerations.PreAuthorizationExecutionType;
import com.mangopay.core.enumerations.PreAuthorizationStatus;
import com.mangopay.core.enumerations.SecureMode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CardPreAuthorization entity.
 */
public class CardPreAuthorization extends EntityBase {

    /**
     * The user Id of the author of the pre-authorization.
     *
     * @deprecated Use {@link #getAuthorId()} and {@link #setAuthorId(String)} instead.
     */
    @Deprecated
    public String AuthorId;

    /**
     * Represents the amount debited on the bank account
     * of the Author. DebitedFunds = Fees + CreditedFunds
     * (amount received on wallet)
     *
     * @deprecated Use {@link #getDebitedFunds()} and {@link #setDebitedFunds(Money)} instead.
     */
    @Deprecated
    public Money DebitedFunds;

    /**
     * Status of the PreAuthorization.
     *
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(PreAuthorizationStatus)} instead.
     */
    @Deprecated
    public PreAuthorizationStatus Status;

    /**
     * The status of the payment after the PreAuthorization.
     *
     * @deprecated Use {@link #getPaymentStatus()} and {@link #setPaymentStatus(PaymentStatus)} instead.
     */
    @Deprecated
    public PaymentStatus PaymentStatus;

    /**
     * The PreAuthorization result code.
     *
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(String)} instead.
     */
    @Deprecated
    public String ResultCode;

    /**
     * The PreAuthorization result Message explaining the result code.
     *
     * @deprecated Use {@link #getResultMessage()} and {@link #setResultMessage(String)} instead.
     */
    @Deprecated
    public String ResultMessage;

    /**
     * How the PreAuthorization has been executed.
     *
     * @deprecated Use {@link #getExecutionType()} and {@link #setExecutionType(PreAuthorizationExecutionType)} instead.
     */
    @Deprecated
    public PreAuthorizationExecutionType ExecutionType;

    /**
     * The SecureMode correspond to '3D secure' for CB Visa and MasterCard
     * or 'Amex Safe Key' for American Express.
     * This field lets you activate it manually.
     *
     * @deprecated Use {@link #getSecureMode()} and {@link #setSecureMode(SecureMode)} instead.
     */
    @Deprecated
    public SecureMode SecureMode;

    /**
     * Identifier of the registered card (got through CardRegistration object).
     *
     * @deprecated Use {@link #getCardId()} and {@link #setCardId(String)} instead.
     */
    @Deprecated
    public String CardId;

    /**
     * An optional value to be specified on the user's bank statement
     *
     * @deprecated Use {@link #getStatementDescriptor()} and {@link #setStatementDescriptor(String)} instead.
     */
    @Deprecated
    public String StatementDescriptor;

    /**
     * Boolean. The value is 'true' if the SecureMode was used.
     *
     * @deprecated Use {@link #getSecureModeNeeded()} and {@link #setSecureModeNeeded(String)} instead.
     */
    @Deprecated
    public String SecureModeNeeded;

    /**
     * This is the URL where to redirect users to proceed
     * to 3D secure validation.
     *
     * @deprecated Use {@link #getSecureModeRedirectURL()} and {@link #setSecureModeRedirectURL(String)} instead.
     */
    @Deprecated
    public String SecureModeRedirectURL;

    /**
     * This is the URL where users are automatically redirected
     * after 3D secure validation (if activated).
     *
     * @deprecated Use {@link #getSecureModeReturnURL()} and {@link #setSecureModeReturnURL(String)} instead.
     */
    @Deprecated
    public String SecureModeReturnURL;

    /**
     * The date when the payment has been processed (UNIX timestamp).
     *
     * @deprecated Use {@link #getExpirationDate()} and {@link #setExpirationDate(Long)} instead.
     */
    @Deprecated
    public Long ExpirationDate;

    /**
     * Identifier of the associated PayIn.
     *
     * @deprecated Use {@link #getPayInId()} and {@link #setPayInId(String)} instead.
     */
    @Deprecated
    public String PayInId;

    public String getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(String authorId) {
        this.AuthorId = authorId;
    }

    public Money getDebitedFunds() {
        return DebitedFunds;
    }

    public void setDebitedFunds(Money debitedFunds) {
        this.DebitedFunds = debitedFunds;
    }

    public PreAuthorizationStatus getStatus() {
        return Status;
    }

    public void setStatus(PreAuthorizationStatus status) {
        this.Status = status;
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.PaymentStatus = paymentStatus;
    }

    public String getResultCode() {
        return ResultCode;
    }

    public void setResultCode(String resultCode) {
        this.ResultCode = resultCode;
    }

    public String getResultMessage() {
        return ResultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.ResultMessage = resultMessage;
    }

    public PreAuthorizationExecutionType getExecutionType() {
        return ExecutionType;
    }

    public void setExecutionType(PreAuthorizationExecutionType executionType) {
        this.ExecutionType = executionType;
    }

    public SecureMode getSecureMode() {
        return SecureMode;
    }

    public void setSecureMode(SecureMode secureMode) {
        this.SecureMode = secureMode;
    }

    public String getCardId() {
        return CardId;
    }

    public void setCardId(String cardId) {
        this.CardId = cardId;
    }

    public String getStatementDescriptor() {
        return StatementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.StatementDescriptor = statementDescriptor;
    }

    public String getSecureModeNeeded() {
        return SecureModeNeeded;
    }

    public void setSecureModeNeeded(String secureModeNeeded) {
        this.SecureModeNeeded = secureModeNeeded;
    }

    public String getSecureModeRedirectURL() {
        return SecureModeRedirectURL;
    }

    public void setSecureModeRedirectURL(String secureModeRedirectURL) {
        this.SecureModeRedirectURL = secureModeRedirectURL;
    }

    public String getSecureModeReturnURL() {
        return SecureModeReturnURL;
    }

    public void setSecureModeReturnURL(String secureModeReturnURL) {
        this.SecureModeReturnURL = secureModeReturnURL;
    }

    public Long getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(Long expirationDate) {
        this.ExpirationDate = expirationDate;
    }

    public String getPayInId() {
        return PayInId;
    }

    public void setPayInId(String payInId) {
        this.PayInId = payInId;
    }

    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        HashMap<String, Type> result = new HashMap<>();

        result.put("DebitedFunds", Money.class);

        return result;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("Status");
        result.add("ResultCode");
        result.add("ResultMessage");

        return result;
    }
}
