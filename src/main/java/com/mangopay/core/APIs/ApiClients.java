package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.FilterKycDocuments;
import com.mangopay.core.FilterTransactions;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.FundsType;
import com.mangopay.entities.Client;
import com.mangopay.entities.ClientBankWireDirect;
import com.mangopay.entities.ClientLogo;
import com.mangopay.entities.KycDocument;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.Wallet;
import com.mangopay.entities.subentities.PayInPaymentDetailsBankWire;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * API for clients.
 */
public class ApiClients extends ApiBase {
    
    /**
     * Instantiates new ApiClients object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiClients(MangoPayApi root) { super(root); }

    public List<KycDocument> getKycDocuments(Pagination pagination, FilterKycDocuments filter, Sorting sort) throws Exception
    {
        if (filter == null) filter = new FilterKycDocuments();
        
        return this.getList(KycDocument[].class, KycDocument.class, "client_get_kyc_documents", pagination, null, null, filter.getValues(), sort);
    }
    
    public Client get() throws Exception {
        return this.getObject(Client.class, "client_get", null);
    }
    
    public Client save(Client client) throws Exception {
        return this.updateObject(Client.class, "client_save", client);
    }
    
    public void uploadLogo(byte[] binaryData) throws Exception {
        String fileContent = new String(org.apache.commons.codec.binary.Base64.encodeBase64(binaryData));
        
        ClientLogo clientLogo = new ClientLogo();
        
        clientLogo.File = fileContent;
        
        this.updateObject(ClientLogo.class, "client_upload_logo", clientLogo);
    }
    
    public void uploadLogo(String filePath) throws Exception {
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);
        
        uploadLogo(fileArray);
    }
    
    public List<Wallet> getWallets(FundsType fundsType, Pagination pagination) throws Exception {
        
        switch (fundsType)
        {
            case DEFAULT:
                return this.getList(Wallet[].class, Wallet.class, "client_get_wallets_default", pagination, null, null, null);
            case FEES:
                return this.getList(Wallet[].class, Wallet.class, "client_get_wallets_fees", pagination, null, null, null);
            case CREDIT:
                return this.getList(Wallet[].class, Wallet.class, "client_get_wallets_credit", pagination, null, null, null);
        }

        return null;
        
    }
    
    public Wallet getWallet(FundsType fundsType, CurrencyIso currency) throws Exception
    {
        if (currency == CurrencyIso.NotSpecified) return null;

        switch (fundsType)
        {
            case DEFAULT:
                return this.getObject(Wallet.class, "client_get_wallets_default_with_currency", currency.toString());
            case FEES:
                return this.getObject(Wallet.class, "client_get_wallets_fees_with_currency", currency.toString());
            case CREDIT:
                return this.getObject(Wallet.class, "client_get_wallets_credit_with_currency", currency.toString());
        }

        return null;
    }
    
    public List<Transaction> getWalletTransactions(FundsType fundsType, CurrencyIso currency, Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception {
        
        if (filter == null) filter = new FilterTransactions();

        return this.getList(Transaction[].class, Transaction.class, "client_get_wallet_transactions", pagination, fundsType.toString(), currency.toString(), filter.getValues(), sort);
        
    }
    
    public List<Transaction> getTransactions(Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception
    {
        if (filter == null) filter = new FilterTransactions();

        return this.getList(Transaction[].class, Transaction.class, "client_get_transactions", pagination, null, null, filter.getValues(), sort);
    }
    
    public PayIn createBankWireDirect(ClientBankWireDirect bankWireDirect) throws Exception
    {
        return createBankWireDirect(null, bankWireDirect);
    }
    
    public PayIn createBankWireDirect(String idempotencyKey, ClientBankWireDirect bankWireDirect) throws Exception
    {
        PayIn payIn = new PayIn();
        payIn.CreditedWalletId = bankWireDirect.CreditedWalletId;
        payIn.PaymentDetails = new PayInPaymentDetailsBankWire();
        ((PayInPaymentDetailsBankWire)payIn.PaymentDetails).DeclaredDebitedFunds = bankWireDirect.DeclaredDebitedFunds;
        
        return this.createObject(PayIn.class, idempotencyKey, "client_create_bankwire_direct", payIn);
    }
}
