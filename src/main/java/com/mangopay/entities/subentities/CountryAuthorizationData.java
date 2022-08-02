package com.mangopay.entities.subentities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.Dto;

public class CountryAuthorizationData extends Dto {
    @SerializedName("BlockUserCreation")
    private Boolean blockUserCreation;

    @SerializedName("BlockBankAccountCreation")
    private Boolean blockBankAccountCreation;

    @SerializedName("BlockPayout")
    private Boolean blockPayout;

    public Boolean getBlockUserCreation() {
        return blockUserCreation;
    }

    public CountryAuthorizationData setBlockUserCreation(Boolean blockUserCreation) {
        this.blockUserCreation = blockUserCreation;
        return this;
    }

    public Boolean getBlockBankAccountCreation() {
        return blockBankAccountCreation;
    }

    public CountryAuthorizationData setBlockBankAccountCreation(Boolean blockBankAccountCreation) {
        this.blockBankAccountCreation = blockBankAccountCreation;
        return this;
    }

    public Boolean getBlockPayout() {
        return blockPayout;
    }

    public CountryAuthorizationData setBlockPayout(Boolean blockPayout) {
        this.blockPayout = blockPayout;
        return this;
    }
}
