package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.*;
import com.mangopay.entities.Dispute;
import com.mangopay.entities.DisputeDocument;
import com.mangopay.entities.DisputePage;
import com.mangopay.entities.KycPage;
import com.mangopay.entities.Repudiation;
import com.mangopay.entities.SettlementTransfer;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.Transfer;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.apache.commons.codec.binary.Base64;

/**
 * API for disputes.
 */
public class ApiDisputes extends ApiBase {
    
    /**
     * Instantiates new ApiDisputes object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiDisputes(MangoPayApi root) { super(root); }
    
    /**
     * Gets dispute.
     * @param disputeId     Dispute identifier.
     * @return              Dispute instance returned from API.
     * @throws Exception
     */
    public Dispute get(String disputeId) throws Exception {
            return this.getObject(Dispute.class, "disputes_get", disputeId);
    }
    
    /**
     * Gets all disputes.
     * @param pagination    Pagination.
     * @param filters       Filters.
     * @param sorting       Sorting.
     * @return              List of Dispute instances returned from API.
     * @throws Exception
     */
    public List<Dispute> getAll(Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputes();

        return this.getList(Dispute[].class, Dispute.class, "disputes_get_all", pagination, null, filters.getValues(), sorting);
    }
    
    /**
     * Gets all disputes.
     * @return              List of Dispute instances returned from API.
     * @throws Exception
     */
    public List<Dispute> getAll() throws Exception {
            return this.getAll(null, null, null);
    }
    
    /**
     * Gets dispute's transactions.
     * @param disputeId     Dispute identifier.
     * @param pagination    Pagination.
     * @param filters       Filters.
     * @param sorting       Sorting.
     * @return              List of Transaction instances returned from API.
     * @throws Exception
     */
    public List<Transaction> getTransactions(String disputeId, Pagination pagination, FilterTransactions filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterTransactions();

        return this.getList(Transaction[].class, Transaction.class, "disputes_get_transactions", pagination, disputeId, filters.getValues(), sorting);
    }
    
    /**
     * Gets dispute's documents for wallet.
     * @param walletId      Wallet identifier.
     * @param pagination    Pagination.
     * @param filters       Filters.
     * @param sorting       Sorting.
     * @return              List of dispute instances returned from API.
     * @throws Exception
     */
    public List<Dispute> getDisputesForWallet(String walletId, Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputes();

        return this.getList(Dispute[].class, Dispute.class, "disputes_get_for_wallet", pagination, walletId, filters.getValues(), sorting);
    }
    
    /**
     * Gets user's disputes.
     * @param userId        User identifier.
     * @param pagination    Pagination.
     * @param filters       Filters.
     * @param sorting       Sorting.
     * @return              List of Dispute instances returned from API.
     * @throws Exception
     */
    public List<Dispute> getDisputesForUser(String userId, Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputes();

        return this.getList(Dispute[].class, Dispute.class, "disputes_get_for_user", pagination, userId, filters.getValues(), sorting);
    }
    
    /**
     * Gets dispute's document.
     * @param documentId    Dispute document identifier.
     * @return              Dispute's document instance returned from API.
     * @throws Exception
     */
    public DisputeDocument getDocument(String documentId) throws Exception {
        return this.getObject(DisputeDocument.class, "disputes_document_get", documentId);
    }
    
    /**
     * Gets documents for dispute.
     * @param disputeId     Dispute identifier.
     * @param pagination    Pagination.
     * @param filters       Filters.
     * @param sorting       Sorting.
     * @return              List of DisputeDocument instances returned from API.
     * @throws Exception
     */
    public List<DisputeDocument> getDocumentsForDispute(String disputeId, Pagination pagination, FilterDisputeDocuments filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputeDocuments();

        return this.getList(DisputeDocument[].class, DisputeDocument.class, "disputes_document_get_for_dispute", pagination, disputeId, filters.getValues(), sorting);
    }
    
    /**
     * Gets dispute's documents for client.
     * @param pagination    Pagination.
     * @param filters       Filters.
     * @param sorting       Sorting.
     * @return              List of dispute documents returned from API.
     * @throws Exception
     */
    public List<DisputeDocument> getDocumentsForClient(Pagination pagination, FilterDisputeDocuments filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputeDocuments();

        return this.getList(DisputeDocument[].class, DisputeDocument.class, "disputes_document_get_for_client", pagination, null, filters.getValues(), sorting);
    }
    
    /**
     * Gets repudiation.
     * @param repudiationId     Repudiation identifier.
     * @return                  Repudiation instance returned from API.
     * @throws Exception
     */
    public Repudiation getRepudiation(String repudiationId) throws Exception {
        return this.getObject(Repudiation.class, "disputes_repudiation_get", repudiationId);
    }
    
    /**
     * Creates settlement transfer.
     * @param settlementTransfer    Settlement transfer.
     * @param repudiationId         Repudiation identifier.
     * @return                      Transfer instance returned from API.
     * @throws Exception
     */
        public Transfer createSettlementTransfer(SettlementTransfer settlementTransfer, String repudiationId) throws Exception {
            Transfer settlement = new Transfer();
            settlement.AuthorId = settlementTransfer.AuthorId;
            settlement.DebitedFunds = settlementTransfer.DebitedFunds;
            settlement.Fees = settlementTransfer.Fees;
            return this.createObject(Transfer.class, "disputes_repudiation_create_settlement", settlement, repudiationId);
    }
    
    /**
     * Updates dispute's tag.
     * @param tag           New tag text.
     * @param disputeId     Dispute identifier.
     * @return              Dispute instance returned from API.
     * @throws Exception
     */
    public Dispute updateTag(String tag, String disputeId) throws Exception {
        Dispute dispute = new Dispute();
        dispute.Tag = tag;

        return this.updateObject(Dispute.class, "disputes_save_tag", dispute, disputeId);
    }
    
    /**
     * Submits dispute document.
     * @param disputeDocument   Dispute document to be submitted.
     * @param disputeId         Dispute identifier.
     * @return                  Dispute document instance returned from API.
     * @throws Exception
     */
    public DisputeDocument submitDisputeDocument(DisputeDocument disputeDocument, String disputeId) throws Exception {
        return this.updateObject(DisputeDocument.class, "disputes_document_submit", disputeDocument, disputeId);
    }
    
    /**
     * Contests dispute.
     * @param contestedFunds    Contested funds.
     * @param disputeId         Dispute identifier.
     * @return                  Dispute instance returned from API.
     * @throws Exception
     */
    public Dispute contestDispute(Money contestedFunds, String disputeId) throws Exception {
        Dispute disputeContest = new Dispute();
        disputeContest.ContestedFunds = contestedFunds;

        return this.updateObject(Dispute.class, "disputes_save_contest_funds", disputeContest, disputeId);
    }
    
    /**
     * Resubmits dispute.
     * @param disputeId     Dispute identifier.
     * @return              Dispute instance returned from API.
     * @throws Exception
     */
    public Dispute resubmitDispute(String disputeId) throws Exception {
        Dispute dispute = new Dispute();
        return this.updateObject(Dispute.class, "disputes_save_contest_funds", dispute, disputeId);
    }
    
    /**
     * Closes dispute.
     * @param disputeId     Dispute identifier.
     * @return              Dispute instance returned from API.
     * @throws Exception
     */
    public Dispute closeDispute(String disputeId) throws Exception {
        return this.updateObject(Dispute.class, "disputes_save_close", new Dispute(), disputeId);
    }
    
    /**
     * Creates document for dispute.
     * @param disputeDocument   Dispute document to be created.
     * @param disputeId         Dispute identifier.
     * @return                  Dispute document returned from API.
     * @throws Exception
     */
    public DisputeDocument createDisputeDocument(DisputeDocument disputeDocument, String disputeId) throws Exception {
        return this.createObject(DisputeDocument.class, "disputes_document_create", disputeDocument, disputeId);
    }
    
    /**
     * Creates document's page for dispute.
     * @param disputeId     Dispute identifier.
     * @param documentId    Dispute document identifier.
     * @param binaryData    The byte array the DisputePage will be created from.
     * @throws Exception
     */
    public void createDisputePage(String disputeId, String documentId, byte[] binaryData) throws Exception {
        DisputePage disputePage = new DisputePage();
        
        String fileContent = new String(Base64.encodeBase64(binaryData));
        
        disputePage.File = fileContent;
        
        this.createObject(DisputePage.class, "disputes_document_page_create", disputePage, disputeId, documentId);
    }
    
    /**
     * Creates document's page for dispute.
     * @param disputeId     Dispute identifier.
     * @param documentId    Dispute document identifier.
     * @param filePath      Path to the file the DisputePage will be created from.
     * @throws IOException
     * @throws Exception
     */
    public void createDisputePage(String disputeId, String documentId, String filePath) throws IOException, Exception {
        
        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);
        
        createDisputePage(disputeId, documentId, fileArray);
    }
}
