package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class Settlement extends EntityBase {
    @SerializedName("SettlementId")
    private String settlementId;

    @SerializedName("Status")
    private String status;

    @SerializedName("SettlementDate")
    private String settlementDate;

    @SerializedName("ExternalProviderName")
    private String externalProviderName;

    @SerializedName("DeclaredIntentAmount")
    private Integer declaredIntentAmount;

    @SerializedName("ExternalProcessorFeesAmount")
    private Integer externalProcessorFeesAmount;

    @SerializedName("ActualSettlementAmount")
    private Integer actualSettlementAmount;

    @SerializedName("FundsMissingAmount")
    private Integer fundsMissingAmount;

    public String getSettlementId() {
        return settlementId;
    }

    public Settlement setSettlementId(String settlementId) {
        this.settlementId = settlementId;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Settlement setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getSettlementDate() {
        return settlementDate;
    }

    public Settlement setSettlementDate(String settlementDate) {
        this.settlementDate = settlementDate;
        return this;
    }

    public String getExternalProviderName() {
        return externalProviderName;
    }

    public Settlement setExternalProviderName(String externalProviderName) {
        this.externalProviderName = externalProviderName;
        return this;
    }

    public Integer getDeclaredIntentAmount() {
        return declaredIntentAmount;
    }

    public Settlement setDeclaredIntentAmount(Integer declaredIntentAmount) {
        this.declaredIntentAmount = declaredIntentAmount;
        return this;
    }

    public Integer getExternalProcessorFeesAmount() {
        return externalProcessorFeesAmount;
    }

    public Settlement setExternalProcessorFeesAmount(Integer externalProcessorFeesAmount) {
        this.externalProcessorFeesAmount = externalProcessorFeesAmount;
        return this;
    }

    public Integer getActualSettlementAmount() {
        return actualSettlementAmount;
    }

    public Settlement setActualSettlementAmount(Integer actualSettlementAmount) {
        this.actualSettlementAmount = actualSettlementAmount;
        return this;
    }

    public Integer getFundsMissingAmount() {
        return fundsMissingAmount;
    }

    public Settlement setFundsMissingAmount(Integer fundsMissingAmount) {
        this.fundsMissingAmount = fundsMissingAmount;
        return this;
    }
}