package com.mangopay.core;

import com.mangopay.entities.*;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiWallets test methods
 */
public class ApiWalletsTest extends BaseTest {
    
    @Test
    public void test_Wallets_Create() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();
        
        assertTrue(wallet.Id.length() > 0);
        assertTrue(wallet.Owners.contains(john.Id));
    }
    
    @Test
    public void test_Wallets_Get() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();
        
        Wallet getWallet = this._api.Wallets.get(wallet.Id);
        
        assertEquals(wallet.Id, getWallet.Id);
        assertTrue(wallet.Owners.contains(john.Id));
    }
    
    @Test
    public void test_Wallets_Save() throws Exception {
        Wallet wallet = this.getJohnsWallet();
        wallet.Description = "New description to test";
        
        Wallet saveWallet = this._api.Wallets.update(wallet);
        
        assertEquals(wallet.Id, saveWallet.Id);
        assertEquals("New description to test", saveWallet.Description);
    }
    
    @Test
    public void test_Wallets_Transactions() throws Exception {
        UserNatural john = this.getJohn();
        Wallet wallet = this.getJohnsWallet();
        PayIn payIn = this.getJohnsPayInCardWeb();

        Pagination pagination = new Pagination(1, 1);
        FilterTransactions filter = new FilterTransactions();
        filter.Type = "PAYIN";
        List<Transaction> transactions = this._api.Wallets.getTransactions(wallet.Id, pagination, filter);

        assertTrue(transactions.size() == 1);
        assertTrue(transactions.get(0) instanceof Transaction);
        assertEquals(transactions.get(0).AuthorId, john.Id);
        this.assertEqualInputProps(transactions.get(0), payIn);
    }
}
