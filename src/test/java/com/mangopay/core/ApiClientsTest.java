package com.mangopay.core;
import com.mangopay.core.enumerations.FundsType;
import com.mangopay.entities.Client;
import com.mangopay.entities.Transaction;
import com.mangopay.entities.Wallet;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * ApiClients test methods
 */
public class ApiClientsTest extends BaseTest {
    
    @Test
    public void test_ClientsCreateClient() throws Exception {        
        Random rand = new Random();
        String id = Integer.toString(rand.nextInt(1000000000) + 1);
        Client client = this._api.Clients.create(id, "test",  "test@o2.pl");
        assertTrue("test".equals(client.Name));
        assertTrue(client.Passphrase.length() > 0);
    }
    
    @Test(expected = ResponseException.class)
    public void test_Clients_TryCreateInvalidClient() throws Exception {
        // invalid id
        Client client = this._api.Clients.create("0", "test",  "test@o2.pl");
        assertTrue(client == null);
    }
    
    @Test
    public void test_ClientGet() throws Exception {
        Client client = this._api.Clients.get();
        
        assertNotNull(client);
        assertTrue("sdk-unit-tests".equals(client.ClientId));
    }
    
    @Test
    public void test_ClientSave() throws Exception {
        Client client = this._api.Clients.get();
        
        Random rand = new Random();
        String color1 = Integer.toString(rand.nextInt(100000) + 100000);
        String color2 = Integer.toString(rand.nextInt(100000) + 100000);
        
        client.PrimaryButtonColour = "#" + color1;
        client.PrimaryThemeColour = "#" + color2;
        
        Client clientNew = this._api.Clients.save(client);
        
        assertNotNull(clientNew);
        assertEquals(client.PrimaryButtonColour, clientNew.PrimaryButtonColour);
        assertEquals(client.PrimaryThemeColour, clientNew.PrimaryThemeColour);
    }
    
    @Test 
    public void test_ClientLogo() throws Exception {
        
        URL url = getClass().getResource("/com/mangopay/core/TestKycPageFile.png");
        String filePath = new File(url.toURI()).getAbsolutePath();

        this._api.Clients.uploadLogo(filePath);
        
        this._api.Clients.uploadLogo(Files.readAllBytes(Paths.get(filePath)));
    }
    
    @Test
    public void test_Client_GetWallets()
    {
        List<Wallet> feesWallets = null;
        List<Wallet> creditWallets = null;
        try
        {
            feesWallets = this._api.Clients.getWallets(FundsType.FEES, new Pagination(1, 100));
            creditWallets = this._api.Clients.getWallets(FundsType.CREDIT, new Pagination(1, 100));
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
        assertNotNull(feesWallets);
        assertNotNull(creditWallets);
    }

    @Test
    public void test_Client_GetWallet() throws Exception
    {
        List<Wallet> feesWallets = null;
        List<Wallet> creditWallets = null;
        List<Wallet> defaultWallets = null;
        try
        {
            feesWallets = this._api.Clients.getWallets(FundsType.FEES, new Pagination(1, 1));
            creditWallets = this._api.Clients.getWallets(FundsType.CREDIT, new Pagination(1, 1));
            defaultWallets = this._api.Clients.getWallets(FundsType.DEFAULT, new Pagination(1, 1));
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        if ((feesWallets == null || feesWallets.isEmpty()) ||
            (creditWallets == null || creditWallets.isEmpty()) ||
            (defaultWallets == null || defaultWallets.isEmpty()))
            Assert.fail("Cannot test getting client's wallet because there is no any wallet for client.");

        Wallet wallet = null;
        Wallet result = null;
        if (feesWallets != null && feesWallets.size() > 0)
            wallet = feesWallets.get(0);
        else if (creditWallets != null && creditWallets.size() > 0)
            wallet = creditWallets.get(0);
        else
            wallet = defaultWallets.get(0);

        result = this._api.Clients.getWallet(wallet.FundsType, wallet.Currency);

        assertNotNull(result);
        assertTrue(result.FundsType == wallet.FundsType);
        assertTrue(result.Currency == wallet.Currency);
    }

    @Test
    public void test_Client_GetWalletTransactions() throws Exception
    {
        List<Wallet> feesWallets = null;
        List<Wallet> creditWallets = null;
        List<Wallet> defaultWallets = null;
        try
        {
            feesWallets = this._api.Clients.getWallets(FundsType.FEES, new Pagination(1, 1));
            creditWallets = this._api.Clients.getWallets(FundsType.CREDIT, new Pagination(1, 1));
            defaultWallets = this._api.Clients.getWallets(FundsType.DEFAULT, new Pagination(1, 1));
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        if ((feesWallets == null || feesWallets.isEmpty()) ||
            (creditWallets == null || creditWallets.isEmpty()) ||
            (defaultWallets == null || defaultWallets.isEmpty()))
            Assert.fail("Cannot test getting client's wallet transactions because there is no any wallet for client.");

        Wallet wallet = null;
        List<Transaction> result = null;
        if (feesWallets != null && feesWallets.size() > 0)
            wallet = feesWallets.get(0);
        else if (creditWallets != null && creditWallets.size() > 0)
            wallet = creditWallets.get(0);
        else
            wallet = defaultWallets.get(0);

        result = this._api.Clients.getWalletTransactions(wallet.FundsType, wallet.Currency, new Pagination(1, 1), null, null);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}
