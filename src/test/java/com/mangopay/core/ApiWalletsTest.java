package com.mangopay.core;

import com.mangopay.core.enumerations.SortDirection;
import com.mangopay.core.enumerations.TransactionType;
import com.mangopay.entities.*;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiWallets test methods
 */
public class ApiWalletsTest extends BaseTest {
    
    @Test
    public void createWallet() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();
        
        assertTrue(wallet.Id.length() > 0);
        assertTrue(wallet.Owners.contains(john.Id));
    }
    
    @Test
    public void getWallet() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();
        
        Wallet getWallet = this.api.Wallets.get(wallet.Id);
        
        assertEquals(wallet.Id, getWallet.Id);
        assertTrue(wallet.Owners.contains(john.Id));
    }
    
    @Test
    public void updateWallet() throws Exception {
        Wallet wallet = this.getJohnsWallet();
        wallet.Description = "New description to test";
        
        Wallet saveWallet = this.api.Wallets.update(wallet);
        
        assertEquals(wallet.Id, saveWallet.Id);
        assertEquals("New description to test", saveWallet.Description);
    }
    
    @Test
    public void getWalletTransactions() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();
        PayIn payIn = this.getJohnsPayInCardWeb();

        Pagination pagination = new Pagination(1, 1);
        FilterTransactions filter = new FilterTransactions();
        filter.Type = TransactionType.PAYIN;
        List<Transaction> transactions = this.api.Wallets.getTransactions(wallet.Id, pagination, filter);

        assertTrue(transactions.size() == 1);
        assertTrue(transactions.get(0) instanceof Transaction);
        assertEquals(transactions.get(0).AuthorId, john.Id);
        this.assertEqualInputProps(transactions.get(0), payIn);
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
        filter.Type = TransactionType.PAYIN;
        
        List<Transaction> transactions = this.api.Wallets.getTransactions(wallet.Id, pagination, filter, sorting);
        
        assertNotNull(transactions);
        assertTrue(transactions.size() > 1);
        assertTrue(transactions.get(0).CreationDate > transactions.get(1).CreationDate);
    }
}
