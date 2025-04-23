package com.mangopay.core;

import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.core.enumerations.TransactionStatus;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.PayIn;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.UserNatural;
import com.mangopay.entities.Wallet;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * WalletApiImpl test methods
 */
public class WalletApiImplTest extends BaseTest {

    @Test
    public void createWallet() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();

        assertTrue(wallet.getId().length() > 0);
        assertTrue(wallet.getOwners().contains(john.getId()));
    }

    @Test
    public void getWallet() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();

        Wallet getWallet = this.api.getWalletApi().get(wallet.getId());

        assertEquals(wallet.getId(), getWallet.getId());
        assertTrue(wallet.getOwners().contains(john.getId()));
    }

    @Test
    public void getWalletSca() throws Exception {
        Wallet wallet = this.getJohnsWallet();

        try {
            this.api.getWalletApi().get(wallet.getId(), "USER_PRESENT");
        } catch (ResponseException e) {
            assertEquals(401, e.getResponseHttpCode());
            assertTrue(e.getErrors().containsKey("Sca"));
            assertTrue(e.getData().containsKey("RedirectUrl"));
        }
    }

    @Test
    public void updateWallet() throws Exception {
        Wallet wallet = this.getJohnsWallet();
        wallet.setDescription("New description to test");

        Wallet saveWallet = this.api.getWalletApi().update(wallet);

        assertEquals(wallet.getId(), saveWallet.getId());
        assertEquals("New description to test", saveWallet.getDescription());
    }

    @Test
    public void getWalletTransactions() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();
        PayIn payIn = this.getJohnsPayInCardWeb();

        Pagination pagination = new Pagination(1, 1);
        FilterTransactions filter = new FilterTransactions();
        filter.setType(TransactionType.PAYIN);

        // wait 2 seconds for the transactions to be created in the API
        Thread.sleep(2000);

        List<Transaction> transactions = this.api.getWalletApi().getTransactions(wallet.getId(), pagination, filter);

        assertTrue(transactions.size() == 1);
        assertTrue(transactions.get(0) instanceof Transaction);
        assertEquals(transactions.get(0).getAuthorId(), john.getId());
        //this.assertEqualInputProps(transactions.get(0), payIn);

        assertFalse(transactions.isEmpty());
        for (Transaction t : transactions) {
            assertNotNull(t.getStatus());
            assertNotEquals(TransactionStatus.NotSpecified, t.getStatus());
        }
    }

    @Test
    public void getWalletTransactionsAndSortByCreationDate() throws Exception {
        Wallet wallet = this.getJohnsWallet();

        // create two payin objects
        this.getJohnsPayInCardWeb();
        this.holdOn(2);
        this.getNewPayInCardWeb();
        Sorting sorting = new Sorting();
        sorting.addField("CreationDate", SortDirection.desc);
        Pagination pagination = new Pagination(1, 20);
        FilterTransactions filter = new FilterTransactions();
        filter.setType(TransactionType.PAYIN);

        Thread.sleep(2000);
        List<Transaction> transactions = this.api.getWalletApi().getTransactions(wallet.getId(), pagination, filter, sorting);

        assertNotNull(transactions);
        assertTrue(transactions.size() > 1);
        assertTrue(transactions.get(0).getCreationDate() > transactions.get(1).getCreationDate());

        assertFalse(transactions.isEmpty());
        for (Transaction t : transactions) {
            assertNotNull(t.getStatus());
            assertNotEquals(TransactionStatus.NotSpecified, t.getStatus());
        }
    }

    @Test
    public void getWalletTransactionsSca() throws Exception {
        Wallet wallet = this.getJohnsWallet();

        Pagination pagination = new Pagination(1, 20);
        FilterTransactions filter = new FilterTransactions();
        filter.setScaContext("USER_PRESENT");

        try {
            this.api.getWalletApi().getTransactions(wallet.getId(), pagination, filter, null);
        } catch (ResponseException e) {
            assertEquals(401, e.getResponseHttpCode());
            assertTrue(e.getErrors().containsKey("Sca"));
            assertTrue(e.getData().containsKey("RedirectUrl"));
        }
    }
}
