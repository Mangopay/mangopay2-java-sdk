package com.mangopay.core;

import com.mangopay.entities.VirtualAccount;
import com.mangopay.entities.Wallet;
import com.mangopay.entities.subentities.VirtualAccountAvailabilities;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * VirtualAccountApi test methods
 */
public class VirtualAccountApiImplTest extends BaseTest {

    @Test
    public void createVirtualAccount() throws Exception {
        VirtualAccount johnsVirtualAccount = this.getJohnsVirtualAccount();
        Wallet johnsWallet = this.getJohnsWallet();

        assertNotNull(johnsVirtualAccount);
        assertEquals(johnsVirtualAccount.getWalletId(), johnsWallet.getId());
    }

    @Test
    public void getVirtualAccount() throws Exception {
        VirtualAccount johnVirtualAccount = this.getJohnsVirtualAccount();
        Wallet johnsWallet = this.getJohnsWallet();

        VirtualAccount fetchedVirtualAccount = this.api.getVirtualAccountApi().get(johnsWallet.getId(), johnVirtualAccount.getId());

        assertNotNull(fetchedVirtualAccount);
        assertEquals(fetchedVirtualAccount.getId(), johnVirtualAccount.getId());
    }

    @Test
    public void getAllVirtualAccounts() throws Exception {
        VirtualAccount virtualAccount = this.getJohnsVirtualAccount();
        Wallet wallet = this.getJohnsWallet();

        List<VirtualAccount> virtualAccounts = this.api.getVirtualAccountApi().getAll(wallet.getId(), null, null);

        assertNotNull(virtualAccounts);
        assertEquals(1, virtualAccounts.size());
    }

    @Test
    public void getAvailabilities() throws Exception {
        VirtualAccountAvailabilities availabilities = this.api.getVirtualAccountApi().getAvailabilities();

        assertNotNull(availabilities);
        assertTrue(availabilities.getCollection().getClass().isArray());
        assertTrue(availabilities.getUserOwned().getClass().isArray());
    }

    @Test
    public void deactivateVirtualAccount() throws Exception {
        VirtualAccount virtualAccount = this.getJohnsVirtualAccount();
        Wallet wallet = this.getJohnsWallet();
        VirtualAccount deactivatedVirtualAccount = this.api.getVirtualAccountApi().deactivate(wallet.getId(), virtualAccount.getId());

        assertFalse(deactivatedVirtualAccount.getActive());
        assertEquals("CLOSED", deactivatedVirtualAccount.getStatus());
    }
}
