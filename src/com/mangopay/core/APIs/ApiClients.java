package com.mangopay.core.APIs;

import com.mangopay.MangoPayApi;
import com.mangopay.core.RestTool;
import com.mangopay.entities.Client;
import java.util.*;

/**
 * API for clients.
 */
public class ApiClients extends ApiBase {
    
    /**
     * Instantiates new ApiClients object.
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public ApiClients(MangoPayApi root) { super(root); }

    /**
     * Gets client data for Basic Access Authentication.
     * @param clientId      Client identifier.
     * @param clientName    Beautiful name for presentation.
     * @param clientEmail   Client's email.
     * @return              Client instance returned from API.
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
        
        RestTool rest = new RestTool(this._root, false);
        rest.addRequestHttpHeader("Content-Type", "application/x-www-form-urlencoded");
        return rest.request(Client.class, null, urlMethod, requestType, requestData);
    }    
}
