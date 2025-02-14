package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

import java.util.List;

public class RecipientPropertySchema extends Dto {
    @SerializedName("Required")
    private Boolean required;

    @SerializedName("MaxLength")
    private Integer maxLength;

    @SerializedName("MinLength")
    private Integer minLength;

    @SerializedName("Pattern")
    private String pattern;

    @SerializedName("AllowedValues")
    private List<String> allowedValues;

    public Boolean getRequired() {
        return required;
    }

    public RecipientPropertySchema setRequired(Boolean required) {
        this.required = required;
        return this;
    }

    public Integer getMaxLength() {
        return maxLength;
    }

    public RecipientPropertySchema setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
        return this;
    }

    public Integer getMinLength() {
        return minLength;
    }

    public RecipientPropertySchema setMinLength(Integer minLength) {
        this.minLength = minLength;
        return this;
    }

    public String getPattern() {
        return pattern;
    }

    public RecipientPropertySchema setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public List<String> getAllowedValues() {
        return allowedValues;
    }

    public RecipientPropertySchema setAllowedValues(List<String> allowedValues) {
        this.allowedValues = allowedValues;
        return this;
    }
}
