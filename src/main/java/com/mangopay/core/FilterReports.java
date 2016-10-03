package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Filter for report.
 */
public class FilterReports extends Dto {

    public FilterReports()
    {
        ResultCode = new ArrayList<>();
    }

    public List<TransactionStatus> Status;

    public List<TransactionType> Type;

    public List<TransactionNature> Nature;

    public Long BeforeDate;

    public Long AfterDate;

    public List<String> ResultCode;

    public String AuthorId;

    public String WalletId;

    public Integer MinDebitedFundsAmount;

    public CurrencyIso MinDebitedFundsCurrency;

    public Integer MaxDebitedFundsAmount;

    public CurrencyIso MaxDebitedFundsCurrency;
    
}
