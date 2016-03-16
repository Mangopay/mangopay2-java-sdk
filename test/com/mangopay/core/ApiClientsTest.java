package com.mangopay.core;
import com.mangopay.entities.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;
import org.junit.Test;
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
        
        URL url = getClass().getProtectionDomain().getCodeSource().getLocation();
        String filePath = url.toString() + "/com/mangopay/core/TestKycPageFile.png";
        filePath = filePath.replace("file:/", "").replace("//", "/").replace("/", "\\");
        
        this._api.Clients.uploadLogo(filePath);
        
        this._api.Clients.uploadLogo(Files.readAllBytes(Paths.get(filePath)));
    }
}
