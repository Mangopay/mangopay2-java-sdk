package com.mangopay.core;
import com.mangopay.core.enumerations.*;
import com.mangopay.entities.Client;
import com.mangopay.entities.ClientBankWireDirect;
import com.mangopay.entities.KycDocument;
import com.mangopay.entities.PayIn;
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
    public void getKycDocuments() throws Exception
    {
        List<KycDocument> result = null;
        List<KycDocument> result2 = null;

        try
        {
            result = this.api.Clients.getKycDocuments(null, null, null);
            assertNotNull(result);
            assertTrue(result.size() > 0);

            Pagination pagination = new Pagination(1, 2);
            Sorting sort = new Sorting();
            sort.addField("CreationDate", SortDirection.asc);
            result = this.api.Clients.getKycDocuments(pagination, null, sort);
            assertNotNull(result);
            assertTrue(result.size() > 0);

            sort = new Sorting();
            sort.addField("CreationDate", SortDirection.desc);
            result2 = this.api.Clients.getKycDocuments(pagination, null, sort);
            assertNotNull(result2);
            assertTrue(result2.size() > 0);

            assertTrue((result.get(0).Id == null ? result2.get(0).Id != null : !result.get(0).Id.equals(result2.get(0).Id)));
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void getClient() throws Exception {
        Client client = this.api.Clients.get();
        
        assertNotNull(client);
        assertTrue("sdk-unit-tests".equals(client.ClientId));
    }
    
    @Test
    public void updateClient() throws Exception {
        Client client = this.api.Clients.get();
        
        Random rand = new Random();
        String color1 = Integer.toString(rand.nextInt(100000) + 100000);
        String color2 = Integer.toString(rand.nextInt(100000) + 100000);
        
        client.PrimaryButtonColour = "#" + color1;
        client.PrimaryThemeColour = "#" + color2;
        
        Client clientNew = this.api.Clients.save(client);
        
        assertNotNull(clientNew);
        assertEquals(client.PrimaryButtonColour, clientNew.PrimaryButtonColour);
        assertEquals(client.PrimaryThemeColour, clientNew.PrimaryThemeColour);
    }
    
    @Test 
    public void uploadClientLogo() throws Exception {
        
        URL url = getClass().getResource("/com/mangopay/core/TestKycPageFile.png");
        String filePath = new File(url.toURI()).getAbsolutePath();

        this.api.Clients.uploadLogo(filePath);
        
        this.api.Clients.uploadLogo(Files.readAllBytes(Paths.get(filePath)));
    }
    
    @Test
    public void getWallets()
    {
        List<Wallet> feesWallets = null;
        List<Wallet> creditWallets = null;
        try
        {
            feesWallets = this.api.Clients.getWallets(FundsType.FEES, new Pagination(1, 100));
            creditWallets = this.api.Clients.getWallets(FundsType.CREDIT, new Pagination(1, 100));
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
        assertNotNull(feesWallets);
        assertNotNull(creditWallets);
    }

    @Test
    public void getWallet() throws Exception
    {
        List<Wallet> feesWallets = null;
        List<Wallet> creditWallets = null;
        List<Wallet> defaultWallets = null;
        try
        {
            feesWallets = this.api.Clients.getWallets(FundsType.FEES, new Pagination(1, 1));
            creditWallets = this.api.Clients.getWallets(FundsType.CREDIT, new Pagination(1, 1));
            defaultWallets = this.api.Clients.getWallets(FundsType.DEFAULT, new Pagination(1, 1));
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

        result = this.api.Clients.getWallet(wallet.FundsType, wallet.Currency);

        assertNotNull(result);
        assertTrue(result.FundsType == wallet.FundsType);
        assertTrue(result.Currency == wallet.Currency);
    }

    @Test
    public void getWalletTransactions() throws Exception
    {
        List<Wallet> feesWallets = null;
        List<Wallet> creditWallets = null;
        List<Wallet> defaultWallets = null;
        try
        {
            feesWallets = this.api.Clients.getWallets(FundsType.FEES, new Pagination(1, 1));
            creditWallets = this.api.Clients.getWallets(FundsType.CREDIT, new Pagination(1, 1));
            defaultWallets = this.api.Clients.getWallets(FundsType.DEFAULT, new Pagination(1, 1));
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

        result = this.api.Clients.getWalletTransactions(wallet.FundsType, wallet.Currency, new Pagination(1, 1), null, null);

        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
    
    @Test
    public void getTransactions()
    {
        List<Transaction> result = null;

        try
        {
            result = this.api.Clients.getTransactions(null, null, null);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }

        assertNotNull(result);
    }
    
    @Test
    public void createBankWireDirect()
    {
        try
        {
            Money money = new Money();
            money.Amount = 1000;
            money.Currency = CurrencyIso.EUR;
            ClientBankWireDirect bankwireDirectPost = new ClientBankWireDirect("CREDIT_EUR", money);

            PayIn result = this.api.Clients.createBankWireDirect(bankwireDirectPost);

            assertTrue(result.Id.length() > 0);
            assertEquals("CREDIT_EUR", result.CreditedWalletId);
            assertEquals(PayInPaymentType.BANK_WIRE, result.PaymentType);
            assertEquals(PayInExecutionType.DIRECT, result.ExecutionType);
            assertEquals(TransactionStatus.CREATED, result.Status);
            assertEquals(TransactionType.PAYIN, result.Type);
        }
        catch (Exception ex)
        {
            Assert.fail(ex.getMessage());
        }
    }
    
    public void saveAddressNull() throws Exception
    {
        Client client = new Client();

        Random rand = new Random();
        String color1 = Integer.toString(rand.nextInt(100000) + 100000);
        String color2 = Integer.toString(rand.nextInt(100000) + 100000);

        client.PrimaryButtonColour = "#" + color1;
        client.PrimaryThemeColour = "#" + color2;
        client.HeadquartersAddress = new Address();

        Client clientNew = this.api.Clients.save(client);

        assertNotNull(clientNew);			
    }
}
