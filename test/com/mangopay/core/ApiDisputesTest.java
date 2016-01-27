package com.mangopay.core;
import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import java.net.URL;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 * ApiDisputes test methods.
 */
public class ApiDisputesTest extends BaseTest {
    
    /* IMPORTANT NOTE!
    * 
    * Due to the fact the disputes CANNOT be created on user's side,
    * a special approach in testing is needed. 
    * In order to get the tests below pass, a bunch of disputes has
    * to be prepared on the API's side - if it is not, you can
    * just skip these tests, as they won't pass.
    * 
    */
    
    private List<Dispute> _clientDisputes = null;
    
    @Before
    public void initialize() throws Exception {
        
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);

        _clientDisputes = _api.Disputes.getAll(new Pagination(1, 100), null, sort);

        assertTrue("INITIALIZATION FAILURE - cannot test disputes", _clientDisputes != null && !_clientDisputes.isEmpty());
        
    }
    
    @Test
    public void test_GetDispute() throws Exception {
        
        Dispute dispute = _api.Disputes.get(_clientDisputes.get(0).Id);

        assertNotNull(dispute);
        assertEquals(dispute.Id, _clientDisputes.get(0).Id);
        
    }
    
    @Test
    public void test_GetTransactions() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.DisputeType == DisputeType.NOT_CONTESTABLE) {
                dispute = d;
                break;
            }
        }
        
        assertNotNull("Cannot test getting dispute's transactions because there's no not contestable dispute in the disputes list.", dispute);
        
        List<Transaction> result = _api.Disputes.getTransactions(dispute.Id, new Pagination(1, 10), null, null);

        assertNotNull(result);
        assertFalse(result.isEmpty());  
    }

    @Test
    public void test_GetDisputesForWallet() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.InitialTransactionId != null) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test getting disputes for wallet because there's no disputes with transaction ID in the disputes list.", dispute);

        String walletId = _api.PayIns.get(dispute.InitialTransactionId).CreditedWalletId;
        List<Dispute> result = _api.Disputes.getDisputesForWallet(walletId, new Pagination(1, 10), null, null);

        assertNotNull(result);
    }

    @Test
    public void test_GetDisputesForUser() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.DisputeType == DisputeType.NOT_CONTESTABLE) {
                dispute = d;
                break;
            }
        }
        
        assertNotNull("Cannot test getting disputes for user because there's no not contestable dispute in the disputes list.", dispute);
        
        List<Transaction> transactions = _api.Disputes.getTransactions(dispute.Id, new Pagination(1, 1), null, null);
        String userId = transactions.get(0).AuthorId;
        List<Dispute> result = _api.Disputes.getDisputesForUser(userId, new Pagination(1, 20), null, null);
            
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test
    public void test_CreateDisputeDocument() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.PENDING_CLIENT_ACTION || d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test creating dispute document because there's no dispute with expected status in the disputes list.", dispute);

        DisputeDocument result = null;

        DisputeDocument documentPost = new DisputeDocument();
        documentPost.Type = DisputeDocumentType.DELIVERY_PROOF;

        result = _api.Disputes.createDisputeDocument(documentPost, dispute.Id);

        assertNotNull(result);
        assertEquals(result.Type, DisputeDocumentType.DELIVERY_PROOF);
    }

    @Test
    public void test_CreateDisputePage() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.PENDING_CLIENT_ACTION || d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }
        
        assertNotNull("Cannot test creating dispute document page because there's no dispute with expected status in the disputes list.", dispute);

        DisputeDocument result = null;
    
        DisputeDocument documentPost = new DisputeDocument();
        documentPost.Type = DisputeDocumentType.DELIVERY_PROOF;
        result = _api.Disputes.createDisputeDocument(documentPost, dispute.Id);

        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        String filePath = url.toString() + "/com/mangopay/core/TestKycPageFile.png";
        filePath = filePath.replace("file:/", "").replace("//", "/").replace("/", "\\");
        
        _api.Disputes.createDisputePage(dispute.Id, result.Id, filePath);

        assertNotNull(result);
        assertEquals(result.Type, DisputeDocumentType.DELIVERY_PROOF);
    }

    @Test
    public void test_ContestDispute() throws Exception
    {
        Dispute notContestedDispute = null;
                
        for (Dispute d : _clientDisputes) {
            if ((d.Status == DisputeStatus.PENDING_CLIENT_ACTION || d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION)
                    && (d.DisputeType == DisputeType.CONTESTABLE || d.DisputeType == DisputeType.RETRIEVAL)) {
                notContestedDispute = d;
                break;
            }
        }

        assertNotNull("Cannot test contesting dispute because there's no disputes that can be contested in the disputes list.", notContestedDispute);

        Dispute result = null;

        Money contestedFunds = null;
        if (notContestedDispute.Status == DisputeStatus.PENDING_CLIENT_ACTION) {
            contestedFunds = new Money();
            contestedFunds.Amount = 100;
            contestedFunds.Currency = CurrencyIso.EUR;
        }

        result = _api.Disputes.contestDispute(contestedFunds, notContestedDispute.Id);

        assertNotNull(result);
        assertEquals(result.Id, notContestedDispute.Id);
    }

    @Test
    public void test_SaveTag() throws Exception
    {
        Dispute result = null;
        
        Calendar c = Calendar.getInstance();
        String newTag = "New tag: " + Long.toString(c.getTimeInMillis() / 1000);

        result = _api.Disputes.updateTag(newTag, _clientDisputes.get(0).Id);
        
        assertNotNull(result);
        assertEquals(result.Tag, newTag);
    }

    @Test
    public void test_CloseDispute() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.PENDING_CLIENT_ACTION || d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }
        
        assertNotNull("Cannot test closing dispute because there's no available disputes with expected status in the disputes list.", dispute);

        Dispute result = null;

        result = _api.Disputes.closeDispute(dispute.Id);

        assertNotNull(result);
    }

    @Test
    public void test_GetDocument() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.PENDING_CLIENT_ACTION || d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }
        
        assertNotNull("Cannot test getting dispute's document because there's no dispute with expected status in the disputes list.", dispute);

        DisputeDocument document = null;
        DisputeDocument result = null;

        DisputeDocument documentPost = new DisputeDocument();
        documentPost.Type = DisputeDocumentType.OTHER;
        document = _api.Disputes.createDisputeDocument(documentPost, dispute.Id);

        result = _api.Disputes.getDocument(document.Id);

        assertNotNull(result);
        assertEquals(result.CreationDate, document.CreationDate);
        assertEquals(result.Id, document.Id);
        assertEquals(result.RefusedReasonMessage, document.RefusedReasonMessage);
        assertEquals(result.RefusedReasonType, document.RefusedReasonType);
        assertEquals(result.Status, document.Status);
        assertEquals(result.Tag, document.Tag);
        assertEquals(result.Type, document.Type);
        assertEquals(result.DisputeId, document.DisputeId);
    }

    @Test
    public void test_GetDocumentsForDispute() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.SUBMITTED) {
                dispute = d;
                break;
            }
        }
        
        if (dispute == null) {
            test_ContestDispute();
            initialize();
            
            for (Dispute d : _clientDisputes) {
                if (d.Status == DisputeStatus.SUBMITTED) {
                    dispute = d;
                    break;
                }
            }
            
            assertNotNull("Cannot test getting dispute's documents because there's no available disputes with SUBMITTED status in the disputes list.", dispute);
        }

        List<DisputeDocument> result = null;

        result = _api.Disputes.getDocumentsForDispute(dispute.Id, new Pagination(1, 1), null, null);
        
        assertNotNull(result);
    }

    @Test
    public void test_GetDocumentsForClient() throws Exception
    {
        List<DisputeDocument> result = null;

        result = _api.Disputes.getDocumentsForClient(new Pagination(1, 1), null, null);

        assertNotNull(result);
    }

    @Test
    public void test_SubmitDisputeDocument() throws Exception
    {
        Dispute dispute = null;
        DisputeDocument disputeDocument = null;
        
        FilterDisputeDocuments filter = new FilterDisputeDocuments();
        filter.Status = DisputeDocumentStatus.CREATED;
        
        // search for disputes having any documents created...
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.PENDING_CLIENT_ACTION || d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                
                List<DisputeDocument> dd = this._api.Disputes.getDocumentsForDispute(d.Id, new Pagination(1, 1), filter, null);
                
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
            for (Dispute d : _clientDisputes) {
                if (d.Status == DisputeStatus.PENDING_CLIENT_ACTION || d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                    dispute = d;
                    DisputeDocument documentPost = new DisputeDocument();
                    documentPost.Type = DisputeDocumentType.DELIVERY_PROOF;
                    disputeDocument = this._api.Disputes.createDisputeDocument(documentPost, dispute.Id);
                    break;
                }
            }
        }
        
        assertNotNull("Cannot test submitting dispute's documents because there's no dispute with expected status in the disputes list.", dispute);

        assertNotNull("Cannot test submitting dispute's documents because there's no dispute document that can be updated.", disputeDocument);
        
        DisputeDocument result = null;

        DisputeDocument disputeDocumentPut = new DisputeDocument();
        disputeDocumentPut.Id = disputeDocument.Id;
        disputeDocumentPut.Status = DisputeDocumentStatus.VALIDATION_ASKED;

        result = _api.Disputes.submitDisputeDocument(disputeDocumentPut, dispute.Id);

        assertNotNull(result);
        assertTrue(disputeDocument.Type == result.Type);
        assertTrue(result.Status == DisputeDocumentStatus.VALIDATION_ASKED);
    }

    @Test
    public void test_GetRepudiation() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.DisputeType == DisputeType.NOT_CONTESTABLE && d.InitialTransactionId != null) {
                dispute = d;
                break;
            }
        }
        
        Repudiation result = null;

        assertNotNull("Cannot test getting repudiation because there's no not contestable dispute in the disputes list.", dispute);

        String repudiationId = _api.Disputes.getTransactions(dispute.Id, new Pagination(1, 1), null, null).get(0).Id;

        result = _api.Disputes.getRepudiation(repudiationId);

        assertNotNull(result);
    }

    @Test
    public void test_CreateSettlementTransfer() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.CLOSED && d.DisputeType == DisputeType.NOT_CONTESTABLE) {
                dispute = d;
                break;
            }
        }

        assertNotNull("Cannot test creating settlement transfer because there's no closed and not contestable disputes in the disputes list.", dispute);

        String repudiationId = _api.Disputes.getTransactions(dispute.Id, new Pagination(1, 1), null, null).get(0).Id;

        Repudiation repudiation = null;
        
        repudiation = _api.Disputes.getRepudiation(repudiationId);

        Money debitedFunds = new Money();
        Money fees = new Money();
        debitedFunds.Currency = CurrencyIso.EUR;
        debitedFunds.Amount = 1;
        fees.Currency = CurrencyIso.EUR;
        fees.Amount = 0;
        
        SettlementTransfer post = new SettlementTransfer();
        post.AuthorId = repudiation.AuthorId;
        post.DebitedFunds = debitedFunds;
        post.Fees = fees;

        Transfer result = null;
        result = _api.Disputes.createSettlementTransfer(post, repudiationId);

        assertNotNull(result);
    }

    @Test
    public void test_GetFilteredDisputes() throws Exception
    {
        List<Dispute> result1 = null;
        List<Dispute> result2 = null;

        Calendar c = Calendar.getInstance();
        long now = c.getTime().getTime() / 1000;
        FilterDisputes filterAfter = new FilterDisputes();
        FilterDisputes filterBefore = new FilterDisputes();
        filterAfter.AfterDate = now;
        filterBefore.BeforeDate = now;
        result1 = _api.Disputes.getAll(new Pagination(1, 100), filterAfter, null);
        result2 = _api.Disputes.getAll(new Pagination(1, 100), filterBefore, null);
        
        assertNotNull(result1);
        assertNotNull(result2);
        assertTrue(result1.isEmpty());
        assertFalse(result2.isEmpty());
    }

    @Test
    public void test_GetFilteredDisputeDocuments() throws Exception
    {
        List<DisputeDocument> result1 = null;
        List<DisputeDocument> result2 = null;
        List<DisputeDocument> result3 = null;

        Calendar c = Calendar.getInstance();
        long now = c.getTime().getTime() / 1000;
        FilterDisputeDocuments filterAfter = new FilterDisputeDocuments();
        FilterDisputeDocuments filterBefore = new FilterDisputeDocuments();
        filterAfter.AfterDate = now + 10000;
        filterBefore.BeforeDate = now;
        
        result1 = _api.Disputes.getDocumentsForClient(new Pagination(1, 100), filterAfter, null);
        result2 = _api.Disputes.getDocumentsForClient(new Pagination(1, 100), filterBefore, null);

        assertNotNull(result1);
        assertNotNull(result2);
        assertTrue(result1.isEmpty());
        assertFalse(result2.isEmpty());

        FilterDisputeDocuments filterType = new FilterDisputeDocuments();
        filterType.Type = result2.get(0).Type;
        result3 = _api.Disputes.getDocumentsForClient(new Pagination(1, 100), filterType, null);

        assertNotNull(result3);
        assertFalse(result3.isEmpty());
        for (DisputeDocument dd : result3)
        {
                assertTrue(dd.Type == result2.get(0).Type);
        }
    }

    @Test
    public void test_ResubmitDispute() throws Exception
    {
        Dispute dispute = null;
        
        for (Dispute d : _clientDisputes) {
            if (d.Status == DisputeStatus.REOPENED_PENDING_CLIENT_ACTION) {
                dispute = d;
                break;
            }
        }
        
        Dispute result = null;

        assertNotNull("Cannot test resubmitting dispute because there's no re-opened disputes in the disputes list.", dispute);

        result = _api.Disputes.resubmitDispute(dispute.Id);

        assertNotNull(result);
        assertTrue(result.Status == DisputeStatus.SUBMITTED);
    }
    
}
