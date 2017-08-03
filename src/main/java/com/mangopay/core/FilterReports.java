package com.mangopay.core;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.TransactionNature;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter for report.
 */
public class FilterReports extends Dto {

    public FilterReports() {
        resultCode = new ArrayList<>();
    }

    /*
     * Common
     */

    @SerializedName("BeforeDate")
    private Long beforeDate;

    @SerializedName("AfterDate")
    private Long afterDate;

    /*
     * Transactions Report
     */

    @SerializedName("Status")
    private List<TransactionStatus> status;

    @SerializedName("Type")
    private List<TransactionType> type;

    @SerializedName("Nature")
    private List<TransactionNature> nature;

    @SerializedName("ResultCode")
    private List<String> resultCode;

    @SerializedName("AuthorId")
    private String authorId;

    @SerializedName("WalletId")
    private String walletId;

    @SerializedName("MinDebitedFundsAmount")
    private Integer minDebitedFundsAmount;

    @SerializedName("MinDebitedFundsCurrency")
    private CurrencyIso minDebitedFundsCurrency;

    @SerializedName("MaxDebitedFundsAmount")
    private Integer maxDebitedFundsAmount;

    @SerializedName("MaxDebitedFundsCurrency")
    private CurrencyIso maxDebitedFundsCurrency;

    /*
    * Wallets Report
    */

    /**
     * The ID of the wallet owner requesting the report.
     */
    @SerializedName("OwnerId")
    private String ownerId;

    /**
     * The currency used in the report.
     */
    @SerializedName("Currency")
    private CurrencyIso currency;

    /**
     * The minimum balance amount of the wallets taken into consideration.
     */
    @SerializedName("MinBalanceAmount")
    private int minBalanceAmount;

    /**
     * The currency of the {@link #minBalanceAmount} filter.
     */
    @SerializedName("MinBalanceCurrency")
    private CurrencyIso minBalanceCurrency;

    /**
     * The maximum balance amount of the wallets taken into consideration.
     */
    @SerializedName("MaxBalanceAmount")
    private int maxBalanceAmount;

    /**
     * The currency of the {@link #maxBalanceAmount} filter.
     */
    @SerializedName("MaxBalanceCurrency")
    private CurrencyIso maxBalanceCurrency;

    public List<TransactionStatus> getStatus() {
        return status;
    }

    public void setStatus(List<TransactionStatus> status) {
        this.status = status;
    }

    public List<TransactionType> getType() {
        return type;
    }

    public void setType(List<TransactionType> type) {
        this.type = type;
    }

    public List<TransactionNature> getNature() {
        return nature;
    }

    public void setNature(List<TransactionNature> nature) {
        this.nature = nature;
    }

    public Long getBeforeDate() {
        return beforeDate;
    }

    public void setBeforeDate(Long beforeDate) {
        this.beforeDate = beforeDate;
    }

    public Long getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(Long afterDate) {
        this.afterDate = afterDate;
    }

    public List<String> getResultCode() {
        return resultCode;
    }

    public void setResultCode(List<String> resultCode) {
        this.resultCode = resultCode;
    }

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId;
    }

    public Integer getMinDebitedFundsAmount() {
        return minDebitedFundsAmount;
    }

    public void setMinDebitedFundsAmount(Integer minDebitedFundsAmount) {
        this.minDebitedFundsAmount = minDebitedFundsAmount;
    }

    public CurrencyIso getMinDebitedFundsCurrency() {
        return minDebitedFundsCurrency;
    }

    public void setMinDebitedFundsCurrency(CurrencyIso minDebitedFundsCurrency) {
        this.minDebitedFundsCurrency = minDebitedFundsCurrency;
    }

    public Integer getMaxDebitedFundsAmount() {
        return maxDebitedFundsAmount;
    }

    public void setMaxDebitedFundsAmount(Integer maxDebitedFundsAmount) {
        this.maxDebitedFundsAmount = maxDebitedFundsAmount;
    }

    public CurrencyIso getMaxDebitedFundsCurrency() {
        return maxDebitedFundsCurrency;
    }

    public void setMaxDebitedFundsCurrency(CurrencyIso maxDebitedFundsCurrency) {
        this.maxDebitedFundsCurrency = maxDebitedFundsCurrency;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public CurrencyIso getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyIso currency) {
        this.currency = currency;
    }

    public int getMinBalanceAmount() {
        return minBalanceAmount;
    }

    public void setMinBalanceAmount(int minBalanceAmount) {
        this.minBalanceAmount = minBalanceAmount;
    }

    public CurrencyIso getMinBalanceCurrency() {
        return minBalanceCurrency;
    }

    public void setMinBalanceCurrency(CurrencyIso minBalanceCurrency) {
        this.minBalanceCurrency = minBalanceCurrency;
    }

    public int getMaxBalanceAmount() {
        return maxBalanceAmount;
    }

    public void setMaxBalanceAmount(int maxBalanceAmount) {
        this.maxBalanceAmount = maxBalanceAmount;
    }

    public CurrencyIso getMaxBalanceCurrency() {
        return maxBalanceCurrency;
    }

    public void setMaxBalanceCurrency(CurrencyIso maxBalanceCurrency) {
        this.maxBalanceCurrency = maxBalanceCurrency;
    }
}
