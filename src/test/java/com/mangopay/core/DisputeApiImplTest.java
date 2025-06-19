package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;


/* IMPORTANT NOTE!
 *
 * Due to the fact the disputes CANNOT be created on user's side,
 * a special approach in testing is needed.
 * In order to get the tests below pass, a bunch of disputes has
 * to be prepared on the API's side - if it's not, the tests won't pass.
 *
 * Comment out the @Ignore attribute of DisputeApiImplTest class to include
 * disputes unit tests into the testing queue.
 *
 */


/**
 * DisputeApiImpl test methods.
 */

public class DisputeApiImplTest extends BaseTest {

    private List<Dispute> clientDisputes = null;

    @Before
    public void initialize() throws Exception {

        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);

        clientDisputes = api.getDisputeApi().getAll(new Pagination(1, 100), null, sort);

        assertTrue("INITIALIZATION FAILURE - cannot test disputes", clientDisputes != null && !clientDisputes.isEmpty());

    }

    @Test
    public void getDispute() throws Exception {

        Dispute dispute = api.getDisputeApi().get(clientDisputes.get(0).getId());

        assertNotNull(dispute);
        assertEquals(dispute.getId(), clientDisputes.get(0).getId());

    }

    @Test
    public void getTransactions() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getDisputeType() == DisputeType.NOT_CONTESTABLE) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test getting dispute's transactions because there's no not contestable dispute in the disputes list.", dispute);

        List<Transaction> result = api.getDisputeApi().getTransactions(dispute.getId(), new Pagination(1, 10), null, null);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        for (Transaction t : result) {
            assertNotNull(t.getStatus());
            assertNotEquals(TransactionStatus.NotSpecified, t.getStatus());
        }
    }

    @Test
    public void getDisputesForWallet() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getInitialTransactionId() != null) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test getting disputes for wallet because there's no disputes with transaction ID in the disputes list.", dispute);

        String walletId = api.getPayInApi().get(dispute.getInitialTransactionId()).getCreditedWalletId();
        List<Dispute> result = api.getDisputeApi().getDisputesForWallet(walletId, new Pagination(1, 10), null, null);

        assertNotNull(result);
    }

    @Test
    public void getDisputesForUser() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getDisputeType() == DisputeType.NOT_CONTESTABLE) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test getting disputes for user because there's no not contestable dispute in the disputes list.", dispute);

        List<Transaction> transactions = api.getDisputeApi().getTransactions(dispute.getId(), new Pagination(1, 1), null, null);
        String userId = transactions.get(0).getAuthorId();
        List<Dispute> result = api.getDisputeApi().getDisputesForUser(userId, new Pagination(1, 20), null, null);

        assertNotNull(result);
        assertFalse(result.isEmpty());

        assertFalse(transactions.isEmpty());
        for (Transaction t : transactions) {
            assertNotNull(t.getStatus());
            assertNotEquals(TransactionStatus.NotSpecified, t.getStatus());
        }
    }

    @Test
    public void createDisputeDocument() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test creating dispute document because there's no dispute with expected status in the disputes list.", dispute);

        DisputeDocument result = null;

        DisputeDocument documentPost = new DisputeDocument();
        documentPost.setType(DisputeDocumentType.DELIVERY_PROOF);

        result = api.getDisputeApi().createDisputeDocument(documentPost, dispute.getId());

        assertNotNull(result);
        assertEquals(result.getType(), DisputeDocumentType.DELIVERY_PROOF);
    }

    @Test
    public void createDisputePage() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test creating dispute document page because there's no dispute with expected status in the disputes list.", dispute);

        DisputeDocument result = null;

        DisputeDocument documentPost = new DisputeDocument();
        documentPost.setType(DisputeDocumentType.DELIVERY_PROOF);
        result = api.getDisputeApi().createDisputeDocument(documentPost, dispute.getId());

        URL url = getClass().getResource("/com/mangopay/core/TestKycPageFile.png");
        String filePath = new File(url.toURI()).getAbsolutePath();

        api.getDisputeApi().createDisputePage(dispute.getId(), result.getId(), filePath);

        assertNotNull(result);
        assertEquals(result.getType(), DisputeDocumentType.DELIVERY_PROOF);
    }

    @Test
    @Ignore("Cannot be tested. Needs manual creation of dispute on API side")
    public void contestDispute() throws Exception {
        Dispute notContestedDispute = null;

        for (Dispute d : clientDisputes) {
            if ((d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION)
                    && (d.getDisputeType() == DisputeType.CONTESTABLE || d.getDisputeType() == DisputeType.RETRIEVAL)) {
                notContestedDispute = d;
                break;
            }
        }

        assertNotNull("Cannot test contesting dispute because there's no disputes that can be contested in the disputes list.", notContestedDispute);

        Dispute result = null;

        Money contestedFunds = null;
        if (notContestedDispute.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION) {
            contestedFunds = new Money();
            contestedFunds.setAmount(100);
            contestedFunds.setCurrency(CurrencyIso.EUR);
        }

        result = api.getDisputeApi().contestDispute(contestedFunds, notContestedDispute.getId());

        assertNotNull(result);
        assertEquals(result.getId(), notContestedDispute.getId());
    }

    @Test
    public void saveTag() throws Exception {
        Dispute result = null;

        Calendar c = Calendar.getInstance();
        String newTag = "New tag: " + Long.toString(c.getTimeInMillis() / 1000);

        result = api.getDisputeApi().updateTag(newTag, clientDisputes.get(0).getId());

        assertNotNull(result);
        assertEquals(result.getTag(), newTag);
    }

    @Test
    @Ignore("Cannot be tested. Needs manual creation of dispute on API side")
    public void closeDispute() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test closing dispute because there's no available disputes with expected status in the disputes list.", dispute);

        Dispute result = null;

        result = api.getDisputeApi().closeDispute(dispute.getId());

        assertNotNull(result);
    }

    @Test
    public void getDocument() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test getting dispute's document because there's no dispute with expected status in the disputes list.", dispute);

        DisputeDocument document = null;
        DisputeDocument result = null;

        DisputeDocument documentPost = new DisputeDocument();
        documentPost.setType(DisputeDocumentType.OTHER);
        document = api.getDisputeApi().createDisputeDocument(documentPost, dispute.getId());

        result = api.getDisputeApi().getDocument(document.getId());

        assertNotNull(result);
        assertEquals(result.getCreationDate(), document.getCreationDate());
        assertEquals(result.getId(), document.getId());
        assertEquals(result.getRefusedReasonMessage(), document.getRefusedReasonMessage());
        assertEquals(result.getRefusedReasonType(), document.getRefusedReasonType());
        assertEquals(result.getStatus(), document.getStatus());
        assertEquals(result.getTag(), document.getTag());
        assertEquals(result.getType(), document.getType());
        assertEquals(result.getDisputeId(), document.getDisputeId());
    }

    @Test
    public void createDisputeDocumentConsult() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test creating dispute's document consult because there's no dispute with expected status in the disputes list.", dispute);

        DisputeDocument document = null;
        DisputeDocument documentPost = new DisputeDocument();
        documentPost.setType(DisputeDocumentType.OTHER);
        document = api.getDisputeApi().createDisputeDocument(documentPost, dispute.getId());

        List<DocumentPageConsult> consults = api.getDisputeApi().createDisputeDocumentConsult(document.getId());

        assertNotNull(consults);
    }

    @Test
    public void getDocumentsForDispute() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.SUBMITTED) {
                dispute = d;
                break;
            }
        }

        if (dispute == null) {
            contestDispute();
            initialize();

            for (Dispute d : clientDisputes) {
                if (d.getStatus() == DisputeStatus.SUBMITTED) {
                    dispute = d;
                    break;
                }
            }

            assertNotNull("Cannot test getting dispute's documents because there's no available disputes with SUBMITTED status in the disputes list.", dispute);
        }

        List<DisputeDocument> result = null;

        result = api.getDisputeApi().getDocumentsForDispute(dispute.getId(), new Pagination(1, 1), null, null);

        assertNotNull(result);
    }

    @Test
    public void getDocumentsForClient() throws Exception {
        List<DisputeDocument> result = null;

        result = api.getDisputeApi().getDocumentsForClient(new Pagination(1, 1), null, null);

        assertNotNull(result);
    }

    @Test
    @Ignore("Cannot be tested. Needs manual creation of dispute on API side")
    public void submitDisputeDocument() throws Exception {
        Dispute dispute = null;
        DisputeDocument disputeDocument = null;

        FilterDisputeDocuments filter = new FilterDisputeDocuments();
        filter.setStatus(DisputeDocumentStatus.CREATED);

        // search for disputes having any documents created...
        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {

                List<DisputeDocument> dd = this.api.getDisputeApi().getDocumentsForDispute(d.getId(), new Pagination(1, 1), filter, null);

                if (dd != null && dd.size() > 0) {
                    // ...found such
                    dispute = d;
                    disputeDocument = dd.get(0);
                    break;
                }
            }
        }

        if (dispute == null) {
            // try to create a dispute document
            for (Dispute d : clientDisputes) {
                if (d.getStatus() == DisputeStatus.PENDING_CLIENT_ACTION || d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                    dispute = d;
                    DisputeDocument documentPost = new DisputeDocument();
                    documentPost.setType(DisputeDocumentType.DELIVERY_PROOF);
                    disputeDocument = this.api.getDisputeApi().createDisputeDocument(documentPost, dispute.getId());
                    break;
                }
            }
        }

        assertNotNull("Cannot test submitting dispute's documents because there's no dispute with expected status in the disputes list.", dispute);

        assertNotNull("Cannot test submitting dispute's documents because there's no dispute document that can be updated.", disputeDocument);

        URL url = getClass().getResource("/com/mangopay/core/TestKycPageFile.png");
        String filePath = new File(url.toURI()).getAbsolutePath();
        api.getDisputeApi().createDisputePage(dispute.getId(), disputeDocument.getId(), filePath);

        DisputeDocument result = null;

        DisputeDocument disputeDocumentPut = new DisputeDocument();
        disputeDocumentPut.setId(disputeDocument.getId());
        disputeDocumentPut.setStatus(DisputeDocumentStatus.VALIDATION_ASKED);

        result = api.getDisputeApi().submitDisputeDocument(disputeDocumentPut, dispute.getId());

        assertNotNull(result);
        assertTrue(disputeDocument.getType() == result.getType());
        assertTrue(result.getStatus() == DisputeDocumentStatus.VALIDATION_ASKED);
    }

    @Test
    public void getRepudiation() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getDisputeType() == DisputeType.NOT_CONTESTABLE && d.getInitialTransactionId() != null) {
                dispute = d;
                break;
            }
        }

        Repudiation result = null;

        assertNotNull("Cannot test getting repudiation because there's no not contestable dispute in the disputes list.", dispute);

        String repudiationId = api.getDisputeApi().getTransactions(dispute.getId(), new Pagination(1, 1), null, null).get(0).getId();

        result = api.getRepudiationApi().getRepudiation(repudiationId);

        assertNotNull(result);
    }

    @Test
    public void createSettlementTransfer() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.CLOSED && d.getDisputeType() == DisputeType.NOT_CONTESTABLE) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test creating settlement transfer because there's no closed and not contestable disputes in the disputes list.", dispute);

        String repudiationId = api.getDisputeApi().getTransactions(dispute.getId(), new Pagination(1, 1), null, null).get(0).getId();

        Repudiation repudiation = null;

        repudiation = api.getRepudiationApi().getRepudiation(repudiationId);

        Money debitedFunds = new Money();
        Money fees = new Money();
        debitedFunds.setCurrency(CurrencyIso.EUR);
        debitedFunds.setAmount(1);
        fees.setCurrency(CurrencyIso.EUR);
        fees.setAmount(0);

        SettlementTransfer post = new SettlementTransfer();
        post.setAuthorId(repudiation.getAuthorId());
        post.setDebitedFunds(debitedFunds);
        post.setFees(fees);

        Transfer result = null;
        result = api.getDisputeApi().createSettlementTransfer(post, repudiationId);

        assertNotNull(result);
    }

    @Test
    public void getDisputesWithPendingSettlement() throws Exception {
        Pagination pagination = new Pagination(0, 1);
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);
        List<Dispute> disputesWithPendingSettlement = this.api.getDisputeApi().getDisputesWithPendingSettlement(pagination, sort);
        assertNotNull(disputesWithPendingSettlement);
        assertFalse(disputesWithPendingSettlement.isEmpty());
        assertTrue(disputesWithPendingSettlement.size() == 1);
    }

    @Test
    public void getFilteredDisputes() throws Exception {
        List<Dispute> result1 = null;
        List<Dispute> result2 = null;

        Calendar c = Calendar.getInstance();
        long now = c.getTime().getTime() / 1000;
        FilterDisputes filterAfter = new FilterDisputes();
        FilterDisputes filterBefore = new FilterDisputes();
        filterAfter.setAfterDate(now);
        filterBefore.setBeforeDate(now);
        result1 = api.getDisputeApi().getAll(new Pagination(1, 100), filterAfter, null);
        result2 = api.getDisputeApi().getAll(new Pagination(1, 100), filterBefore, null);

        assertNotNull(result1);
        assertNotNull(result2);
        assertTrue(result1.isEmpty());
        assertFalse(result2.isEmpty());
    }

    @Test
    public void getFilteredDisputeDocuments() throws Exception {
        List<DisputeDocument> result1 = null;
        List<DisputeDocument> result2 = null;
        List<DisputeDocument> result3 = null;

        Calendar c = Calendar.getInstance();
        long now = c.getTime().getTime() / 1000;
        FilterDisputeDocuments filterAfter = new FilterDisputeDocuments();
        FilterDisputeDocuments filterBefore = new FilterDisputeDocuments();
        filterAfter.setAfterDate(now + 10000);
        filterBefore.setBeforeDate(now);

        result1 = api.getDisputeApi().getDocumentsForClient(new Pagination(1, 100), filterAfter, null);
        result2 = api.getDisputeApi().getDocumentsForClient(new Pagination(1, 100), filterBefore, null);

        assertNotNull(result1);
        assertNotNull(result2);
        assertTrue(result1.isEmpty());
        assertFalse(result2.isEmpty());

        FilterDisputeDocuments filterType = new FilterDisputeDocuments();
        filterType.setType(result2.get(0).getType());
        result3 = api.getDisputeApi().getDocumentsForClient(new Pagination(1, 100), filterType, null);

        assertNotNull(result3);
        assertFalse(result3.isEmpty());
        for (DisputeDocument dd : result3) {
            assertTrue(dd.getType() == result2.get(0).getType());
        }
    }

    @Test
    @Ignore("Cannot be tested. Needs manual creation of dispute on API side")
    public void resubmitDispute() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getStatus() == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }

        Dispute result = null;

        assertNotNull("Cannot test resubmitting dispute because there's no re-opened disputes in the disputes list.", dispute);

        result = api.getDisputeApi().resubmitDispute(dispute.getId());

        assertNotNull(result);
        assertTrue(result.getStatus() == DisputeStatus.SUBMITTED);
    }

    @Test
    public void getDisputesForPayIn() throws Exception {
        Dispute dispute = null;

        for (Dispute d : clientDisputes) {
            if (d.getDisputeType() == DisputeType.NOT_CONTESTABLE) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test getting disputes for user because there's no not contestable dispute in the disputes list.", dispute);

        PayIn payin = api.getPayInApi().get(dispute.getInitialTransactionId());
        List<Dispute> result = api.getDisputeApi().getDisputesForPayIn(payin.getId(), new Pagination(1, 10), null, null);

        assertNotNull(result);
        assertFalse(result.isEmpty());
    }
}
