package com.mangopay.entities;

import com.google.gson.annotations.SerializedName;
import com.mangopay.core.*;
import com.mangopay.core.enumerations.*;
import com.mangopay.entities.subentities.BrowserInfo;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * CardValidation entity.
 */
public class CardValidation extends EntityBase {

    /**
     * The user Id of the author of the card-validation.
     */
    @SerializedName("AuthorId")
    private String authorId;

    /**
     * This is the URL where users are automatically redirected
     * after 3D secure validation (if activated).
     */
    @SerializedName("SecureModeReturnURL")
    private String secureModeReturnUrl;

    /**
     * This is the URL where to redirect users to proceed
     * to 3D secure validation.
     */
    @SerializedName("SecureModeRedirectURL")
    private String secureModeRedirectUrl;

    /**
     * Boolean. The value is 'true' if the SecureMode was used.
     */
    @SerializedName("SecureModeNeeded")
    private String secureModeNeeded;

    @SerializedName("IpAddress")
    private String ipAddress;

    @SerializedName("BrowserInfo")
    private BrowserInfo browserInfo;

    @SerializedName("Validity")
    private Validity validity;

    /**
     * The type of transaction.
     */
    @SerializedName("Type")
    private TransactionType type;

    @SerializedName("Applied3DSVersion")
    private String applied3DSVersion;

    /**
     * Status of the CardValidation.
     */
    @SerializedName("Status")
    private TransactionStatus status;

    /**
     * The CardValidation result code.
     */
    @SerializedName("ResultCode")
    private String resultCode;

    /**
     * The PreAuthorization result Message explaining the result code.
     */
    @SerializedName("ResultMessage")
    private String resultMessage;

    /**
     * Allowed values: VISA, MASTERCARD, CB, MAESTRO
     *
     * The card network to use, as chosen by the cardholder, in case of co-branded card products.
     */
    @SerializedName("PreferredCardNetwork")
    private String preferredCardNetwork;

    /**
     * The date and time at which successful authorization occurred. If authorization failed, the value is null.
     */
    @SerializedName("AuthorizationDate")
    private Long authorizationDate;

    /**
     * Information of the card
     */
    @SerializedName("CardInfo")
    private CardInfo cardInfo;

    /**
     * The mode applied for the 3DS2 protocol for CB, Visa, and Mastercard.
     * The options are:
     * DEFAULT – Requests an exemption to strong customer authentication (SCA), and thus a frictionless payment experience, if allowed by your Mangopay contract and accepted by the issuer.
     * FORCE – Requests SCA.
     * NO_CHOICE – Leaves the choice to the issuer whether to allow for a frictionless payment experience or to enforce SCA.
     */
    @SerializedName("SecureMode")
    private SecureMode secureMode = SecureMode.DEFAULT;

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage;
    }

    public String getPreferredCardNetwork() {
        return preferredCardNetwork;
    }

    public void setPreferredCardNetwork(String preferredCardNetwork) {
        this.preferredCardNetwork = preferredCardNetwork;
    }

    public Long getAuthorizationDate() {
        return authorizationDate;
    }

    public void setAuthorizationDate(Long authorizationDate) {
        this.authorizationDate = authorizationDate;
    }

    public CardInfo getCardInfo() {
        return cardInfo;
    }

    public void setCardInfo(CardInfo cardInfo) {
        this.cardInfo = cardInfo;
    }

    public BrowserInfo getBrowserInfo() {
        return browserInfo;
    }

    public CardValidation setBrowserInfo(BrowserInfo browserInfo) {
        this.browserInfo = browserInfo;
        return this;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public CardValidation setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public String getSecureModeNeeded() {
        return secureModeNeeded;
    }

    public Validity getValidity() {
        return validity;
    }

    public CardValidation setValidity(Validity validity) {
        this.validity = validity;
        return this;
    }

    public TransactionType getType() {
        return type;
    }

    public CardValidation setType(TransactionType type) {
        this.type = type;
        return this;
    }

    /**
     * Is SecureMode Needed
     *
     * @return True if is needed
     */
    public boolean isSecureModeNeeded() {
        if (ObjectTool.nonNull(secureModeNeeded)) {
            return Boolean.parseBoolean(secureModeNeeded);
        } else {
            return false;
        }
    }

    public void setSecureModeNeeded(String secureModeNeeded) {
        this.secureModeNeeded = secureModeNeeded;
    }

    public String getSecureModeRedirectUrl() {
        return secureModeRedirectUrl;
    }

    public void setSecureModeRedirectUrl(String secureModeRedirectUrl) {
        this.secureModeRedirectUrl = secureModeRedirectUrl;
    }

    public String getSecureModeReturnUrl() {
        return secureModeReturnUrl;
    }

    public void setSecureModeReturnUrl(String secureModeReturnUrl) {
        this.secureModeReturnUrl = secureModeReturnUrl;
    }

    public String getApplied3DSVersion() {  return applied3DSVersion; }

    public void setApplied3DSVersion(String applied3DSVersion) { this.applied3DSVersion = applied3DSVersion; }

    public SecureMode getSecureMode() {
        return secureMode;
    }

    public void setSecureMode(SecureMode secureMode) {
        this.secureMode = secureMode;
    }

    /**
     * Gets map which property is an object and what type of object.
     * To be overridden in child class if has any sub objects.
     *
     * @return Collection of field name-field type pairs.
     */
    @Override
    public Map<String, Type> getSubObjects() {

        HashMap<String, Type> result = new HashMap<>();

        result.put("BrowserInfo", BrowserInfo.class);

        return result;
    }

    /**
     * Gets the collection of read-only fields names.
     *
     * @return List of field names.
     */
    @Override
    public ArrayList<String> getReadOnlyProperties() {

        ArrayList<String> result = super.getReadOnlyProperties();

        result.add("Status");
        result.add("ResultCode");
        result.add("ResultMessage");

        return result;
    }
}
