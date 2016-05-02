package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.FilterTransactions;
import com.mangopay.core.Pagination;
import com.mangopay.core.RestTool;
import com.mangopay.core.Sorting;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.FundsType;
import com.mangopay.entities.Client;
import com.mangopay.entities.ClientLogo;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.Wallet;
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

    /**
     * Gets client data for Basic Access Authentication.
     * @param clientId      Client identifier.
     * @param clientName    Beautiful name for presentation.
     * @param clientEmail   Client's email.
     * @return              Client instance returned from API.
     * @throws Exception
     */
    public Client create(final String clientId, final String clientName, final String clientEmail) throws Exception {

        String urlMethod = this.getRequestUrl("authentication_base");
        String requestType = this.getRequestType("authentication_base");
        
        Map<String, String> requestData = new HashMap<String, String>() {{
            put("ClientId", clientId);
            put("Name", clientName);
            put("Email", clientEmail);
        }};
        
        RestTool rest = new RestTool(this._root, false);
        rest.addRequestHttpHeader("Content-Type", "application/x-www-form-urlencoded");
        return rest.request(Client.class, null, urlMethod, requestType, requestData);
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
}
