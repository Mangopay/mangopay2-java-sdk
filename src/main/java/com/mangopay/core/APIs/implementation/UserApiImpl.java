package com.mangopay.core.APIs.implementation;

import com.google.gson.GsonBuilder;
import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.UserApi;
import com.mangopay.core.FilterTransactions;
import com.mangopay.core.Pagination;
import com.mangopay.core.Sorting;
import com.mangopay.core.deserializer.BankAccountDeserializer;
import com.mangopay.core.deserializer.UserDeserializer;
import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.KycDocumentType;
import com.mangopay.core.serializer.BankAccountSerializer;
import com.mangopay.core.serializer.UserSerializer;
import com.mangopay.entities.*;
import org.apache.commons.codec.binary.Base64;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


/**
 * API for users.
 */
public class UserApiImpl extends ApiBase implements UserApi {

    /**
     * Instantiates new UserApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public UserApiImpl(MangoPayApi root, GsonBuilder gsonBuilder) {
        super(root);
        gsonBuilder.registerTypeAdapter(User.class, new UserSerializer());
        gsonBuilder.registerTypeAdapter(User.class, new UserDeserializer());
        gsonBuilder.registerTypeAdapter(BankAccount.class, new BankAccountSerializer());
        gsonBuilder.registerTypeAdapter(BankAccount.class, new BankAccountDeserializer());
    }

    @Override
    public User get(String userId) throws Exception {
        return this.getObject(User.class, "users_get", userId);
    }

    @Override
    public User create(User user) throws Exception {
        return create(null, user);
    }

    @Override
    public User create(String idempotencyKey, User user) throws Exception {

        User response = null;

        if (user instanceof UserNatural)
            response = this.createObject(UserNatural.class, idempotencyKey, "users_createnaturals", (UserNatural) user);
        else if (user instanceof UserLegal)
            response = this.createObject(UserLegal.class, idempotencyKey, "users_createlegals", (UserLegal) user);
        else
            throw new Exception("Unsupported user entity type.");

        return response;
    }

    @Override
    public List<User> getAll(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(User[].class, User.class, "users_all", pagination, sorting);
    }

    @Override
    public List<User> getAll() throws Exception {
        return getAll(null, null);
    }

    @Override
    public UserNatural getNatural(String userId) throws Exception {
        return this.getObject(UserNatural.class, "users_getnaturals", userId);
    }

    @Override
    public UserLegal getLegal(String userId) throws Exception {
        return this.getObject(UserLegal.class, "users_getlegals", userId);
    }

    @Override
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

    @Override
    public BankAccount createBankAccount(String userId, BankAccount bankAccount) throws Exception {
        return this.createBankAccount(null, userId, bankAccount);
    }

    @Override
    public BankAccount createBankAccount(String idempotencyKey, String userId, BankAccount bankAccount) throws Exception {
        String type = this.getBankAccountType(bankAccount);
        return this.createObject(BankAccount.class, idempotencyKey, "users_createbankaccounts_" + type, bankAccount, userId);
    }

    @Override
    public BankAccount updateBankAccount(String userId, BankAccount bankAccount, String bankAccountId) throws Exception {
        return this.updateObject(BankAccount.class, "users_savebankaccount", bankAccount, userId, bankAccountId);
    }

    @Override
    public List<BankAccount> getBankAccounts(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(BankAccount[].class, BankAccount.class, "users_allbankaccount", pagination, userId, sorting);
    }

    @Override
    public List<BankAccount> getBankAccounts(String userId) throws Exception {
        return getBankAccounts(userId, null, null);
    }

    @Override
    public BankAccount getBankAccount(String userId, String bankAccountId) throws Exception {
        return this.getObject(BankAccount.class, "users_getbankaccount", userId, bankAccountId);
    }

    @Override
    public List<Transaction> getBankAccountTransactions(String bankAccountId) throws Exception {
        return this.getBankAccountTransactions(bankAccountId, null, null);
    }

    @Override
    public List<Transaction> getBankAccountTransactions(String bankAccountId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Transaction[].class, Transaction.class, "get_transactions_for_banckaccount", pagination, bankAccountId, sorting);
    }

    @Override
    public List<Wallet> getWallets(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Wallet[].class, Wallet.class, "users_allwallets", pagination, userId, sorting);
    }

    @Override
    public List<Wallet> getWallets(String userId) throws Exception {
        return getWallets(userId, null, null);
    }

    @Override
    public List<Transaction> getTransactions(String userId, Pagination pagination, FilterTransactions filter, Sorting sorting) throws Exception {
        return this.getList(Transaction[].class, Transaction.class, "users_alltransactions", pagination, userId, filter.getValues(), sorting);
    }

    @Override
    public List<Card> getCards(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Card[].class, Card.class, "users_allcards", pagination, userId, sorting);
    }

    @Override
    public void createKycPage(String userId, String kycDocumentId, byte[] binaryData) throws Exception {
        createKycPage(null, userId, kycDocumentId, binaryData);
    }

    @Override
    public void createKycPage(String idempotencyKey, String userId, String kycDocumentId, byte[] binaryData) throws Exception {
        KycPage kycPage = new KycPage();

        String fileContent = new String(Base64.encodeBase64(binaryData));

        kycPage.setFile(fileContent);

        this.createObject(KycPage.class, idempotencyKey, "kyc_page_create", kycPage, userId, kycDocumentId);
    }

    @Override
    public void createKycPage(String userId, String kycDocumentId, String filePath) throws Exception {
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);

        createKycPage(userId, kycDocumentId, fileArray);
    }

    @Override
    public void createKycPage(String idempotencyKey, String userId, String kycDocumentId, String filePath) throws Exception {
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);

        createKycPage(idempotencyKey, userId, kycDocumentId, fileArray);
    }

    @Override
    public KycDocument createKycDocument(String userId, KycDocumentType type) throws Exception {
        return createKycDocument(null, userId, type);
    }

    @Override
    public KycDocument createKycDocument(String idempotencyKey, String userId, KycDocumentType type) throws Exception {
        KycDocument kycDocument = new KycDocument();
        kycDocument.setType(type);

        return this.createObject(KycDocument.class, idempotencyKey, "users_createkycdocument", kycDocument, userId);
    }

    @Override
    public KycDocument getKycDocument(String userId, String kycDocumentId) throws Exception {
        return this.getObject(KycDocument.class, "users_getkycdocument", userId, kycDocumentId);
    }

    @Override
    public KycDocument updateKycDocument(String userId, KycDocument kycDocument) throws Exception {
        return this.updateObject(KycDocument.class, "users_savekycdocument", kycDocument, userId);
    }

    @Override
    public List<KycDocument> getKycDocuments(String userId, Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(KycDocument[].class, KycDocument.class, "users_allkycdocuments", pagination, userId, sorting);
    }

    private String getBankAccountType(BankAccount bankAccount) throws Exception {

        if (bankAccount.getDetails() == null)
            throw new Exception("Details is not defined.");

        String className = bankAccount.getDetails().getClass().getSimpleName().replace("BankAccountDetails", "");
        return className.toLowerCase();
    }

    @Override
    public EMoney getEMoney(String userId) throws Exception {
        if (userId == null) {
            throw new Exception("Cannot get EMoney without specifying the userId");
        }
        return this.getObject(EMoney.class, "users_emoney", userId);
    }

    @Override
    public EMoney getEMoney(String userId, CurrencyIso currencyIso) throws Exception {
        if (currencyIso == null) {
            return this.getEMoney(userId);
        }
        return this.getObject(EMoney.class, "users_emoney_currency", userId, currencyIso.name());
    }

    @Override
    public UboDeclaration createUboDeclaration(String userId, UboDeclaration declaration) throws Exception {
        return this.createObject(UboDeclaration.class, null, "ubo_declaration_create", declaration, userId);
    }

    @Override
    public List<CardPreAuthorization> getPreAuthorizations(String userId) throws Exception {
        return this.getList(CardPreAuthorization[].class, CardPreAuthorization.class, "users_get_preauthorizations", null, userId);
    }
}
