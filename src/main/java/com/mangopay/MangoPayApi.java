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
        this.config = new Configuration();
        this.oAuthTokenManager = new AuthorizationTokenManager(this);

        // API managers
        this.authenticationManager = new OAuthApiImpl(this);
        this.clients = new ClientApiImpl(this);
        this.users = new UserApiImpl(this);
        this.wallets = new WalletApiImpl(this);
        this.payIns = new PayInApiImpl(this);
        this.payOuts = new PayOutApiImpl(this);
        this.refunds = new RefundApiImpl(this);
        this.transfers = new TransferApiImpl(this);
        this.cardRegistrations = new CardRegistrationApiImpl(this);
        this.cards = new CardApiImpl(this);
        this.events = new EventApiImpl(this);
        this.cardPreAuthorizations = new CardPreAuthorizationApiImpl(this);
        this.hooks = new HookApiImpl(this);
        this.kycDocuments = new KycDocumentApiImpl(this);
        this.disputes = new DisputeApiImpl(this);
        this.idempotency = new IdempotencyApiImpl(this);
        this.mandates = new MandateApiImpl(this);
        this.reports = new ReportApiImpl(this);
    }

    ////////////////////////////////////////
    // config/authorization related fields
    ////////////////////////////////////////

    /**
     * Provides Authorization token methods.
     */
    private AuthorizationTokenManager oAuthTokenManager;

    /**
     * Configuration instance with default settings (to be reset if required).
     */
    private Configuration config;

    ////////////////////////////////////////
    // API managers fields
    ////////////////////////////////////////

    /**
     * Provides OAuth methods.
     */
    private OAuthApi authenticationManager;

    /**
     * Provides clients methods.
     */
    private ClientApi clients;

    /**
     * Provides users methods.
     */
    private UserApi users;

    /**
     * Provides wallets methods.
     */
    private WalletApi wallets;

    /**
     * Provides payIns methods.
     */
    private PayInApi payIns;

    /**
     * Provides payOuts methods.
     */
    private PayOutApi payOuts;

    /**
     * Provides Transfer methods.
     */
    private TransferApi transfers;

    /**
     * Provides cardRegistrations methods.
     */
    private CardRegistrationApi cardRegistrations;

    /**
     * Provides cardPreAuthorizations methods.
     */
    private CardPreAuthorizationApi cardPreAuthorizations;

    /**
     * Provides cards methods.
     */
    private CardApi cards;

    /**
     * Provides refunds methods.
     */
    private RefundApi refunds;

    /**
     * Provides events methods.
     */
    private EventApi events;

    /**
     * Provides hooks methods.
     */
    private HookApi hooks;

    /**
     * Provides KYC documents list methods.
     */
    private KycDocumentApi kycDocuments;

    /**
     * Provides disputes methods.
     */
    private DisputeApi disputes;

    /**
     * Provides idempotency methods.
     */
    private IdempotencyApi idempotency;

    /**
     * Provides mandates methods.
     */
    private MandateApi mandates;

    /**
     * Provides reports methods.
     */
    private ReportApi reports;

    public AuthorizationTokenManager getOAuthTokenManager() {
        return oAuthTokenManager;
    }

    public void setOAuthTokenManager(AuthorizationTokenManager oAuthTokenManager) {
        this.oAuthTokenManager = oAuthTokenManager;
    }

    public Configuration getConfig() {
        return config;
    }

    public void setConfig(Configuration config) {
        this.config = config;
    }

    public OAuthApi getAuthenticationManager() {
        return authenticationManager;
    }

    public void setAuthenticationManager(OAuthApi authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public ClientApi getClientApi() {
        return clients;
    }

    public void setClientApi(ClientApi clients) {
        this.clients = clients;
    }

    public UserApi getUserApi() {
        return users;
    }

    public void setUserApi(UserApi users) {
        this.users = users;
    }

    public WalletApi getWalletApi() {
        return wallets;
    }

    public void setWalletApi(WalletApi wallets) {
        this.wallets = wallets;
    }

    public PayInApi getPayInApi() {
        return payIns;
    }

    public void setPayInApi(PayInApi payIns) {
        this.payIns = payIns;
    }

    public PayOutApi getPayOutApi() {
        return payOuts;
    }

    public void setPayOutApi(PayOutApi payOuts) {
        this.payOuts = payOuts;
    }

    public TransferApi getTransferApi() {
        return transfers;
    }

    public void setTransferApi(TransferApi transfers) {
        this.transfers = transfers;
    }

    public CardRegistrationApi getCardRegistrationApi() {
        return cardRegistrations;
    }

    public void setCardRegistrationApi(CardRegistrationApi cardRegistrations) {
        this.cardRegistrations = cardRegistrations;
    }

    public CardPreAuthorizationApi getCardPreAuthorizationApi() {
        return cardPreAuthorizations;
    }

    private void setCardPreAuthorizationApi(CardPreAuthorizationApi cardPreAuthorizations) {
        this.cardPreAuthorizations = cardPreAuthorizations;
    }

    public CardApi getCardApi() {
        return cards;
    }

    private void setCardApi(CardApi cards) {
        this.cards = cards;
    }

    public RefundApi getRefundApi() {
        return refunds;
    }

    private void setRefundApi(RefundApi refunds) {
        this.refunds = refunds;
    }

    public EventApi getEventApi() {
        return events;
    }

    private void setEventApi(EventApi events) {
        this.events = events;
    }

    public HookApi getHookApi() {
        return hooks;
    }

    private void setHookApi(HookApi hooks) {
        this.hooks = hooks;
    }

    public KycDocumentApi getKycDocumentApi() {
        return kycDocuments;
    }

    private void setKycDocumentApi(KycDocumentApi kycDocuments) {
        this.kycDocuments = kycDocuments;
    }

    public DisputeApi getDisputeApi() {
        return disputes;
    }

    private void setDisputeApi(DisputeApi disputes) {
        this.disputes = disputes;
    }

    public IdempotencyApi getIdempotencyApi() {
        return idempotency;
    }

    private void setIdempotencyApi(IdempotencyApi idempotency) {
        this.idempotency = idempotency;
    }

    public MandateApi getMandateApi() {
        return mandates;
    }

    private void setMandateApi(MandateApi mandates) {
        this.mandates = mandates;
    }

    public ReportApi getReportApi() {
        return reports;
    }

    private void setReportApi(ReportApi reports) {
        this.reports = reports;
    }
}
