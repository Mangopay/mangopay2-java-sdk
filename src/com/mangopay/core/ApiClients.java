package com.mangopay.core;

import com.mangopay.MangoPayApi;
import com.mangopay.entities.Client;
import java.util.HashMap;
import java.util.Map;

/**
 * API for Clients.
 */
public class ApiClients extends ApiBase {
    
    /**
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance
     */
    public ApiClients(MangoPayApi root) { super(root); }

    /**
     * Gets client data for Basic Access Authentication.
     * @param clientId      Client identifier
     * @param clientName    Beautiful name for presentation
     * @param clientEmail   Client's email
     * @return              Returns Client entity instance.
     * @throws Exception
     */
    public Client create(final String clientId, final String clientName, final String clientEmail) throws Exception {

        String urlMethod = this.getRequestUrl("authentication_base");
        String requestType = this.getRequestType("authentication_base");
        
        Map<String, String> requestData = new HashMap<String, String>() {{
            put("ClientId", clientId);
            put("Name", clientName);
            put("Email", clientEmail);
        }};
        
        RestTool rest = this.getRestToolObject(false);
        rest.addRequestHttpHeader("Content-Type", "application/x-www-form-urlencoded");
        return rest.request(Client.class, urlMethod, requestType, requestData);
    }    
}
