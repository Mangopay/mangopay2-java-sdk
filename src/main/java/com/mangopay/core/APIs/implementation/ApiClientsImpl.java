package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.declaration.ApiClients;
import com.mangopay.core.FilterKycDocuments;
import com.mangopay.core.FilterTransactions;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.FundsType;
import com.mangopay.entities.*;
import com.mangopay.entities.subentities.PayInPaymentDetailsBankWire;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * API for clients.
 */
public class ApiClientsImpl extends ApiBase implements ApiClients {

    /**
     * Instantiates new ApiClientsImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiClientsImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public List<KycDocument> getKycDocuments(Pagination pagination, FilterKycDocuments filter, Sorting sort) throws Exception {
        if (filter == null) filter = new FilterKycDocuments();

        return this.getList(KycDocument[].class, KycDocument.class, "client_get_kyc_documents", pagination, null, null, filter.getValues(), sort);
    }

    @Override
    public Client get() throws Exception {
        return this.getObject(Client.class, "client_get", null);
    }

    @Override
    public Client save(Client client) throws Exception {
        return this.updateObject(Client.class, "client_save", client);
    }

    @Override
    public void uploadLogo(byte[] binaryData) throws Exception {
        String fileContent = new String(org.apache.commons.codec.binary.Base64.encodeBase64(binaryData));

        ClientLogo clientLogo = new ClientLogo();

        clientLogo.setFile(fileContent);

        this.updateObject(ClientLogo.class, "client_upload_logo", clientLogo);
    }

    @Override
    public void uploadLogo(String filePath) throws Exception {
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);

        uploadLogo(fileArray);
    }

    @Override
    public List<Wallet> getWallets(FundsType fundsType, Pagination pagination) throws Exception {

        switch (fundsType) {
            case DEFAULT:
                return this.getList(Wallet[].class, Wallet.class, "client_get_wallets_default", pagination, null, null, null);
            case FEES:
                return this.getList(Wallet[].class, Wallet.class, "client_get_wallets_fees", pagination, null, null, null);
            case CREDIT:
                return this.getList(Wallet[].class, Wallet.class, "client_get_wallets_credit", pagination, null, null, null);
        }

        return null;

    }

    @Override
    public Wallet getWallet(FundsType fundsType, CurrencyIso currency) throws Exception {
        if (currency == CurrencyIso.NotSpecified) return null;

        switch (fundsType) {
            case DEFAULT:
                return this.getObject(Wallet.class, "client_get_wallets_default_with_currency", currency.toString());
            case FEES:
                return this.getObject(Wallet.class, "client_get_wallets_fees_with_currency", currency.toString());
            case CREDIT:
                return this.getObject(Wallet.class, "client_get_wallets_credit_with_currency", currency.toString());
        }

        return null;
    }

    @Override
    public List<Transaction> getWalletTransactions(FundsType fundsType, CurrencyIso currency, Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception {

        if (filter == null) filter = new FilterTransactions();

        return this.getList(Transaction[].class, Transaction.class, "client_get_wallet_transactions", pagination, fundsType.toString(), currency.toString(), filter.getValues(), sort);

    }

    @Override
    public List<Transaction> getTransactions(Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception {
        if (filter == null) filter = new FilterTransactions();

        return this.getList(Transaction[].class, Transaction.class, "client_get_transactions", pagination, null, null, filter.getValues(), sort);
    }

    @Override
    public PayIn createBankWireDirect(ClientBankWireDirect bankWireDirect) throws Exception {
        return createBankWireDirect(null, bankWireDirect);
    }

    @Override
    public PayIn createBankWireDirect(String idempotencyKey, ClientBankWireDirect bankWireDirect) throws Exception {
        PayIn payIn = new PayIn();
        payIn.setCreditedWalletId(bankWireDirect.getCreditedWalletId());
        payIn.setPaymentDetails(new PayInPaymentDetailsBankWire());
        ((PayInPaymentDetailsBankWire) payIn.getPaymentDetails()).setDeclaredDebitedFunds(bankWireDirect.getDeclaredDebitedFunds());

        return this.createObject(PayIn.class, idempotencyKey, "client_create_bankwire_direct", payIn);
    }
}
