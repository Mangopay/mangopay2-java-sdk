package com.mangopay.core;

import com.mangopay.core.enumerations.CurrencyIso;
import com.mangopay.core.enumerations.DisputeStatus;
import com.mangopay.core.enumerations.DisputeType;
import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.entities.Dispute;
import com.mangopay.entities.Repudiation;
import com.mangopay.entities.SettlementTransfer;
import com.mangopay.entities.Transfer;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SettlementApiImplTest extends BaseTest {
    private String settlementId = null;
    private List<Dispute> clientDisputes;

    @Before
    public void initialize() throws Exception {

        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);

        clientDisputes = api.getDisputeApi().getAll(new Pagination(1, 100), null, sort);
        assertTrue("INITIALIZATION FAILURE - cannot test disputes", clientDisputes != null && !clientDisputes.isEmpty());

        if (settlementId == null || settlementId.isEmpty()) {
            Dispute dispute = null;
            for (Dispute d : clientDisputes) {
                if (d.getStatus() == DisputeStatus.CLOSED && d.getDisputeType() == DisputeType.NOT_CONTESTABLE) {
                    dispute = d;
                    break;
                }
            }

            assertNotNull("Cannot initialize settlement api test class because " +
                    "there's no closed and not contestable disputes in the disputes list.", dispute);

            String repudiationId = api.getDisputeApi().getTransactions(
                    dispute.getId(), new Pagination(1, 1), null, null).get(0).getId();
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
            post.setTag("abc");

            Transfer result = null;
            result = api.getDisputeApi().createSettlementTransfer(post, repudiationId);
            assertNotNull("Can't retrieve id from settlement transfer because it is null", result);
            settlementId = result.getId();
        }

    }


    @Test
    public void getSettlement() throws Exception {
        SettlementTransfer settlementTransfers = this.api.getSettlementApi().get(settlementId);
        assertNotNull("Settlement api return null settlement transfer", settlementTransfers);
        assertNotNull(settlementTransfers.getTag());
        assertEquals("abc",settlementTransfers.getTag());
    }
}
