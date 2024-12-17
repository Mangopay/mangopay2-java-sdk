package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;
import com.mangopay.core.enumerations.PayInReferences;
import com.mangopay.core.interfaces.PayInTransactionDetails;

import java.util.List;

/**
 * Class representing the BankWire type for mean of payment in PayIn entity.
 */
public class PayInTransactionDetailsBankWire extends Dto implements PayInTransactionDetails {

    @SerializedName("BankTransactionDomainCode")
    private String bankTransactionDomainCode;

    @SerializedName("BankTransactionDomainFamilyCode")
    private String bankTransactionDomainFamilyCode;

    @SerializedName("BankTransactionDomainSubFamilyCode")
    private String bankTransactionDomainSubFamilyCode;

    @SerializedName("References")
    private List<PayInReferences> references;

    @SerializedName("DebtorName")
    private String debtorName;

    @SerializedName("DebtorAccount")
    private String debtorAccount;

    @SerializedName("DebtorAgent")
    private String debtorAgent;

    @SerializedName("DebtorAddressLine1")
    private String debtorAddressLine1;

    @SerializedName("DebtorAddressLine2")
    private String debtorAddressLine2;

    @SerializedName("DebtorAddressLine3")
    private String debtorAddressLine3;

    @SerializedName("RemittanceInformationLine1")
    private String remittanceInformationLine1;

    @SerializedName("RemittanceInformationLine2")
    private String remittanceInformationLine2;

    @SerializedName("RemittanceInformationLine3")
    private String remittanceInformationLine3;

    @SerializedName("RemittanceInformationLine4")
    private String remittanceInformationLine4;

    public String getBankTransactionDomainCode() {
        return bankTransactionDomainCode;
    }

    public void setBankTransactionDomainCode(String bankTransactionDomainCode) {
        this.bankTransactionDomainCode = bankTransactionDomainCode;
    }

    public String getBankTransactionDomainFamilyCode() {
        return bankTransactionDomainFamilyCode;
    }

    public void setBankTransactionDomainFamilyCode(String bankTransactionDomainFamilyCode) {
        this.bankTransactionDomainFamilyCode = bankTransactionDomainFamilyCode;
    }

    public String getBankTransactionDomainSubFamilyCode() {
        return bankTransactionDomainSubFamilyCode;
    }

    public void setBankTransactionDomainSubFamilyCode(String bankTransactionDomainSubFamilyCode) {
        this.bankTransactionDomainSubFamilyCode = bankTransactionDomainSubFamilyCode;
    }

    public List<PayInReferences> getReferences() {
        return references;
    }

    public void setReferences(List<PayInReferences> references) {
        this.references = references;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getDebtorAccount() {
        return debtorAccount;
    }

    public void setDebtorAccount(String debtorAccount) {
        this.debtorAccount = debtorAccount;
    }

    public String getDebtorAgent() {
        return debtorAgent;
    }

    public void setDebtorAgent(String debtorAgent) {
        this.debtorAgent = debtorAgent;
    }

    public String getDebtorAddressLine1() {
        return debtorAddressLine1;
    }

    public void setDebtorAddressLine1(String debtorAddressLine1) {
        this.debtorAddressLine1 = debtorAddressLine1;
    }

    public String getDebtorAddressLine2() {
        return debtorAddressLine2;
    }

    public void setDebtorAddressLine2(String debtorAddressLine2) {
        this.debtorAddressLine2 = debtorAddressLine2;
    }

    public String getDebtorAddressLine3() {
        return debtorAddressLine3;
    }

    public void setDebtorAddressLine3(String debtorAddressLine3) {
        this.debtorAddressLine3 = debtorAddressLine3;
    }

    public String getRemittanceInformationLine1() {
        return remittanceInformationLine1;
    }

    public void setRemittanceInformationLine1(String remittanceInformationLine1) {
        this.remittanceInformationLine1 = remittanceInformationLine1;
    }

    public String getRemittanceInformationLine2() {
        return remittanceInformationLine2;
    }

    public void setRemittanceInformationLine2(String remittanceInformationLine2) {
        this.remittanceInformationLine2 = remittanceInformationLine2;
    }

    public String getRemittanceInformationLine3() {
        return remittanceInformationLine3;
    }

    public void setRemittanceInformationLine3(String remittanceInformationLine3) {
        this.remittanceInformationLine3 = remittanceInformationLine3;
    }

    public String getRemittanceInformationLine4() {
        return remittanceInformationLine4;
    }

    public void setRemittanceInformationLine4(String remittanceInformationLine4) {
        this.remittanceInformationLine4 = remittanceInformationLine4;
    }

    public PayInTransactionDetailsBankWire() {

    }
}
