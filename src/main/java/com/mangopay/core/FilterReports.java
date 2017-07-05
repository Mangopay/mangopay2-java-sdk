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

    @SerializedName("Status")
    private List<TransactionStatus> status;

    @SerializedName("Type")
    private List<TransactionType> type;

    @SerializedName("Nature")
    private List<TransactionNature> nature;

    @SerializedName("BeforeDate")
    private Long beforeDate;

    @SerializedName("AfterDate")
    private Long afterDate;

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
}
