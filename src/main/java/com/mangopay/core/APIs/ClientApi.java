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

    /**
     * Get client information.
     *
     * @return Client object returned from API
     * @throws Exception
     */
    Client get() throws Exception;

    /**
     * Save client
     *
     * @param client Updated client object to save
     * @return The updated Client from API
     * @throws Exception
     */
    Client save(Client client) throws Exception;

    /**
     * Upload a logo for client.
     * Only GIF, PNG, JPG, JPEG, BMP, PDF and DOC formats are accepted,
     * and file must be less than about 7MB.
     *
     * @param binaryData Bytes of the image file
     * @throws Exception
     */
    void uploadLogo(byte[] binaryData) throws Exception;

    /**
     * Upload a logo for client.
     * Only GIF, PNG, JPG, JPEG, BMP, PDF and DOC formats are accepted,
     * and file must be less than about 7MB.
     *
     * @param filePath File path of the image to upload
     * @throws Exception
     */
    void uploadLogo(String filePath) throws Exception;

    /**
     * View your client wallets. To see your fees or credit wallets
     * for each currency set the {@code fundsType} parameter.
     *
     * @param fundsType  One of {@link FundsType}s
     * @param pagination Pagination object
     * @return List of current user's wallets
     * @throws Exception
     */
    List<Wallet> getWallets(FundsType fundsType, Pagination pagination) throws Exception;

    /**
     * View one of your client wallets (fees or credit) with a particular currency.
     *
     * @param fundsType One of {@link FundsType}s
     * @param currency  The particular {@link CurrencyIso}
     * @return Wallet (fees or credit) in the specified currency
     * @throws Exception
     */
    Wallet getWallet(FundsType fundsType, CurrencyIso currency) throws Exception;

    /**
     * View the transactions linked to your client wallets (fees and credit)
     *
     * @param fundsType  One of {@link FundsType}s
     * @param currency   The {@link CurrencyIso} in which to convert results
     * @param pagination Pagination object
     * @param filter     Filtering object
     * @param sort       Sorting object
     * @return Matching transactions linked to your client wallets (fees and credit)
     * @throws Exception
     */
    List<Transaction> getWalletTransactions(FundsType fundsType, CurrencyIso currency, Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception;

    /**
     * View all transactions linked to your client wallets.
     *
     * @param pagination Pagination object
     * @param filter     Filtering object
     * @param sort       Sorting object
     * @return Paginated response comprising current user's transactions
     * @throws Exception
     */
    List<Transaction> getTransactions(Pagination pagination, FilterTransactions filter, Sorting sort) throws Exception;

    /**
     * Request processing of a payment by bank wire. The workflow is the following:q
     * <ul><li>
     * Call the /payins/bankwire/direct object. You’ll receive MANGOPAY bank account details and a reference.
     * </li><li>
     * Display this information to your user
     * </li><li>
     * The user has to proceed a Bank wire to the display bank account with the reference
     * </li><li>
     * Once MANGOPAY receive the payment the e-money is created and the targeted e-wallet is credited
     * </li>
     * </ul>
     *
     * @param bankWireDirect The Bank Wire Direct details
     * @return PayIn generated for the Bank Wire payment.
     * @throws Exception
     */
    PayIn createBankWireDirect(ClientBankWireDirect bankWireDirect) throws Exception;

    /**
     * Request processing of a payment by bank wire. The workflow is the following:q
     * <ul><li>
     * Call the /payins/bankwire/direct object. You’ll receive MANGOPAY bank account details and a reference.
     * </li><li>
     * Display this information to your user
     * </li><li>
     * The user has to proceed a Bank wire to the display bank account with the reference
     * </li><li>
     * Once MANGOPAY receive the payment the e-money is created and the targeted e-wallet is credited
     * </li>
     * </ul>
     *
     * @param idempotencyKey Idempotency key
     * @param bankWireDirect The Bank Wire Direct details
     * @return PayIn generated for the Bank Wire payment.
     * @throws Exception
     */
    PayIn createBankWireDirect(String idempotencyKey, ClientBankWireDirect bankWireDirect) throws Exception;

    BankAccount createBankAccountIBAN(BankAccount bankAccountIBAN) throws Exception;

    BankAccount createBankAccountIBAN(String idempotencyKey, BankAccount bankAccountIBAN) throws Exception;

    PayOut createPayOut(String idempotencyKey, PayOut payOut) throws Exception;

    PayOut createPayOut(PayOut payOut) throws Exception;

}
