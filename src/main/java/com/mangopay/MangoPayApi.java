package com.mangopay;

import com.mangopay.core.APIs.*;
import com.mangopay.core.APIs.implementation.*;
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
        this.AuthenticationManager = new OAuthApiImpl(this);
        this.Clients = new ClientApiImpl(this);
        this.Users = new UserApiImpl(this);
        this.Wallets = new WalletApiImpl(this);
        this.PayIns = new PayInApiImpl(this);
        this.PayOuts = new PayOutApiImpl(this);
        this.Refunds = new RefundApiImpl(this);
        this.Transfers = new TransferApiImpl(this);
        this.CardRegistrations = new CardRegistrationApiImpl(this);
        this.Cards = new CardApiImpl(this);
        this.Events = new EventApiImpl(this);
        this.CardPreAuthorizations = new CardPreAuthorizationApiImpl(this);
        this.Hooks = new HookApiImpl(this);
        this.KycDocuments = new KycDocumentApiImpl(this);
        this.Disputes = new DisputeApiImpl(this);
        this.Idempotency = new IdempotencyApiImpl(this);
        this.Mandates = new MandateApiImpl(this);
        this.Reports = new ReportApiImpl(this);
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
     * @deprecated Use {@link #getClientApi()} and {@link #setClientApi(ApiClients)} instead.
     */
    @Deprecated
    public ApiClients Clients;

    /**
     * Provides Users methods.
     *
     * @deprecated Use {@link #getUserApi()} and {@link #setUserApi(ApiUsers)} instead.
     */
    @Deprecated
    public ApiUsers Users;

    /**
     * Provides Wallets methods.
     *
     * @deprecated Use {@link #getWalletApi()} and {@link #setWalletApi(ApiWallets)} instead.
     */
    @Deprecated
    public ApiWallets Wallets;

    /**
     * Provides PayIns methods.
     *
     * @deprecated Use {@link #getPayInApi()} and {@link #setPayInApi(ApiPayIns)} instead.
     */
    @Deprecated
    public ApiPayIns PayIns;

    /**
     * Provides PayOuts methods.
     *
     * @deprecated Use {@link #getPayOutApi()} and {@link #setPayOutApi(ApiPayOuts)} instead.
     */
    @Deprecated
    public ApiPayOuts PayOuts;

    /**
     * Provides Transfer methods.
     *
     * @deprecated Use {@link #getTransferApi()} and {@link #setTransferApi(ApiTransfers)} instead.
     */
    @Deprecated
    public ApiTransfers Transfers;

    /**
     * Provides CardRegistrations methods.
     *
     * @deprecated Use {@link #getCardRegistrationApi()} and {@link #setCardRegistrationApi(ApiCardRegistrations)} instead.
     */
    @Deprecated
    public ApiCardRegistrations CardRegistrations;

    /**
     * Provides CardPreAuthorizations methods.
     *
     * @deprecated Use {@link #getCardPreAuthorizationApi()} and {@link #setCardPreAuthorizationApi(ApiCardPreAuthorizations)} instead.
     */
    @Deprecated
    public ApiCardPreAuthorizations CardPreAuthorizations;

    /**
     * Provides Cards methods.
     *
     * @deprecated Use {@link #getCardApi()} and {@link #setCardApi(ApiCards)} instead.
     */
    @Deprecated
    public ApiCards Cards;

    /**
     * Provides Refunds methods.
     *
     * @deprecated Use {@link #getRefundApi()} and {@link #setRefundApi(ApiRefunds)} instead.
     */
    @Deprecated
    public ApiRefunds Refunds;

    /**
     * Provides Events methods.
     *
     * @deprecated Use {@link #getEventApi()} and {@link #setEventApi(ApiEvents)} instead.
     */
    @Deprecated
    public ApiEvents Events;

    /**
     * Provides Hooks methods.
     *
     * @deprecated Use {@link #getHookApi()} and {@link #setHookApi(ApiHooks)} instead.
     */
    @Deprecated
    public ApiHooks Hooks;

    /**
     * Provides KYC documents list methods.
     *
     * @deprecated Use {@link #getKycDocumentApi()} and {@link #setKycDocumentApi(ApiKycDocuments)} instead.
     */
    @Deprecated
    public ApiKycDocuments KycDocuments;

    /**
     * Provides Disputes methods.
     *
     * @deprecated Use {@link #getDisputeApi()} and {@link #setDisputeApi(ApiDisputes)} instead.
     */
    @Deprecated
    public ApiDisputes Disputes;

    /**
     * Provides Idempotency methods.
     *
     * @deprecated Use {@link #getIdempotencyApi()} and {@link #setIdempotencyApi(ApiIdempotency)} instead.
     */
    @Deprecated
    public ApiIdempotency Idempotency;

    /**
     * Provides Mandates methods.
     *
     * @deprecated Use {@link #getMandateApi()} and {@link #setMandateApi(ApiMandates)} instead.
     */
    @Deprecated
    public ApiMandates Mandates;

    /**
     * Provides Reports methods.
     *
     * @deprecated Use {@link #getReportApi()} and {@link #setReportApi(ApiReports)} instead.
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

    public ApiClients getClientApi() {
        return Clients;
    }

    public void setClientApi(ApiClients clients) {
        this.Clients = clients;
    }

    public ApiUsers getUserApi() {
        return Users;
    }

    public void setUserApi(ApiUsers users) {
        this.Users = users;
    }

    public ApiWallets getWalletApi() {
        return Wallets;
    }

    public void setWalletApi(ApiWallets wallets) {
        this.Wallets = wallets;
    }

    public ApiPayIns getPayInApi() {
        return PayIns;
    }

    public void setPayInApi(ApiPayIns payIns) {
        this.PayIns = payIns;
    }

    public ApiPayOuts getPayOutApi() {
        return PayOuts;
    }

    public void setPayOutApi(ApiPayOuts payOuts) {
        this.PayOuts = payOuts;
    }

    public ApiTransfers getTransferApi() {
        return Transfers;
    }

    public void setTransferApi(ApiTransfers transfers) {
        this.Transfers = transfers;
    }

    public ApiCardRegistrations getCardRegistrationApi() {
        return CardRegistrations;
    }

    public void setCardRegistrationApi(ApiCardRegistrations cardRegistrations) {
        this.CardRegistrations = cardRegistrations;
    }

    public ApiCardPreAuthorizations getCardPreAuthorizationApi() {
        return CardPreAuthorizations;
    }

    public void setCardPreAuthorizationApi(ApiCardPreAuthorizations cardPreAuthorizations) {
        this.CardPreAuthorizations = cardPreAuthorizations;
    }

    public ApiCards getCardApi() {
        return Cards;
    }

    public void setCardApi(ApiCards cards) {
        this.Cards = cards;
    }

    public ApiRefunds getRefundApi() {
        return Refunds;
    }

    public void setRefundApi(ApiRefunds refunds) {
        this.Refunds = refunds;
    }

    public ApiEvents getEventApi() {
        return Events;
    }

    public void setEventApi(ApiEvents events) {
        this.Events = events;
    }

    public ApiHooks getHookApi() {
        return Hooks;
    }

    public void setHookApi(ApiHooks hooks) {
        this.Hooks = hooks;
    }

    public ApiKycDocuments getKycDocumentApi() {
        return KycDocuments;
    }

    public void setKycDocumentApi(ApiKycDocuments kycDocuments) {
        this.KycDocuments = kycDocuments;
    }

    public ApiDisputes getDisputeApi() {
        return Disputes;
    }

    public void setDisputeApi(ApiDisputes disputes) {
        this.Disputes = disputes;
    }

    public ApiIdempotency getIdempotencyApi() {
        return Idempotency;
    }

    public void setIdempotencyApi(ApiIdempotency idempotency) {
        this.Idempotency = idempotency;
    }

    public ApiMandates getMandateApi() {
        return Mandates;
    }

    public void setMandateApi(ApiMandates mandates) {
        this.Mandates = mandates;
    }

    public ApiReports getReportApi() {
        return Reports;
    }

    public void setReportApi(ApiReports reports) {
        this.Reports = reports;
    }
}
