package com.mangopay;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mangopay.core.APIs.*;
import com.mangopay.core.APIs.implementation.*;
import com.mangopay.core.AuthorizationTokenManager;
import com.mangopay.core.Configuration;
import com.mangopay.entities.RateLimit;

import java.util.List;

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
        setConfig(new Configuration());
        setOAuthTokenManager(new AuthorizationTokenManager(this));
        GsonBuilder gsonBuilder = new GsonBuilder().disableHtmlEscaping();

        // API managers
        setAuthenticationManager(new OAuthApiImpl(this));
        setClientApi(new ClientApiImpl(this));
        setUserApi(new UserApiImpl(this, gsonBuilder));
        setWalletApi(new WalletApiImpl(this));
        setPayInApi(new PayInApiImpl(this, gsonBuilder));
        setPayOutApi(new PayOutApiImpl(this));
        setRefundApi(new RefundApiImpl(this));
        setTransferApi(new TransferApiImpl(this, gsonBuilder));
        setCardRegistrationApi(new CardRegistrationApiImpl(this));
        setCardApi(new CardApiImpl(this));
        setEventApi(new EventApiImpl(this));
        setCardPreAuthorizationApi(new CardPreAuthorizationApiImpl(this));
        setHookApi(new HookApiImpl(this));
        setKycDocumentApi(new KycDocumentApiImpl(this));
        setDisputeApi(new DisputeApiImpl(this));
        setIdempotencyApi(new IdempotencyApiImpl(this, gsonBuilder));
        setMandateApi(new MandateApiImpl(this));
        setReportApi(new ReportApiImpl(this));
        setBankingAliasApi(new BankingAliasApiImpl(this));
        setUboDeclarationApi(new UboDeclarationApiImpl(this));
        setRepudiationApi(new RepudiationApiImpl(this));
        setSettlementApi(new SettlementApiImpl(this));
        setGson(gsonBuilder.create());
    }

    ////////////////////////////////////////
    // Rate limits
    ////////////////////////////////////////

    /**
     * Holds data as specified by X-RateLimit response headers.
     */
    private List<RateLimit> rateLimits;

    ////////////////////////////////////////
    // Config/authorization related fields
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
     * Provides Clients methods.
     */
    private ClientApi clients;

    /**
     * Provides Users methods.
     */
    private UserApi users;

    /**
     * Provides Wallets methods.
     */
    private WalletApi wallets;

    /**
     * Provides PayIns methods.
     */
    private PayInApi payIns;

    /**
     * Provides PayOuts methods.
     */
    private PayOutApi payOuts;

    /**
     * Provides Transfer methods.
     */
    private TransferApi transfers;

    /**
     * Provides CardRegistrations methods.
     */
    private CardRegistrationApi cardRegistrations;

    /**
     * Provides CardPreAuthorizations methods.
     */
    private CardPreAuthorizationApi cardPreAuthorizations;

    /**
     * Provides Cards methods.
     */
    private CardApi cards;

    /**
     * Provides Refunds methods.
     */
    private RefundApi refunds;

    /**
     * Provides Events methods.
     */
    private EventApi events;

    /**
     * Provides Hooks methods.
     */
    private HookApi hooks;

    /**
     * Provides KYC Documents list methods.
     */
    private KycDocumentApi kycDocuments;

    /**
     * Provides Disputes methods.
     */
    private DisputeApi disputes;

    /**
     * Provides Idempotency methods.
     */
    private IdempotencyApi idempotency;

    /**
     * Provides Mandates methods.
     */
    private MandateApi mandates;

    /**
     * Provides Reports methods.
     */
    private ReportApi reports;

    /**
     * Provides Banking Alias methods.
     */
    private BankingAliasApi bankingAliases;

    /**
     * Provides UBO Declaration methods.
     */
    private UboDeclarationApi uboDeclarations;

    /**
     * Provides Repudiation methods
     */
    private RepudiationApi repudiationApi;

    /**
     * Provides Settlement methods
     */
    private SettlementApi settlementApi;

    private Gson gson;

    /**
     * Gets the rate limit data.
     *
     * @return
     */
    public List<RateLimit> getRateLimits() {
        return rateLimits;
    }

    /**
     * Sets the rate limit data.
     *
     * @param rateLimits The rate limit data
     */
    public void setRateLimits(List<RateLimit> rateLimits) {
        this.rateLimits = rateLimits;
    }

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

    public BankingAliasApi getBankingAliases() {
        return bankingAliases;
    }

    private void setBankingAliasApi(BankingAliasApi bankingAliases) {
        this.bankingAliases = bankingAliases;
    }

    public UboDeclarationApi getUboDeclarationApi() {
        return uboDeclarations;
    }

    private void setUboDeclarationApi(UboDeclarationApi uboDeclarations) {
        this.uboDeclarations = uboDeclarations;
    }

    public RepudiationApi getRepudiationApi() {
        return repudiationApi;
    }

    public MangoPayApi setRepudiationApi(RepudiationApi repudiationApi) {
        this.repudiationApi = repudiationApi;
        return this;
    }

    public SettlementApi getSettlementApi() {
        return settlementApi;
    }

    public void setSettlementApi(SettlementApi settlementApi) {
        this.settlementApi = settlementApi;
    }

    public Gson getGson() {
        return gson;
    }

    public void setGson(Gson gson) {
        this.gson = gson;
    }
}
