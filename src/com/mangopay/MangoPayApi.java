package com.mangopay;

import com.mangopay.core.Configuration;
import com.mangopay.core.*;

/**
 * MangoPay API main entry point.
 * Provides managers to connect, send and read data from MangoPay API
 * as well as holds configuration/authorization data.
 */
public class MangoPayApi {

    public MangoPayApi() {

        // default config setup
        Config = new Configuration();

        // API managers
        AuthenticationManager = new ApiOAuth(this);
        Clients = new ApiClients(this);
        Users = new ApiUsers(this);
        Wallets = new ApiWallets(this);
        PayIns = new ApiPayIns(this);
        PayOuts = new ApiPayOuts(this);
        Transfers = new ApiTransfers(this);
        CardRegistrations = new ApiCardRegistrations(this);
    }
    
    ////////////////////////////////////////
    // Config/authorization related fields
    ////////////////////////////////////////

    /**
     * OAuthToken; null by default: will auto-generate it on first API call.
     * Or you can set your own if you want to reuse it until it expires.
     */
    public OAuthToken OAuthToken;

    /**
     * Configuration instance with default settings (to be reset if required).
     */
    public Configuration Config;

    ////////////////////////////////////////
    // API managers fields
    ////////////////////////////////////////

    /**
     * OAuth methods.
     */
    public ApiOAuth AuthenticationManager;

    /**
     * Clients methods.
     */
    public ApiClients Clients;

    /**
     * Users methods.
     */
    public ApiUsers Users;
    
    /**
     * Wallets methods.
     */
    public ApiWallets Wallets;
    
    /**
     * PayIns methods.
     */
    public ApiPayIns PayIns;
    
    /**
     * PayOuts methods.
     */
    public ApiPayOuts PayOuts;
    
    /**
     * Transfer methods.
     */
    public ApiTransfers Transfers;
    
    /**
     * CardRegistrations methods.
     */
    public ApiCardRegistrations CardRegistrations;
    
}
