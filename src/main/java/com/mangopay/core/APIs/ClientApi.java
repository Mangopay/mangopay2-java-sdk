package com.mangopay.core.APIs;

import com.mangopay.core.FilterKycDocuments;
import com.mangopay.core.FilterTransactions;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.FundsType;
import com.mangopay.entities.*;

import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface ClientApi {
    List<KycDocument> getKycDocuments(Pagination pagination, FilterKycDocuments filter, Sorting sort) throws Exception;

    Client get() throws Exception;

    Client save(Client client) throws Exception;

    void uploadLogo(byte[] binaryData) throws Exception;

    void uploadLogo(String filePath) throws Exception;

    List<Wallet> getWallets(FundsType fundsType, Pagination pagination) throws Exception;

    Wallet getWallet(FundsType fundsType, CurrencyIso currency) throws Exception;

    List<Transaction> getWalletTransactions(FundsType fundsType, CurrencyIso currency, Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception;

    List<Transaction> getTransactions(Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception;

    PayIn createBankWireDirect(ClientBankWireDirect bankWireDirect) throws Exception;

    PayIn createBankWireDirect(String idempotencyKey, ClientBankWireDirect bankWireDirect) throws Exception;
}
