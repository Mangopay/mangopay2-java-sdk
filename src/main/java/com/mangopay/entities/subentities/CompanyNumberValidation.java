package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.CountryIso;

import java.util.List;

public class CompanyNumberValidation {
    /**
     * The registration number of a legal entity, assigned by the relevant national authority.
     */
    @SerializedName("CompanyNumber")
    private String CompanyNumber;

    /**
     * The country of the registration of the legal entity, against which the company number format is validated.
     */
    @SerializedName("CountryCode")
    private CountryIso CountryCode;

    /**
     * Whether the format of the value is valid for the country.
     */
    @SerializedName("IsValid")
    private Boolean isValid;

    /**
     * The list of regular expressions applicable to the country. Rules only exist for countries listed in the Company number article.
     * <p></p>
     * Note: Any non-alphanumeric characters, like dashes or spaces, are removed before applying the validation rules.
     */
    @SerializedName("ValidationRules")
    private List<String> validationRules;

    public String getCompanyNumber() {
        return CompanyNumber;
    }

    public CompanyNumberValidation setCompanyNumber(String companyNumber) {
        CompanyNumber = companyNumber;
        return this;
    }

    public CountryIso getCountryCode() {
        return CountryCode;
    }

    public CompanyNumberValidation setCountryCode(CountryIso countryCode) {
        CountryCode = countryCode;
        return this;
    }

    public Boolean getValid() {
        return isValid;
    }

    public CompanyNumberValidation setValid(Boolean valid) {
        isValid = valid;
        return this;
    }

    public List<String> getValidationRules() {
        return validationRules;
    }

    public CompanyNumberValidation setValidationRules(List<String> validationRules) {
        this.validationRules = validationRules;
        return this;
    }
}
