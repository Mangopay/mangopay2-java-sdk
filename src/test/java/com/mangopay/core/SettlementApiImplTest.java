package com.mangopay.core;

import com.mangopay.entities.SettlementTransfer;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

public class SettlementApiImplTest extends BaseTest {


    @Test
    public void getSettlements() throws Exception {
        List<SettlementTransfer> settlementTransfers = this.api.getSettlementApi().getAll();

        assertNotNull("Settlement api return null list", settlementTransfers);
        assertFalse("Settlement Api returns empty list", settlementTransfers.isEmpty());
    }
}
