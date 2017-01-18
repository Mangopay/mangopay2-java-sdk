package com.mangopay.core;

import com.mangopay.core.enumerations.TransactionNature;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.Refund;
import com.mangopay.entities.Transfer;
import com.mangopay.entities.UserNatural;
import com.mangopay.entities.Wallet;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * ApiTransfersImpl test methods
 */
public class ApiTransfersImplTest extends BaseTest {

    @Test
    public void createTransfer() throws Exception {
        UserNatural john = this.getJohn();

        Transfer transfer = this.getNewTransfer();
        Wallet creditedWallet = this.api.getWallets().get(transfer.getCreditedWalletId());

        assertTrue(transfer.getId().length() > 0);
        assertEquals(transfer.getAuthorId(), john.getId());
        assertEquals(transfer.getCreditedUserId(), john.getId());
        assertTrue(creditedWallet.getBalance().getAmount() == 100);
    }

    @Test
    public void getTransfer() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getNewTransfer();

        Transfer getTransfer = this.api.getTransfers().get(transfer.getId());

        assertEquals(transfer.getId(), getTransfer.getId());
        assertEquals(getTransfer.getAuthorId(), john.getId());
        assertEquals(getTransfer.getCreditedUserId(), john.getId());
        assertEqualInputProps(transfer, getTransfer);
    }

    @Test
    public void createTransferRefund() throws Exception {
        Transfer transfer = this.getNewTransfer();
        Wallet wallet = this.getJohnsWalletWithMoney();
        Wallet walletBefore = this.api.getWallets().get(wallet.getId());


        Refund refund = this.getNewRefundForTransfer(transfer);
        Wallet walletAfter = this.api.getWallets().get(wallet.getId());

        assertTrue(refund.getId().length() > 0);
        assertTrue(refund.getDebitedFunds().getAmount() == transfer.getDebitedFunds().getAmount());
        assertTrue(walletBefore.getBalance().getAmount() == (walletAfter.getBalance().getAmount() - transfer.getDebitedFunds().getAmount()));
        assertTrue(refund.getType() == TransactionType.TRANSFER);
        assertTrue(refund.getNature() == TransactionNature.REFUND);
    }

}
