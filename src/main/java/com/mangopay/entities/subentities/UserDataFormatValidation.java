package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class UserDataFormatValidation extends EntityBase {
    /**
     * Information about the registration number of a legal entity
     */
    @SerializedName("CompanyNumber")
    private CompanyNumberValidation companyNumber;

    public CompanyNumberValidation getCompanyNumber() {
        return companyNumber;
    }

    public UserDataFormatValidation setCompanyNumber(CompanyNumberValidation companyNumberValidation) {
        this.companyNumber = companyNumberValidation;
        return this;
    }
}
