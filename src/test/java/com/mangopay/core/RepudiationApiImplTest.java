package com.mangopay.core;

import com.mangopay.core.enumerations.DisputeType;
import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.entities.Dispute;
import com.mangopay.entities.Refund;
import com.mangopay.entities.Repudiation;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * RepudiationApi test methods
 * Created by cosmin on 17-11-2017.
 */
public class RepudiationApiImplTest extends BaseTest {

    private Repudiation repudiation;
    private Dispute dispute;

    @Before
    public void initialize() throws Exception {
        Sorting sort = new Sorting();
        sort.addField("CreationDate", SortDirection.desc);
        List<Dispute> clientDisputes = api.getDisputeApi().getAll(new Pagination(1, 100), null, sort);
        assertTrue(
                "INITIALIZATION FAILURE - cannot test repudiations because disputes couldn't be initialized",
                clientDisputes != null && !clientDisputes.isEmpty());

        dispute = null;
        for (Dispute d : clientDisputes) {
            if (d.getDisputeType() == DisputeType.NOT_CONTESTABLE && d.getInitialTransactionId() != null) {
                dispute = d;
                break;
            }
        }
        Repudiation result = null;
        assertNotNull("Cannot test getting repudiation because there's no not contestable dispute in the disputes list.", dispute);
        String repudiationId = api.getDisputeApi().getTransactions(dispute.getId(), new Pagination(1, 1), null, null).get(0).getId();
        repudiation = api.getRepudiationApi().getRepudiation(repudiationId);

        assertNotNull("INITIALIZATION FAILURE - cannot fetch repudiation", repudiation);

    }

    @Test
    public void getRefunds() throws Exception {
        List<Refund> refunds = this.api.getRepudiationApi().getRefunds(this.repudiation.getId());

        assertNotNull(refunds);
    }
}
