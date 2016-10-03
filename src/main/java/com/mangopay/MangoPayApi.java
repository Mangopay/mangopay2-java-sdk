package com.mangopay;

import com.mangopay.core.APIs.*;
import com.mangopay.core.*;

/**
 * MangoPay API main entry point.
 * Provides managers to connect, send and read data from MangoPay API
 * as well as holds configuration/authorization data.
 */
public class MangoPayApi {

    /**
     * Instantiates new MangoPayApi object.
     */
    public MangoPayApi() {

        // default config setup
        Config = new Configuration();
        OAuthTokenManager = new AuthorizationTokenManager(this);

        // API managers
        AuthenticationManager = new ApiOAuth(this);
        Clients = new ApiClients(this);
        Users = new ApiUsers(this);
        Wallets = new ApiWallets(this);
        PayIns = new ApiPayIns(this);
        PayOuts = new ApiPayOuts(this);
        Refunds = new ApiRefunds(this);
        Transfers = new ApiTransfers(this);
        CardRegistrations = new ApiCardRegistrations(this);
        Cards = new ApiCards(this);
        Events = new ApiEvents(this);
        CardPreAuthorizations = new ApiCardPreAuthorizations(this);
        Hooks = new ApiHooks(this);
        KycDocuments = new ApiKycDocuments(this);
        Disputes = new ApiDisputes(this);
	Idempotency = new ApiIdempotency(this);
	Mandates = new ApiMandates(this);
        Reports = new ApiReports(this);
    }
    
    ////////////////////////////////////////
    // Config/authorization related fields
    ////////////////////////////////////////

    /**
     * Provides Authorization token methods.
     */
    public AuthorizationTokenManager OAuthTokenManager;

    /**
     * Configuration instance with default settings (to be reset if required).
     */
    public Configuration Config;

    ////////////////////////////////////////
    // API managers fields
    ////////////////////////////////////////

    /**
     * Provides OAuth methods.
     */
    public ApiOAuth AuthenticationManager;

    /**
     * Provides Clients methods.
     */
    public ApiClients Clients;

    /**
     * Provides Users methods.
     */
    public ApiUsers Users;
    
    /**
     * Provides Wallets methods.
     */
    public ApiWallets Wallets;
    
    /**
     * Provides PayIns methods.
     */
    public ApiPayIns PayIns;
    
    /**
     * Provides PayOuts methods.
     */
    public ApiPayOuts PayOuts;
    
    /**
     * Provides Transfer methods.
     */
    public ApiTransfers Transfers;
    
    /**
     * Provides CardRegistrations methods.
     */
    public ApiCardRegistrations CardRegistrations;
    
    /**
     * Provides CardPreAuthorizations methods.
     */
    public ApiCardPreAuthorizations CardPreAuthorizations;
    
    /**
     * Provides Cards methods.
     */
    public ApiCards Cards;
    
    /**
     * Provides Refunds methods.
     */
    public ApiRefunds Refunds;
    
    /**
     * Provides Events methods.
     */
    public ApiEvents Events;
    
    /**
     * Provides Hooks methods.
     */
    public ApiHooks Hooks;
    
    /**
     * Provides KYC documents list methods.
     */
    public ApiKycDocuments KycDocuments;
    
    /**
     * Provides Disputes methods.
     */
    public ApiDisputes Disputes;
    
    /**
     * Provides Idempotency methods.
     */
    public ApiIdempotency Idempotency;
    
    /**
     * Provides Mandates methods.
     */
    public ApiMandates Mandates;
    
    /**
     * Provides Reports methods.
     */
    public ApiReports Reports;
    
}
