package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.*;
import org.apache.commons.codec.binary.Base64;;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.commons.codec.binary.StringUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.apache.commons.codec.binary.StringUtils;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * API for Users.
 */
public class ApiUsers extends ApiBase {

    /**
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiUsers(MangoPayApi root) { super(root); }

    /**
     * Gets user by its identifier.
     * @param userId    User identifier.
     * @return          User instance returned from API, which is either of
                        UserNatural or UserLegal type.
     * @throws Exception
     */
    public User get(String userId) throws Exception {
        return this.getObject(User.class, "users_get", userId);
    }
    
    /**
     * Creates new user.
     * @param user  User object to be created.
     * @return      User instance returned from API, which is either of
                    UserNatural or UserLegal type.
     * @throws Exception
     */
    public User create(User user) throws Exception {
        
        User response = null;
        
        if (user instanceof UserNatural)
            response = this.createObject(UserNatural.class, "users_createnaturals", (UserNatural)user);
        else if (user instanceof UserLegal)
            response = this.createObject(UserLegal.class, "users_createlegals", (UserLegal)user);
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
    public List<User> getAll(Pagination pagination) throws Exception {
        return this.getList(User[].class, User.class, "users_all", pagination);
    }
    
    /**
     * Gets first page of users.
     * @return      Collection of User instances.
     * @throws Exception
     */
    public List<User> getAll() throws Exception {
        return getAll(null);
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
     * @param user      Instance of UserNatural or UserLegal class to be 
                        updated.
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
     * @return              Created bank account object returned by API.
     * @throws Exception
     */
    public BankAccount createBankAccount(String userId, BankAccount bankAccount) throws Exception {
        return this.createObject(BankAccount.class, "users_createbankaccounts", bankAccount, userId);
    }    
    
    /**
     * Gets all bank accounts of user.
     * @param userId        User identifier to get bank accounts of.
     * @param pagination    Pagination object.
     * @return              Collection of bank accounts of user.
     * @throws Exception
     */
    public List<BankAccount> getBankAccounts(String userId, Pagination pagination) throws Exception {
        return this.getList(BankAccount[].class, BankAccount.class, "users_allbankaccount", pagination, userId);
    }
    
    /**
     * Gets first page of all bank accounts of user.
     * @param userId        User identifier to get bank accounts of.
     * @return              Collection of bank accounts of user.
     * @throws Exception
     */
    public List<BankAccount> getBankAccounts(String userId) throws Exception {
        return getBankAccounts(userId, null);
    }
    
    /**
     * Gets bank account of user.
     * @param userId        User identifier.
     * @param bankAccountId Bank account identifier.
     * @return              Bank account object returned by API.
     * @throws Exception
     */
    public BankAccount getBankAccount(String userId, String bankAccountId) throws Exception {
        return this.getObject(BankAccount.class, "users_getbankaccount", userId, bankAccountId);
    }
    
    public void createKycPage(String userId, String kycDocumentId, byte[] binaryData) throws Exception {
        KycPage kycPage = new KycPage();
        
        String fileContent = new String(Base64.encodeBase64(binaryData));
        
        kycPage.File = fileContent;
        
        try
        {
            this.createObject(KycPage.class, "users_createkycpage", kycPage, userId, kycDocumentId);
        }
        catch (Exception ex)
        {
            Exception e = ex;
        }
    }
    
    public void createKycPage(String userId, String kycDocumentId, String filePath) throws Exception {
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);
        
        createKycPage(userId, kycDocumentId, fileArray);
    }
    
    public KycDocument createKycDocument(String userId, KycDocumentType type) throws Exception {
        KycDocument kycDocument = new KycDocument();
        kycDocument.Type = type.name();
        
        return this.createObject(KycDocument.class, "users_createkycdocument", kycDocument, userId);
    }
    
    public KycDocument getKycDocument(String userId, String kycDocumentId) throws Exception {
        return this.getObject(KycDocument.class, "users_getkycdocument", userId, kycDocumentId);
    }
    
    public KycDocument updateKycDocument(String userId, KycDocument kycDocument) throws Exception {
        return this.updateObject(KycDocument.class, "users_savekycdocument", kycDocument, userId);
    }
}
