package com.mangopay.core;

import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.entities.BankingAlias;
import com.mangopay.entities.Wallet;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

/**
 * Tests concerning the banking alias API.
 */
public class BankingAliasApiImplTest extends BaseTest {

    @Test
    public void createBankingAlias() throws Exception {
        BankingAlias bankingAlias = getJohnsBankingAlias();

        assertTrue(bankingAlias.getId().length() > 0);
        assertNotNull(bankingAlias.getDetails());
    }

    @Test
    public void getBankingAlias() throws Exception {
        BankingAlias bankingAlias = getJohnsBankingAlias();
        BankingAlias getBankingAlias = this.api.getBankingAliases().get(bankingAlias.getId());

        assertEquals(bankingAlias.getId(), getBankingAlias.getId());
        assertNotNull(bankingAlias.getDetails());
        assertNotNull(getBankingAlias.getDetails());
    }

    @Test
    public void getWalletBankingAliases() throws Exception {
        Wallet wallet = getJohnsWallet();
        BankingAlias bankingAlias = getJohnsBankingAlias();
        List<BankingAlias> bankingAliases = this.api.getBankingAliases().listForWallet(wallet.getId());

        assertEquals(bankingAlias.getId(), bankingAliases.get(0).getId());
    }

    @Test
    public void deactivateBankingAlias() throws Exception {
        BankingAlias bankingAlias = getJohnsBankingAlias();
        bankingAlias.setActive(false);
        BankingAlias deactivatedBankingAlias = this.api.getBankingAliases().deactivate(bankingAlias.getId(), bankingAlias);

        assertFalse(deactivatedBankingAlias.isActive());
    }
}
