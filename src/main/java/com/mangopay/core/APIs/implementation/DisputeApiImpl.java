package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.DisputeApi;
import com.mangopay.core.*;
import com.mangopay.entities.*;
import org.apache.commons.codec.binary.Base64;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * API for disputes.
 */
public class DisputeApiImpl extends ApiBase implements DisputeApi {

    /**
     * Instantiates new DisputeApiImpl object.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public DisputeApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public Dispute get(String disputeId) throws Exception {
        return this.getObject(Dispute.class, "disputes_get", disputeId);
    }

    @Override
    public List<Dispute> getAll(Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputes();

        return this.getList(Dispute[].class, Dispute.class, "disputes_get_all", pagination, null, filters.getValues(), sorting);
    }

    @Override
    public List<Dispute> getAll() throws Exception {
        return this.getAll(null, null, null);
    }

    @Override
    public List<Transaction> getTransactions(String disputeId, Pagination pagination, FilterTransactions filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterTransactions();

        return this.getList(Transaction[].class, Transaction.class, "disputes_get_transactions", pagination, disputeId, filters.getValues(), sorting);
    }

    @Override
    public List<Dispute> getDisputesForWallet(String walletId, Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputes();

        return this.getList(Dispute[].class, Dispute.class, "disputes_get_for_wallet", pagination, walletId, filters.getValues(), sorting);
    }

    @Override
    public List<Dispute> getDisputesForUser(String userId, Pagination pagination, FilterDisputes filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputes();

        return this.getList(Dispute[].class, Dispute.class, "disputes_get_for_user", pagination, userId, filters.getValues(), sorting);
    }

    @Override
    public DisputeDocument getDocument(String documentId) throws Exception {
        return this.getObject(DisputeDocument.class, "disputes_document_get", documentId);
    }

    @Override
    public List<DisputeDocument> getDocumentsForDispute(String disputeId, Pagination pagination, FilterDisputeDocuments filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputeDocuments();

        return this.getList(DisputeDocument[].class, DisputeDocument.class, "disputes_document_get_for_dispute", pagination, disputeId, filters.getValues(), sorting);
    }

    @Override
    public List<DisputeDocument> getDocumentsForClient(Pagination pagination, FilterDisputeDocuments filters, Sorting sorting) throws Exception {
        if (filters == null) filters = new FilterDisputeDocuments();

        return this.getList(DisputeDocument[].class, DisputeDocument.class, "disputes_document_get_for_client", pagination, null, filters.getValues(), sorting);
    }

    @Override
    public Repudiation getRepudiation(String repudiationId) throws Exception {
        return this.getObject(Repudiation.class, "disputes_repudiation_get", repudiationId);
    }

    @Override
    public Transfer createSettlementTransfer(SettlementTransfer settlementTransfer, String repudiationId) throws Exception {
        return this.createSettlementTransfer(null, settlementTransfer, repudiationId);
    }

    @Override
    public Transfer createSettlementTransfer(String idempotencyKey, SettlementTransfer settlementTransfer, String repudiationId) throws Exception {
        Transfer settlement = new Transfer();
        settlement.setAuthorId(settlementTransfer.getAuthorId());
        settlement.setDebitedFunds(settlementTransfer.getDebitedFunds());
        settlement.setFees(settlementTransfer.getFees());
        settlement.setTag(settlementTransfer.getTag());
        return this.createObject(Transfer.class, idempotencyKey, "disputes_repudiation_create_settlement", settlement, repudiationId);
    }

    @Override
    public List<Dispute> getDisputesWithPendingSettlement() throws Exception {
        return this.getDisputesWithPendingSettlement(null, null);
    }

    @Override
    public List<Dispute> getDisputesWithPendingSettlement(Pagination pagination, Sorting sorting) throws Exception {
        return this.getList(Dispute[].class, Dispute.class, "disputes_pending_settlement", pagination, sorting);
    }

    @Override
    public Dispute updateTag(String tag, String disputeId) throws Exception {
        Dispute dispute = new Dispute();
        dispute.setTag(tag);

        return this.updateObject(Dispute.class, "disputes_save_tag", dispute, disputeId);
    }

    @Override
    public DisputeDocument submitDisputeDocument(DisputeDocument disputeDocument, String disputeId) throws Exception {
        return this.updateObject(DisputeDocument.class, "disputes_document_submit", disputeDocument, disputeId);
    }

    @Override
    public Dispute contestDispute(Money contestedFunds, String disputeId) throws Exception {
        Dispute disputeContest = new Dispute();
        disputeContest.setContestedFunds(contestedFunds);

        return this.updateObject(Dispute.class, "disputes_save_contest_funds", disputeContest, disputeId);
    }

    @Override
    public Dispute resubmitDispute(String disputeId) throws Exception {
        Dispute dispute = new Dispute();
        return this.updateObject(Dispute.class, "disputes_save_contest_funds", dispute, disputeId);
    }

    @Override
    public Dispute closeDispute(String disputeId) throws Exception {
        return this.updateObject(Dispute.class, "disputes_save_close", new Dispute(), disputeId);
    }

    @Override
    public DisputeDocument createDisputeDocument(DisputeDocument disputeDocument, String disputeId) throws Exception {
        return this.createDisputeDocument(null, disputeDocument, disputeId);
    }

    @Override
    public DisputeDocument createDisputeDocument(String idempotencyKey, DisputeDocument disputeDocument, String disputeId) throws Exception {
        return this.createObject(DisputeDocument.class, idempotencyKey, "disputes_document_create", disputeDocument, disputeId);
    }

    @Override
    public void createDisputePage(String disputeId, String documentId, byte[] binaryData) throws Exception {
        this.createDisputePage(null, disputeId, documentId);
    }

    @Override
    public void createDisputePage(String idempotencyKey, String disputeId, String documentId, byte[] binaryData) throws Exception {
        DisputePage disputePage = new DisputePage();

        String fileContent = new String(Base64.encodeBase64(binaryData));

        disputePage.setFile(fileContent);

        this.createObject(DisputePage.class, idempotencyKey, "disputes_document_page_create", disputePage, disputeId, documentId);
    }

    @Override
    public void createDisputePage(String disputeId, String documentId, String filePath) throws IOException, Exception {

        createDisputePage(null, disputeId, documentId, filePath);
    }

    @Override
    public void createDisputePage(String idempotencyKey, String disputeId, String documentId, String filePath) throws IOException, Exception {

        byte[] fileArray;
        Path path = Paths.get(filePath);
        fileArray = Files.readAllBytes(path);

        createDisputePage(idempotencyKey, disputeId, documentId, fileArray);
    }

    @Override
    public List<DocumentPageConsult> createDisputeDocumentConsult(String documentId) throws Exception {
        return this.getList(DocumentPageConsult[].class, DocumentPageConsult.class, "disputes_document_create_consult", null, documentId);
    }
}
