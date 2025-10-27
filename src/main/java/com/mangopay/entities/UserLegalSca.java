package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Address;
import com.mangopay.core.LegalRepresentative;
import com.mangopay.core.enumerations.LegalPersonType;
import com.mangopay.core.enumerations.PersonType;
import com.mangopay.entities.subentities.PendingUserAction;

/**
 * UserLegal entity.
 */
public final class UserLegalSca extends User {

    /**
     * Headquarters address.
     */
    @SerializedName("HeadquartersAddress")
    private Address headquartersAddress;

    /**
     * Headquarters address.
     */
    @SerializedName("LegalRepresentativeAddress")
    private Address legalRepresentativeAddress;

    /**
     * Name of this user.
     */
    @SerializedName("Name")
    private String name;

    /**
     * Type of legal user.
     */
    @SerializedName("LegalPersonType")
    private LegalPersonType legalPersonType;

    /**
     * Proof of registration.
     */
    @SerializedName("ProofOfRegistration")
    private String proofOfRegistration;

    /**
     * Shareholder declaration.
     */
    @SerializedName("ShareholderDeclaration")
    private String shareholderDeclaration;

    /**
     * Statute.
     */
    @SerializedName("Statute")
    private String statute;

    /**
     * Company number.
     */
    @SerializedName("CompanyNumber")
    private String companyNumber;

    /**
     * Information about the action required from the user if action was triggered by the API call (otherwise returned null).
     */
    @SerializedName("PendingUserAction")
    private PendingUserAction pendingUserAction;

    @SerializedName("LegalRepresentative")
    private LegalRepresentative legalRepresentative;

    /**
     * If provided, possible values: USER_NOT_PRESENT, USER_PRESENT
     */
    @SerializedName("ScaContext")
    private String scaContext;

    public UserLegalSca() {
        this.personType = PersonType.LEGAL;
    }

    public Address getHeadquartersAddress() {
        return headquartersAddress;
    }

    public void setHeadquartersAddress(Address headquartersAddress) {
        this.headquartersAddress = headquartersAddress;
    }

    public Address getLegalRepresentativeAddress() {
        return legalRepresentativeAddress;
    }

    public void setLegalRepresentativeAddress(Address legalRepresentativeAddress) {
        this.legalRepresentativeAddress = legalRepresentativeAddress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LegalPersonType getLegalPersonType() {
        return legalPersonType;
    }

    public void setLegalPersonType(LegalPersonType legalPersonType) {
        this.legalPersonType = legalPersonType;
    }

    public String getProofOfRegistration() {
        return proofOfRegistration;
    }

    public void setProofOfRegistration(String proofOfRegistration) {
        this.proofOfRegistration = proofOfRegistration;
    }

    public String getShareholderDeclaration() {
        return shareholderDeclaration;
    }

    public void setShareholderDeclaration(String shareholderDeclaration) {
        this.shareholderDeclaration = shareholderDeclaration;
    }

    public String getStatute() {
        return statute;
    }

    public void setStatute(String statute) {
        this.statute = statute;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public LegalRepresentative getLegalRepresentative() {
        return legalRepresentative;
    }

    public void setLegalRepresentative(LegalRepresentative legalRepresentative) {
        this.legalRepresentative = legalRepresentative;
    }

    public PendingUserAction getPendingUserAction() {
        return pendingUserAction;
    }

    public String getScaContext() {
        return scaContext;
    }

    public UserLegalSca setScaContext(String scaContext) {
        this.scaContext = scaContext;
        return this;
    }
}
