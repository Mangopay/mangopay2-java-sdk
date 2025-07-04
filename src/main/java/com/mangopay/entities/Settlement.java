package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.EntityBase;

public class Settlement extends EntityBase {
    /**
     * The unique identifier of the settlement object
     */
    @SerializedName("SettlementId")
    private String settlementId;

    /**
     * The status of the settlement
     */
    @SerializedName("Status")
    private String status;

    /**
     * The date at which the settlement was created by the external provider
     */
    @SerializedName("SettlementDate")
    private String settlementDate;

    /**
     * The name of the external provider
     */
    @SerializedName("ExternalProviderName")
    private String externalProviderName;

    /**
     * The total amount declared through intent API calls with the following calculation:
     * (Sum of captured intents) - (Sum of refunds amounts) + (Sum of refund reversed amounts) - (Sum of DISPUTED disputes) + (Sum of WON disputes)
     */
    @SerializedName("DeclaredIntentAmount")
    private Integer declaredIntentAmount;

    /**
     * The total fees charged by the external provider
     */
    @SerializedName("ExternalProcessorFeesAmount")
    private Integer externalProcessorFeesAmount;

    /**
     * The total amount due to the platform (to be held in escrow wallet).
     * This amount correspond to the TotalSettlementAmount from the settlement file.
     * A negative amount will result in this parameter being set to zero, indicating no incoming funds to the escrow wallet.
     */
    @SerializedName("ActualSettlementAmount")
    private Integer actualSettlementAmount;

    /**
     * The difference between ActualSettlementAmount and the amount received on the escrow wallet
     */
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