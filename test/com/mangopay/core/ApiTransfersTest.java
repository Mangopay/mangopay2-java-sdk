package com.mangopay.core;

import com.mangopay.entities.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiTransfers test methods
 */
public class ApiTransfersTest extends BaseTest {

    @Test
    public void test_Transfers_Create() throws Exception {
        UserNatural john = this.getJohn();
        
        Transfer transfer = this.getJohnsTransfer();
        Wallet creditedWallet = this._api.Wallets.get(transfer.CreditedWalletId);
        
        assertTrue(transfer.Id.length() > 0);
        assertEquals(transfer.AuthorId, john.Id);
        assertEquals(transfer.CreditedUserId, john.Id);
        assertTrue(creditedWallet.Balance.Amount == 100.0);
    }
    
    @Test
    public void test_Transfers_Get() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getJohnsTransfer();
        
        Transfer getTransfer = this._api.Transfers.get(transfer.Id);
        
        assertEquals(transfer.Id, getTransfer.Id);
        assertEquals(getTransfer.AuthorId, john.Id);
        assertEquals(getTransfer.CreditedUserId, john.Id);
        assertEqualInputProps(transfer, getTransfer);
    }
    
    @Test
    public void test_Transfers_CreateRefund() throws Exception {
        Wallet wallet = this.getJohnsWallet();
        Wallet walletBefore = this._api.Wallets.get(wallet.Id);
        Transfer transfer = this.getJohnsTransfer();
                
        Refund refund = this.getJohnsRefundForTransfer();
        Wallet walletAfter = this._api.Wallets.get(wallet.Id);

        assertTrue(refund.Id.length() > 0);
        assertTrue(refund.DebitedFunds.Amount == transfer.DebitedFunds.Amount);
        assertTrue(walletBefore.Balance.Amount == walletAfter.Balance.Amount - transfer.DebitedFunds.Amount);
        assertEquals("TRANSFER", refund.Type);
        assertEquals("REFUND", refund.Nature);
    }
    
}
