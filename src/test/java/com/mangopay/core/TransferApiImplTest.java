package com.mangopay.core;

import com.mangopay.core.enumerations.TransactionNature;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.Refund;
import com.mangopay.entities.Transfer;
import com.mangopay.entities.UserNatural;
import com.mangopay.entities.Wallet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * TransferApiImpl test methods
 */
public class TransferApiImplTest extends BaseTest {

    @Test
    public void createTransfer() throws Exception {
        UserNatural john = this.getJohn();

        Transfer transfer = this.getNewTransfer();
        Wallet creditedWallet = this.api.getWalletApi().get(transfer.getCreditedWalletId());

        assertTrue(transfer.getId().length() > 0);
        assertEquals(transfer.getAuthorId(), john.getId());
        assertEquals(transfer.getCreditedUserId(), john.getId());
        assertTrue(creditedWallet.getBalance().getAmount() == 1);
    }

    @Test
    public void getTransfer() throws Exception {
        UserNatural john = this.getJohn();
        Transfer transfer = this.getNewTransfer();

        Transfer getTransfer = this.api.getTransferApi().get(transfer.getId());

        assertEquals(transfer.getId(), getTransfer.getId());
        assertEquals(getTransfer.getAuthorId(), john.getId());
        assertEquals(getTransfer.getCreditedUserId(), john.getId());
        assertEqualInputProps(transfer, getTransfer);
    }

    @Test
    public void createTransferRefund() throws Exception {
        Transfer transfer = this.getNewTransfer();
        Wallet wallet = this.getJohnsWalletWithMoney();
        Wallet walletBefore = this.api.getWalletApi().get(wallet.getId());


        Refund refund = this.getNewRefundForTransfer(transfer);
        Wallet walletAfter = this.api.getWalletApi().get(wallet.getId());

        assertTrue(refund.getId().length() > 0);
        assertTrue(refund.getDebitedFunds().getAmount() == transfer.getDebitedFunds().getAmount());
        assertTrue(walletBefore.getBalance().getAmount() == (walletAfter.getBalance().getAmount() - transfer.getDebitedFunds().getAmount()));
        assertTrue(refund.getType() == TransactionType.TRANSFER);
        assertTrue(refund.getNature() == TransactionNature.REFUND);
    }

    @Test
    public void getTransferRefunds() throws Exception {
        Transfer transfer = this.getNewTransfer();
        Refund firstRefund = this.getNewRefundForTransfer(transfer);
        Pagination pagination = new Pagination(1, 2);
        List<Refund> refunds = this.getApi().getTransferApi().getRefunds(transfer.getId(), pagination, null);

        assertNotNull("Refunds came back null", refunds);
        assertTrue("Refunds size is not correct", refunds.size() == 1);


    }
}
