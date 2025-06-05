package com.mangopay.core.APIs;

import com.mangopay.core.*;
import com.mangopay.entities.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by thepa on 18-Jan-17.
 */
public interface DisputeApi {
    /**
     * Gets dispute.
     *
     * @param disputeId Dispute identifier.
     * @return Dispute instance returned from API.
     * @throws Exception
     */
    Dispute get(String disputeId) throws Exception;

    /**
     * Gets all disputes.
     *
     * @param pagination Pagination.
     * @param filters    Filters.
     * @param sorting    Sorting.
     * @return List of Dispute instances returned from API.
     * @throws Exception
     */
    List<Dispute> getAll(Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception;

    /**
     * Gets all disputes.
     *
     * @return List of Dispute instances returned from API.
     * @throws Exception
     */
    List<Dispute> getAll() throws Exception;

    /**
     * Gets dispute's transactions.
     *
     * @param disputeId  Dispute identifier.
     * @param pagination Pagination.
     * @param filters    Filters.
     * @param sorting    Sorting.
     * @return List of Transaction instances returned from API.
     * @throws Exception
     */
    List<Transaction> getTransactions(String disputeId, Pagination pagination, FilterTransactions filters, Sorting sorting) throws Exception;

    /**
     * Gets dispute's documents for wallet.
     *
     * @param walletId   Wallet identifier.
     * @param pagination Pagination.
     * @param filters    Filters.
     * @param sorting    Sorting.
     * @return List of dispute instances returned from API.
     * @throws Exception
     */
    List<Dispute> getDisputesForWallet(String walletId, Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception;

    /**
     * Gets user's disputes.
     *
     * @param userId     User identifier.
     * @param pagination Pagination.
     * @param filters    Filters.
     * @param sorting    Sorting.
     * @return List of Dispute instances returned from API.
     * @throws Exception
     */
    List<Dispute> getDisputesForUser(String userId, Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception;

    /**
     * Gets dispute's document.
     *
     * @param documentId Dispute document identifier.
     * @return Dispute's document instance returned from API.
     * @throws Exception
     */
    DisputeDocument getDocument(String documentId) throws Exception;

    /**
     * Gets documents for dispute.
     *
     * @param disputeId  Dispute identifier.
     * @param pagination Pagination.
     * @param filters    Filters.
     * @param sorting    Sorting.
     * @return List of DisputeDocument instances returned from API.
     * @throws Exception
     */
    List<DisputeDocument> getDocumentsForDispute(String disputeId, Pagination pagination, FilterDisputeDocuments filters, Sorting sorting) throws Exception;

    /**
     * Gets dispute's documents for client.
     *
     * @param pagination Pagination.
     * @param filters    Filters.
     * @param sorting    Sorting.
     * @return List of dispute documents returned from API.
     * @throws Exception
     */
    List<DisputeDocument> getDocumentsForClient(Pagination pagination, FilterDisputeDocuments filters, Sorting sorting) throws Exception;

    /**
     * Gets repudiation.
     *
     * @param repudiationId Repudiation identifier.
     * @return Repudiation instance returned from API.
     * @throws Exception
     * @deprecated use {@link RepudiationApi#getRepudiation(String)} instead
     */
    @Deprecated
    Repudiation getRepudiation(String repudiationId) throws Exception;

    /**
     * Creates settlement transfer.
     *
     * @param settlementTransfer Settlement transfer.
     * @param repudiationId      Repudiation identifier.
     * @return Transfer instance returned from API.
     * @throws Exception
     */
    Transfer createSettlementTransfer(SettlementTransfer settlementTransfer, String repudiationId) throws Exception;

    /**
     * Creates settlement transfer.
     *
     * @param idempotencyKey     idempotency key for this request.
     * @param settlementTransfer Settlement transfer.
     * @param repudiationId      Repudiation identifier.
     * @return Transfer instance returned from API.
     * @throws Exception
     */
    Transfer createSettlementTransfer(String idempotencyKey, SettlementTransfer settlementTransfer, String repudiationId) throws Exception;

    /**
     * Get disputes that need settling
     *
     * @return a list of {@link Dispute}s
     * @throws Exception
     */
    List<Dispute> getDisputesWithPendingSettlement() throws Exception;

    /**
     * Get disputes that need settling
     *
     * @param pagination Pagination object
     * @param sorting    Sorting object
     * @return a list of {@link Dispute}s
     * @throws Exception
     */
    List<Dispute> getDisputesWithPendingSettlement(Pagination pagination, Sorting sorting) throws Exception;

    /**
     * Updates dispute's tag.
     *
     * @param tag       New tag text.
     * @param disputeId Dispute identifier.
     * @return Dispute instance returned from API.
     * @throws Exception
     */
    Dispute updateTag(String tag, String disputeId) throws Exception;

    /**
     * Submits dispute document.
     *
     * @param disputeDocument Dispute document to be submitted.
     * @param disputeId       Dispute identifier.
     * @return Dispute document instance returned from API.
     * @throws Exception
     */
    DisputeDocument submitDisputeDocument(DisputeDocument disputeDocument, String disputeId) throws Exception;

    /**
     * Contests dispute.
     *
     * @param contestedFunds Contested funds.
     * @param disputeId      Dispute identifier.
     * @return Dispute instance returned from API.
     * @throws Exception
     */
    Dispute contestDispute(Money contestedFunds, String disputeId) throws Exception;

    /**
     * Resubmits dispute.
     *
     * @param disputeId Dispute identifier.
     * @return Dispute instance returned from API.
     * @throws Exception
     */
    Dispute resubmitDispute(String disputeId) throws Exception;

    /**
     * Closes dispute.
     *
     * @param disputeId Dispute identifier.
     * @return Dispute instance returned from API.
     * @throws Exception
     */
    Dispute closeDispute(String disputeId) throws Exception;

    /**
     * Creates document for dispute.
     *
     * @param disputeDocument Dispute document to be created.
     * @param disputeId       Dispute identifier.
     * @return Dispute document returned from API.
     * @throws Exception
     */
    DisputeDocument createDisputeDocument(DisputeDocument disputeDocument, String disputeId) throws Exception;

    /**
     * Creates document for dispute.
     *
     * @param idempotencyKey  idempotency key for this request.
     * @param disputeDocument Dispute document to be created.
     * @param disputeId       Dispute identifier.
     * @return Dispute document returned from API.
     * @throws Exception
     */
    DisputeDocument createDisputeDocument(String idempotencyKey, DisputeDocument disputeDocument, String disputeId) throws Exception;

    /**
     * Creates document's page for dispute.
     *
     * @param disputeId  Dispute identifier.
     * @param documentId Dispute document identifier.
     * @param binaryData The byte array the DisputePage will be created from.
     * @throws Exception
     */
    void createDisputePage(String disputeId, String documentId, byte[] binaryData) throws Exception;

    /**
     * Creates document's page for dispute.
     *
     * @param idempotencyKey idempotency key for this request.
     * @param disputeId      Dispute identifier.
     * @param documentId     Dispute document identifier.
     * @param binaryData     The byte array the DisputePage will be created from.
     * @throws Exception
     */
    void createDisputePage(String idempotencyKey, String disputeId, String documentId, byte[] binaryData) throws Exception;

    /**
     * Creates document's page for dispute.
     *
     * @param disputeId  Dispute identifier.
     * @param documentId Dispute document identifier.
     * @param filePath   Path to the file the DisputePage will be created from.
     * @throws IOException
     * @throws Exception
     */
    void createDisputePage(String disputeId, String documentId, String filePath) throws Exception;

    /**
     * Creates document's page for dispute.
     *
     * @param idempotencyKey idempotency key for this request.
     * @param disputeId      Dispute identifier.
     * @param documentId     Dispute document identifier.
     * @param filePath       Path to the file the DisputePage will be created from.
     * @throws IOException
     * @throws Exception
     */
    void createDisputePage(String idempotencyKey, String disputeId, String documentId, String filePath) throws Exception;

    /**
     * Creates temporary URLs where each page of a dispute document can be viewed.
     *
     * @param documentId Identification of the document whose pages to view
     * @return List of consults for viewing the dispute document's pages
     * @throws Exception
     */
    List<DocumentPageConsult> createDisputeDocumentConsult(String documentId) throws Exception;

    List<Dispute> getDisputesForPayIn(String payInId, Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception;
}
