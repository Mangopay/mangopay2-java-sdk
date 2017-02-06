package com.mangopay.entities.subentities;

import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.DirectDebitType;
import com.mangopay.core.interfaces.PayInPaymentDetails;

/**
 * Class representing the Direct-Debit type for mean of payment in PayIn entity.
 */
public class PayInPaymentDetailsDirectDebit extends Dto implements PayInPaymentDetails {

    /**
     * Direct debit type.
     *
     * @deprecated Use {@link #getDirectDebitType()} and {@link #setDirectDebitType(com.mangopay.core.enumerations.DirectDebitType)} instead.
     */
    @Deprecated
    public DirectDebitType DirectDebitType;

    /**
     * Mandate identifier.
     *
     * @deprecated Use {@link #getMandateId()} and {@link #setMandateId(String)} instead.
     */
    @Deprecated
    public String MandateId;

    /**
     * An optional value to be specified on the user's bank statement
     *
     * @deprecated Use {@link #getStatementDescriptor()} and {@link #setStatementDescriptor(String)} instead.
     */
    @Deprecated
    public String StatementDescriptor;

    public DirectDebitType getDirectDebitType() {
        return DirectDebitType;
    }

    public void setDirectDebitType(DirectDebitType directDebitType) {
        this.DirectDebitType = directDebitType;
    }

    public String getMandateId() {
        return MandateId;
    }

    public void setMandateId(String mandateId) {
        this.MandateId = mandateId;
    }

    public String getStatementDescriptor() {
        return StatementDescriptor;
    }

    public void setStatementDescriptor(String statementDescriptor) {
        this.StatementDescriptor = statementDescriptor;
    }
}
