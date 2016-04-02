package com.mangopay.entities;

import com.mangopay.core.EntityBase;
import com.mangopay.core.enumerations.*;

/**
 * Mandate entity.
 */
public class Mandate extends EntityBase {
    
    /**
     * The bank account ID to associate this mandate against (and hence from where the payins will come from).
     */
    public String BankAccountId;

    /**
     * The type of mandate – it will be SEPA or BACS but will only be completed once the mandate has been submitted.
     */
    public MandateScheme Scheme;

    /**
     * The language to use for the confirmation web page presented to your user.
     */
    public CultureCode Culture;

    /**
     * The URL to view/download the mandate document.
     */
    public String DocumentURL;

    /**
     * The URL where you must redirect the user for them to confirm the setup of their mandate and then he will be redirected to the ReturnURL.
     */
    public String RedirectURL;

    /**
     * URL format expected.
     */
    public String ReturnURL;

    /**
     * ID of the user to which this mandate belongs.
     */
    public String UserId;

    /**
     * The status of the mandate: 
     * CREATED (the mandate has been created),
     * SUBMITTED (the mandate has been submitted to the banks and you can now do payments with this mandate),
     * ACTIVE (the mandate is active and has been accepted by the banks and/or successfully used in a payment),
     * FAILED (the mandate has failed for a variety of reasons and is no longer available for payments).
     */
    public MandateStatus Status;

    /**
     * Mandate result code.
     */
    public String ResultCode;

    /**
     * Mandate result message.
     */
    public String ResultMessage;

    /**
     * Type of mandate.
     */
    public MandateType MandateType;

    /**
     * How the mandate has been created.
     */
    public MandateExecutionType ExecutionType;
    
}
