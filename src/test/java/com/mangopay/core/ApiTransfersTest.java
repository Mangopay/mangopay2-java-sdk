package com.mangopay.core;

import com.mangopay.core.enumerations.*;
import com.mangopay.entities.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiTransfers test methods
 */
public class ApiTransfersTest extends BaseTest {

    @Test
    public void createTransfer() throws Exception {
        UserNatural john = this.getJohn();
        
        Transfer transfer = this.getNewTransfer();
        Wallet creditedWallet = this.api.Wallets.get(transfer.CreditedWalletId);
        
        assertTrue(transfer.Id.length() > 0);
        assertEquals(transfer.AuthorId, john.Id);
        assertEquals(transfer.CreditedUserId, john.Id);
        assertTrue(creditedWallet.Balance.Amount == 100);
    }
    
    @Test
    public void getTransfer() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getNewTransfer();
        
        Transfer getTransfer = this.api.Transfers.get(transfer.Id);
        
        assertEquals(transfer.Id, getTransfer.Id);
        assertEquals(getTransfer.AuthorId, john.Id);
        assertEquals(getTransfer.CreditedUserId, john.Id);
        assertEqualInputProps(transfer, getTransfer);
    }
    
    @Test
    public void createTransferRefund() throws Exception {
        Transfer transfer = this.getNewTransfer();
        Wallet wallet = this.getJohnsWalletWithMoney();
        Wallet walletBefore = this.api.Wallets.get(wallet.Id);
        
                
        Refund refund = this.getNewRefundForTransfer(transfer);
        Wallet walletAfter = this.api.Wallets.get(wallet.Id);

        assertTrue(refund.Id.length() > 0);
        assertTrue(refund.DebitedFunds.Amount == transfer.DebitedFunds.Amount);
        assertTrue(walletBefore.Balance.Amount == (walletAfter.Balance.Amount - transfer.DebitedFunds.Amount));
        assertTrue(refund.Type == TransactionType.TRANSFER);
        assertTrue(refund.Nature == TransactionNature.REFUND);
    }
    
}
