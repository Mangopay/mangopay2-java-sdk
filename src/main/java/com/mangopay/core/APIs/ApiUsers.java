package com.mangopay.core.APIs;

import com.mangopay.core.enumerations.KycDocumentType;
import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.entities.*;
import java.nio.file.*;
import java.util.List;
import org.apache.commons.codec.binary.Base64;


/**
 * API for users.
 */
public class ApiUsers extends ApiBase {

    /**
     * Instantiates new ApiUsers object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiUsers(MangoPayApi root) { super(root); }

    /**
     * Gets user.
     * @param userId    User identifier.
     * @return          User instance returned from API, which is either of UserNatural or UserLegal type.
     * @throws Exception
     */
    public User get(String userId) throws Exception {
        return this.getObject(User.class, "users_get", userId);
    }
    
    /**
     * Creates new user.
     * @param user  User object to be created.
     * @return      User instance returned from API, which is either of UserNatural or UserLegal type.
     * @throws Exception
     */
    public User create(User user) throws Exception {
        return create(null, user);
    }
    
    /**
     * Creates new user.
     * @param idempotencyKey    Idempotency key for this request.
     * @param user              User object to be created.
     * @return                  User instance returned from API, which is either of UserNatural or UserLegal type.
     * @throws Exception
     */
    public User create(String idempotencyKey, User user) throws Exception {
        
        User response = null;
        
        if (user instanceof UserNatural)
            response = this.createObject(UserNatural.class, idempotencyKey, "users_createnaturals", (UserNatural)user);
        else if (user instanceof UserLegal)
            response = this.createObject(UserLegal.class, idempotencyKey, "users_createlegals", (UserLegal)user);
        else
            throw new Exception("Unsupported user entity type.");
        
        return response;
    }

    /**
     * Gets page of users.
     * @param pagination    Pagination object.
     * @return              Collection of User instances.
     * @throws Exception
     */
    public List<User> getAll(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(User[].class, User.class, "users_all", pagination, sorting);
    }
    
    /**
     * Gets first page of users.
     * @return      Collection of User instances.
     * @throws Exception
     */
    public List<User> getAll() throws Exception {
        return getAll(null, null);
    }
    
    /**
     * Gets natural user by its identifier,
     * @param userId    UserNatural identifier.
     * @return          UserNatural object returned from API.
     * @throws Exception
     */
    public UserNatural getNatural(String userId) throws Exception {
        return this.getObject(UserNatural.class, "users_getnaturals", userId);
    }
    
    /**
     * Gets legal user by its identifier.
     * @param userId    UserLegal identifier.
     * @return          UserLegal object returned from API.
     * @throws Exception
     */
    public UserLegal getLegal(String userId) throws Exception {
        return this.getObject(UserLegal.class, "users_getlegals", userId);
    }
    
    /**
     * Updates the user.
     * @param user      Instance of UserNatural or UserLegal class to be updated.
     * @return          Updated User object returned from API.
     * @throws Exception
     */
    public User update(User user) throws Exception {
        
        String methodKey = "";
        if (user instanceof UserNatural)
            methodKey = "users_savenaturals";
        else if (user instanceof UserLegal)
            methodKey = "users_savelegals";
        else
            throw new Exception("Unsupported user entity type.");
        
        return this.updateObject(User.class, methodKey, user);
    }
    
    /**
     * Creates bank account for user.
     * @param userId        User identifier to create bank account for.
     * @param bankAccount   Bank account object.
     * @return              Created bank account object returned from API.
     * @throws Exception
     */
    public BankAccount createBankAccount(String userId, BankAccount bankAccount) throws Exception {
        return this.createBankAccount(null, userId, bankAccount);
    }
    
    /**
     * Creates bank account for user.
     * @param idempotencyKey    Idempotency key for this request.
     * @param userId            User identifier to create bank account for.
     * @param bankAccount       Bank account object.
     * @return                  Created bank account object returned from API.
     * @throws Exception
     */
    public BankAccount createBankAccount(String idempotencyKey, String userId, BankAccount bankAccount) throws Exception {
        String type = this.getBankAccountType(bankAccount);
        return this.createObject(BankAccount.class, idempotencyKey, "users_createbankaccounts_" + type, bankAccount, userId);
    }
    
    /**
     * Updates bank account.
     * @param userId            User identifier.
     * @param bankAccount       Bank account object.
     * @param bankAccountId     Bank account identifier.
     * @return                  Updated bank account object returned from API.
     * @throws Exception
     */
    public BankAccount updateBankAccount(String userId, BankAccount bankAccount, String bankAccountId) throws Exception {
        return this.updateObject(BankAccount.class, "users_savebankaccount", bankAccount, userId, bankAccountId);
    }
    
    /**
     * Gets all bank accounts of user.
     * @param userId        User identifier to get bank accounts of.
     * @param pagination    Pagination object.
     * @param sorting       Sorting object.
     * @return              Collection of bank accounts of user.
     * @throws Exception
     */
    public List<BankAccount> getBankAccounts(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(BankAccount[].class, BankAccount.class, "users_allbankaccount", pagination, userId, sorting);
    }
    
    /**
     * Gets first page of all bank accounts of user.
     * @param userId        User identifier to get bank accounts of.
     * @return              Collection of bank accounts of user.
     * @throws Exception
     */
    public List<BankAccount> getBankAccounts(String userId) throws Exception {
        return getBankAccounts(userId, null, null);
    }
    
    /**
     * Gets bank account of user.
     * @param userId        User identifier.
     * @param bankAccountId Bank account identifier.
     * @return              Bank account object returned from API.
     * @throws Exception
     */
    public BankAccount getBankAccount(String userId, String bankAccountId) throws Exception {
        return this.getObject(BankAccount.class, "users_getbankaccount", userId, bankAccountId);
    }
    
    /**
     * Gets all wallets of user.
     * @param userId        User identifier to get bank accounts of.
     * @param pagination    Pagination object.
     * @param sorting       Sorting object.
     * @return              Collection of wallets of user.
     * @throws Exception
     */
    public List<Wallet> getWallets(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Wallet[].class, Wallet.class, "users_allwallets", pagination, userId, sorting);
    }
    
    /**
     * Gets first page of all wallets of user.
     * @param userId        User identifier to get bank accounts of.
     * @return              Collection of wallets of user.
     * @throws Exception
     */
    public List<Wallet> getWallets(String userId) throws Exception {
        return getWallets(userId, null, null);
    }
    
    /**
     * Gets transactions for user.
     * @param userId        User identifier.
     * @param pagination    Pagination object.
     * @param filter        Filter object.
     * @param sorting       Sorting object.
     * @return              Collection of transactions of user.
     * @throws Exception
     */
    public List<Transaction> getTransactions(String userId, Pagination pagination, FilterTransactions filter, Sorting sorting) throws Exception {
        return this.getList(Transaction[].class, Transaction.class, "users_alltransactions", pagination, userId, filter.getValues(), sorting);
    }
    
    /**
     * Gets all cards for user.
     * @param userId        User identifier.
     * @param pagination    Pagination object.
     * @param sorting       Sorting object.
     * @return              Collection of user's cards.
     * @throws Exception
     */
    public List<Card> getCards(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Card[].class, Card.class, "users_allcards", pagination, userId, sorting);
    }
    
    /**
     * Creates KycPage from byte array.
     * @param userId            User identifier.
     * @param kycDocumentId     Kyc document identifier.
     * @param binaryData        The byte array the KycPage will be created from.
     * @throws Exception
     */
    public void createKycPage(String userId, String kycDocumentId, byte[] binaryData) throws Exception {
        createKycPage(null, userId, kycDocumentId, binaryData);
    }
    
    /**
     * Creates KycPage from byte array.
     * @param idempotencyKey    Idempotency key for this request.
     * @param userId            User identifier.
     * @param kycDocumentId     Kyc document identifier.
     * @param binaryData        The byte array the KycPage will be created from.
     * @throws Exception
     */
    public void createKycPage(String idempotencyKey, String userId, String kycDocumentId, byte[] binaryData) throws Exception {
        KycPage kycPage = new KycPage();
        
        String fileContent = new String(Base64.encodeBase64(binaryData));
        
        kycPage.setFile(fileContent);
        
        this.createObject(KycPage.class, idempotencyKey, "kyc_page_create", kycPage, userId, kycDocumentId);
    }
    
    /**
     * Creates KycPage from file.
     * @param userId            User identifier.
     * @param kycDocumentId     Kyc document identifier.
     * @param filePath          Path to the file the KycPage will be created from.
     * @throws Exception
     */
    public void createKycPage(String userId, String kycDocumentId, String filePath) throws Exception {
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);
        
        createKycPage(userId, kycDocumentId, fileArray);
    }
    
    /**
     * Creates KycPage from file.
     * @param idempotencyKey    Idempotency key for this request.
     * @param userId            User identifier.
     * @param kycDocumentId     Kyc document identifier.
     * @param filePath          Path to the file the KycPage will be created from.
     * @throws Exception
     */
    public void createKycPage(String idempotencyKey, String userId, String kycDocumentId, String filePath) throws Exception {
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);
        
        createKycPage(idempotencyKey, userId, kycDocumentId, fileArray);
    }
    
    /**
     * Creates KycDocument.
     * @param userId        User identifier.
     * @param type          Type of KycDocument.
     * @return              KycDocument object returned from API.
     * @throws Exception
     */
    public KycDocument createKycDocument(String userId, KycDocumentType type) throws Exception {
        return createKycDocument(null, userId, type);
    }
    
    /**
     * Creates KycDocument.
     * @param idempotencyKey    Idempotency key for this request.
     * @param userId            User identifier.
     * @param type              Type of KycDocument.
     * @return                  KycDocument object returned from API.
     * @throws Exception
     */
    public KycDocument createKycDocument(String idempotencyKey, String userId, KycDocumentType type) throws Exception {
        KycDocument kycDocument = new KycDocument();
        kycDocument.setType(type);
        
        return this.createObject(KycDocument.class, idempotencyKey, "users_createkycdocument", kycDocument, userId);
    }
    
    /**
     * Gets KycDocument.
     * @param userId        User identifier.
     * @param kycDocumentId KycDocument identifier.
     * @return              KycDocument object returned from API.
     * @throws Exception
     */
    public KycDocument getKycDocument(String userId, String kycDocumentId) throws Exception {
        return this.getObject(KycDocument.class, "users_getkycdocument", userId, kycDocumentId);
    }
    
    /**
     * Updates KycDocument.
     * @param userId        User identifier.
     * @param kycDocument   KycDocument entity instance to be updated.
     * @return              KycDocument object returned from API.
     * @throws Exception
     */
    public KycDocument updateKycDocument(String userId, KycDocument kycDocument) throws Exception {
        return this.updateObject(KycDocument.class, "users_savekycdocument", kycDocument, userId);
    }
    
    /**
     * Gets all KYC documents for single user.
     * @param userId        User identifier.
     * @param pagination    Pagination.
     * @param sorting       Sorting object.
     * @return              List of KycDocuments returned from API.
     * @throws Exception
     */
    public List<KycDocument> getKycDocuments(String userId, Pagination pagination, Sorting sorting) throws Exception{
        return this.getList(KycDocument[].class, KycDocument.class, "users_allkycdocuments", pagination, userId, sorting);
    }
    
    private String getBankAccountType(BankAccount bankAccount) throws Exception {
        
        if (bankAccount.getDetails() == null)
            throw new Exception("Details is not defined.");
        
        String className = bankAccount.Details.getClass().getSimpleName().replace("BankAccountDetails", "");
        return className.toLowerCase();
    }
}
