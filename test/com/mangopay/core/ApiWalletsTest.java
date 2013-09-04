package com.mangopay.core;

import com.mangopay.entities.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        
        assertNotNull(wallet.Id);
        assertFalse(wallet.Id.equals(""));
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
    public void test_Wallets_Update() throws Exception {
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
        PayIn payIn = null;
        try {
            payIn = this.getJohnsPayInCardWeb();
        } catch (Exception ex) {
            Logger.getLogger(ApiWalletsTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Pagination pagination = new Pagination(1, 1);
        FilterTransactions filter = new FilterTransactions();
        filter.Type = "PAYIN";
        List<Transaction> transactions = this._api.Wallets.getTransactions(wallet.Id, pagination, filter);

        assertTrue(transactions.size() == 1);
        assertTrue(transactions.get(0) instanceof Transaction);
        assertTrue(transactions.get(0).AuthorId.equals(john.Id));
        assertEqualInputProps(transactions.get(0), (Transaction)payIn);
    }
}
