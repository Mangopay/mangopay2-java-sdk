package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;
import com.mangopay.entities.subentities.InternationalAccountDetails;
import com.mangopay.entities.subentities.LocalAccountDetails;
import com.mangopay.entities.subentities.VirtualAccountCapabilities;

import java.util.List;

public class VirtualAccount extends EntityBase {

    @SerializedName("WalletId")
    private String walletId;

    @SerializedName("CreditedUserId")
    private String creditedUserId;

    @SerializedName("VirtualAccountPurpose")
    private String virtualAccountPurpose;

    @SerializedName("Country")
    private String country;

    @SerializedName("Status")
    private String status;

    @SerializedName("Active")
    private Boolean active;

    @SerializedName("AccountOwner")
    private String accountOwner;

    @SerializedName("LocalAccountDetails")
    private LocalAccountDetails localAccountDetails;

    @SerializedName("InternationalAccountDetails")
    private List<InternationalAccountDetails> internationalAccountDetails;

    @SerializedName("Capabilities")
    private VirtualAccountCapabilities capabilities;

    public String getWalletId() {
        return walletId;
    }

    public VirtualAccount setWalletId(String walletId) {
        this.walletId = walletId;
        return this;
    }

    public String getCreditedUserId() {
        return creditedUserId;
    }

    public VirtualAccount setCreditedUserId(String creditedUserId) {
        this.creditedUserId = creditedUserId;
        return this;
    }

    public String getVirtualAccountPurpose() {
        return virtualAccountPurpose;
    }

    public VirtualAccount setVirtualAccountPurpose(String virtualAccountPurpose) {
        this.virtualAccountPurpose = virtualAccountPurpose;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public VirtualAccount setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public VirtualAccount setStatus(String status) {
        this.status = status;
        return this;
    }

    public Boolean getActive() {
        return active;
    }

    public VirtualAccount setActive(Boolean active) {
        this.active = active;
        return this;
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public VirtualAccount setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner;
        return this;
    }

    public LocalAccountDetails getLocalAccountDetails() {
        return localAccountDetails;
    }

    public VirtualAccount setLocalAccountDetails(LocalAccountDetails localAccountDetails) {
        this.localAccountDetails = localAccountDetails;
        return this;
    }

    public List<InternationalAccountDetails> getInternationalAccountDetails() {
        return internationalAccountDetails;
    }

    public VirtualAccount setInternationalAccountDetails(List<InternationalAccountDetails> internationalAccountDetails) {
        this.internationalAccountDetails = internationalAccountDetails;
        return this;
    }

    public VirtualAccountCapabilities getCapabilities() {
        return capabilities;
    }

    public VirtualAccount setCapabilities(VirtualAccountCapabilities capabilities) {
        this.capabilities = capabilities;
        return this;
    }
}
