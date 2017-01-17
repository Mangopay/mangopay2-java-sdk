package com.mangopay;

import com.mangopay.core.APIs.*;
import com.mangopay.core.AuthorizationTokenManager;
import com.mangopay.core.Configuration;

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
        this.Config = new Configuration();
        this.OAuthTokenManager = new AuthorizationTokenManager(this);

        // API managers
        this.AuthenticationManager = new ApiOAuth(this);
        this.Clients = new ApiClients(this);
        this.Users = new ApiUsers(this);
        this.Wallets = new ApiWallets(this);
        this.PayIns = new ApiPayIns(this);
        this.PayOuts = new ApiPayOuts(this);
        this.Refunds = new ApiRefunds(this);
        this.Transfers = new ApiTransfers(this);
        this.CardRegistrations = new ApiCardRegistrations(this);
        this.Cards = new ApiCards(this);
        this.Events = new ApiEvents(this);
        this.CardPreAuthorizations = new ApiCardPreAuthorizations(this);
        this.Hooks = new ApiHooks(this);
        this.KycDocuments = new ApiKycDocuments(this);
        this.Disputes = new ApiDisputes(this);
        this.Idempotency = new ApiIdempotency(this);
        this.Mandates = new ApiMandates(this);
        this.Reports = new ApiReports(this);
    }

    ////////////////////////////////////////
    // Config/authorization related fields
    ////////////////////////////////////////

    /**
     * Provides Authorization token methods.
     *
     * @deprecated Use {@link #getOAuthTokenManager()} and {@link #setOAuthTokenManager(AuthorizationTokenManager)} instead.
     */
    @Deprecated
    public AuthorizationTokenManager OAuthTokenManager;

    /**
     * Configuration instance with default settings (to be reset if required).
     *
     * @deprecated Use {@link #getConfig()} and {@link #setConfig(Configuration)} instead.
     */
    @Deprecated
    public Configuration Config;

    ////////////////////////////////////////
    // API managers fields
    ////////////////////////////////////////

    /**
     * Provides OAuth methods.
     *
     * @deprecated Use {@link #getAuthenticationManager()} and {@link #setAuthenticationManager(ApiOAuth)} instead.
     */
    @Deprecated
    public ApiOAuth AuthenticationManager;

    /**
     * Provides Clients methods.
     *
     * @deprecated Use {@link #getClients()} and {@link #setClients(ApiClients)} instead.
     */
    @Deprecated
    public ApiClients Clients;

    /**
     * Provides Users methods.
     *
     * @deprecated Use {@link #getUsers()} and {@link #setUsers(ApiUsers)} instead.
     */
    @Deprecated
    public ApiUsers Users;

    /**
     * Provides Wallets methods.
     *
     * @deprecated Use {@link #getWallets()} and {@link #setWallets(ApiWallets)} instead.
     */
    @Deprecated
    public ApiWallets Wallets;

    /**
     * Provides PayIns methods.
     *
     * @deprecated Use {@link #getPayIns()} and {@link #setPayIns(ApiPayIns)} instead.
     */
    @Deprecated
    public ApiPayIns PayIns;

    /**
     * Provides PayOuts methods.
     *
     * @deprecated Use {@link #getPayOuts()} and {@link #setPayOuts(ApiPayOuts)} instead.
     */
    @Deprecated
    public ApiPayOuts PayOuts;

    /**
     * Provides Transfer methods.
     *
     * @deprecated Use {@link #getTransfers()} and {@link #setTransfers(ApiTransfers)} instead.
     */
    @Deprecated
    public ApiTransfers Transfers;

    /**
     * Provides CardRegistrations methods.
     *
     * @deprecated Use {@link #getCardRegistrations()} and {@link #setCardRegistrations(ApiCardRegistrations)} instead.
     */
    @Deprecated
    public ApiCardRegistrations CardRegistrations;

    /**
     * Provides CardPreAuthorizations methods.
     *
     * @deprecated Use {@link #getCardPreAuthorizations()} and {@link #setCardPreAuthorizations(ApiCardPreAuthorizations)} instead.
     */
    @Deprecated
    public ApiCardPreAuthorizations CardPreAuthorizations;

    /**
     * Provides Cards methods.
     *
     * @deprecated Use {@link #getCards()} and {@link #setCards(ApiCards)} instead.
     */
    @Deprecated
    public ApiCards Cards;

    /**
     * Provides Refunds methods.
     *
     * @deprecated Use {@link #getRefunds()} and {@link #setRefunds(ApiRefunds)} instead.
     */
    @Deprecated
    public ApiRefunds Refunds;

    /**
     * Provides Events methods.
     *
     * @deprecated Use {@link #getEvents()} and {@link #setEvents(ApiEvents)} instead.
     */
    @Deprecated
    public ApiEvents Events;

    /**
     * Provides Hooks methods.
     *
     * @deprecated Use {@link #getHooks()} and {@link #setHooks(ApiHooks)} instead.
     */
    @Deprecated
    public ApiHooks Hooks;

    /**
     * Provides KYC documents list methods.
     *
     * @deprecated Use {@link #getKycDocuments()} and {@link #setKycDocuments(ApiKycDocuments)} instead.
     */
    @Deprecated
    public ApiKycDocuments KycDocuments;

    /**
     * Provides Disputes methods.
     *
     * @deprecated Use {@link #getDisputes()} and {@link #setDisputes(ApiDisputes)} instead.
     */
    @Deprecated
    public ApiDisputes Disputes;

    /**
     * Provides Idempotency methods.
     *
     * @deprecated Use {@link #getIdempotency()} and {@link #setIdempotency(ApiIdempotency)} instead.
     */
    @Deprecated
    public ApiIdempotency Idempotency;

    /**
     * Provides Mandates methods.
     *
     * @deprecated Use {@link #getMandates()} and {@link #setMandates(ApiMandates)} instead.
     */
    @Deprecated
    public ApiMandates Mandates;

    /**
     * Provides Reports methods.
     *
     * @deprecated Use {@link #getReports()} and {@link #setReports(ApiReports)} instead.
     */
    @Deprecated
    public ApiReports Reports;

    public AuthorizationTokenManager getOAuthTokenManager() {
        return OAuthTokenManager;
    }

    public void setOAuthTokenManager(AuthorizationTokenManager OAuthTokenManager) {
        this.OAuthTokenManager = OAuthTokenManager;
    }

    public Configuration getConfig() {
        return Config;
    }

    public void setConfig(Configuration config) {
        this.Config = config;
    }

    public ApiOAuth getAuthenticationManager() {
        return AuthenticationManager;
    }

    public void setAuthenticationManager(ApiOAuth authenticationManager) {
        this.AuthenticationManager = authenticationManager;
    }

    public ApiClients getClients() {
        return Clients;
    }

    public void setClients(ApiClients clients) {
        this.Clients = clients;
    }

    public ApiUsers getUsers() {
        return Users;
    }

    public void setUsers(ApiUsers users) {
        this.Users = users;
    }

    public ApiWallets getWallets() {
        return Wallets;
    }

    public void setWallets(ApiWallets wallets) {
        this.Wallets = wallets;
    }

    public ApiPayIns getPayIns() {
        return PayIns;
    }

    public void setPayIns(ApiPayIns payIns) {
        this.PayIns = payIns;
    }

    public ApiPayOuts getPayOuts() {
        return PayOuts;
    }

    public void setPayOuts(ApiPayOuts payOuts) {
        this.PayOuts = payOuts;
    }

    public ApiTransfers getTransfers() {
        return Transfers;
    }

    public void setTransfers(ApiTransfers transfers) {
        this.Transfers = transfers;
    }

    public ApiCardRegistrations getCardRegistrations() {
        return CardRegistrations;
    }

    public void setCardRegistrations(ApiCardRegistrations cardRegistrations) {
        this.CardRegistrations = cardRegistrations;
    }

    public ApiCardPreAuthorizations getCardPreAuthorizations() {
        return CardPreAuthorizations;
    }

    public void setCardPreAuthorizations(ApiCardPreAuthorizations cardPreAuthorizations) {
        this.CardPreAuthorizations = cardPreAuthorizations;
    }

    public ApiCards getCards() {
        return Cards;
    }

    public void setCards(ApiCards cards) {
        this.Cards = cards;
    }

    public ApiRefunds getRefunds() {
        return Refunds;
    }

    public void setRefunds(ApiRefunds refunds) {
        this.Refunds = refunds;
    }

    public ApiEvents getEvents() {
        return Events;
    }

    public void setEvents(ApiEvents events) {
        this.Events = events;
    }

    public ApiHooks getHooks() {
        return Hooks;
    }

    public void setHooks(ApiHooks hooks) {
        this.Hooks = hooks;
    }

    public ApiKycDocuments getKycDocuments() {
        return KycDocuments;
    }

    public void setKycDocuments(ApiKycDocuments kycDocuments) {
        this.KycDocuments = kycDocuments;
    }

    public ApiDisputes getDisputes() {
        return Disputes;
    }

    public void setDisputes(ApiDisputes disputes) {
        this.Disputes = disputes;
    }

    public ApiIdempotency getIdempotency() {
        return Idempotency;
    }

    public void setIdempotency(ApiIdempotency idempotency) {
        this.Idempotency = idempotency;
    }

    public ApiMandates getMandates() {
        return Mandates;
    }

    public void setMandates(ApiMandates mandates) {
        this.Mandates = mandates;
    }

    public ApiReports getReports() {
        return Reports;
    }

    public void setReports(ApiReports reports) {
        this.Reports = reports;
    }
}
