package com.mangopay.core;
import com.mangopay.entities.*;
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
}
