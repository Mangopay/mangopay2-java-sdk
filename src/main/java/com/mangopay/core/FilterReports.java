package com.mangopay.core;

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
        ResultCode = new ArrayList<>();
    }

    /**
     * @deprecated Use {@link #getStatus()} and {@link #setStatus(List)} instead.
     */
    @Deprecated
    public List<TransactionStatus> Status;

    /**
     * @deprecated Use {@link #getType()} and {@link #setType(List)} instead.
     */
    @Deprecated
    public List<TransactionType> Type;

    /**
     * @deprecated Use {@link #getNature()} and {@link #setNature(List)} instead.
     */
    @Deprecated
    public List<TransactionNature> Nature;

    /**
     * @deprecated Use {@link #getBeforeDate()} and {@link #setBeforeDate(Long)} instead.
     */
    @Deprecated
    public Long BeforeDate;

    /**
     * @deprecated Use {@link #getAfterDate()} and {@link #setAfterDate(Long)} instead.
     */
    @Deprecated
    public Long AfterDate;

    /**
     * @deprecated Use {@link #getResultCode()} and {@link #setResultCode(List)} instead.
     */
    @Deprecated
    public List<String> ResultCode;

    /**
     * @deprecated Use {@link #getAuthorId()} and {@link #setAuthorId(String)} instead.
     */
    @Deprecated
    public String AuthorId;

    /**
     * @deprecated Use {@link #getWalletId()} and {@link #setWalletId(String)} instead.
     */
    @Deprecated
    public String WalletId;

    /**
     * @deprecated Use {@link #getMinDebitedFundsAmount()} and {@link #setMinDebitedFundsAmount(Integer)} instead.
     */
    @Deprecated
    public Integer MinDebitedFundsAmount;

    /**
     * @deprecated Use {@link #getMinDebitedFundsCurrency()} and {@link #setMinDebitedFundsCurrency(CurrencyIso)} instead.
     */
    @Deprecated
    public CurrencyIso MinDebitedFundsCurrency;

    /**
     * @deprecated Use {@link #getMaxDebitedFundsAmount()} and {@link #setMaxDebitedFundsAmount(Integer)} instead.
     */
    @Deprecated
    public Integer MaxDebitedFundsAmount;

    /**
     * @deprecated Use {@link #getMaxDebitedFundsCurrency()} and {@link #getMaxDebitedFundsCurrency()} instead.
     */
    @Deprecated
    public CurrencyIso MaxDebitedFundsCurrency;

    public List<TransactionStatus> getStatus() {
        return Status;
    }

    public void setStatus(List<TransactionStatus> status) {
        this.Status = status;
    }

    public List<TransactionType> getType() {
        return Type;
    }

    public void setType(List<TransactionType> type) {
        this.Type = type;
    }

    public List<TransactionNature> getNature() {
        return Nature;
    }

    public void setNature(List<TransactionNature> nature) {
        this.Nature = nature;
    }

    public Long getBeforeDate() {
        return BeforeDate;
    }

    public void setBeforeDate(Long beforeDate) {
        this.BeforeDate = beforeDate;
    }

    public Long getAfterDate() {
        return AfterDate;
    }

    public void setAfterDate(Long afterDate) {
        this.AfterDate = afterDate;
    }

    public List<String> getResultCode() {
        return ResultCode;
    }

    public void setResultCode(List<String> resultCode) {
        this.ResultCode = resultCode;
    }

    public String getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(String authorId) {
        this.AuthorId = authorId;
    }

    public String getWalletId() {
        return WalletId;
    }

    public void setWalletId(String walletId) {
        this.WalletId = walletId;
    }

    public Integer getMinDebitedFundsAmount() {
        return MinDebitedFundsAmount;
    }

    public void setMinDebitedFundsAmount(Integer minDebitedFundsAmount) {
        this.MinDebitedFundsAmount = minDebitedFundsAmount;
    }

    public CurrencyIso getMinDebitedFundsCurrency() {
        return MinDebitedFundsCurrency;
    }

    public void setMinDebitedFundsCurrency(CurrencyIso minDebitedFundsCurrency) {
        this.MinDebitedFundsCurrency = minDebitedFundsCurrency;
    }

    public Integer getMaxDebitedFundsAmount() {
        return MaxDebitedFundsAmount;
    }

    public void setMaxDebitedFundsAmount(Integer maxDebitedFundsAmount) {
        this.MaxDebitedFundsAmount = maxDebitedFundsAmount;
    }

    public CurrencyIso getMaxDebitedFundsCurrency() {
        return MaxDebitedFundsCurrency;
    }

    public void setMaxDebitedFundsCurrency(CurrencyIso maxDebitedFundsCurrency) {
        this.MaxDebitedFundsCurrency = maxDebitedFundsCurrency;
    }
}
