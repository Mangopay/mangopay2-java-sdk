package com.mangopay.core;

import com.mangopay.entities.Settlement;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class SettlementApiImplTest extends BaseTest {
    private static Settlement settlement;

    /*
        In case the status returned on GET is something related to a failure, try creating a new
        intent authorization and update the IntentId in the CSV file below
     */
    @Before
    public void initialize() throws Exception {
        URL url = getClass().getResource("/com/mangopay/core/settlement_sample.csv");
        File file = new File(url.toURI());
        settlement = api.getSettlementApi().upload(file, null);
    }

    @Test
    public void test_UploadSettlement() {
        assertEquals("UPLOADED", settlement.getStatus());
        assertEquals("1000", settlement.getActualSettlementAmount().toString());
        assertEquals("0", settlement.getExternalProcessorFeesAmount().toString());
    }

    @Test
    public void test_GetSettlement() throws Exception {
        // wait 10 seconds for the API to process the file
        Thread.sleep(10000);
        Settlement fetched = api.getSettlementApi().getSettlement(settlement.getSettlementId());
        assertNotNull(fetched);
        assertEquals(settlement.getSettlementId(), fetched.getSettlementId());
        assertEquals("PARTIALLY_SETTLED", fetched.getStatus());
        assertEquals("1000", fetched.getActualSettlementAmount().toString());
        assertEquals("0", fetched.getExternalProcessorFeesAmount().toString());
    }

    @Test
    public void test_UpdateSettlement() throws Exception {
        URL url = getClass().getResource("/com/mangopay/core/settlement_sample.csv");
        File file = new File(url.toURI());

        Settlement updated = api.getSettlementApi().update(settlement.getSettlementId(), file);
        assertEquals("UPLOADED", updated.getStatus());
        Thread.sleep(10000);

        Settlement fetched = api.getSettlementApi().getSettlement(settlement.getSettlementId());
        assertEquals("PARTIALLY_SETTLED", fetched.getStatus());
    }
}
