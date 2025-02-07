package com.mangopay.core.APIs.implementation;

import com.mangopay.MangoPayApi;
import com.mangopay.core.APIs.ApiBase;
import com.mangopay.core.APIs.IdentityVerificationApi;
import com.mangopay.core.IdentityVerificationCheck;
import com.mangopay.entities.IdentityVerification;

/**
 * API for Identity Verification Sessions.
 */
public class IdentityVerificationApiImpl extends ApiBase implements IdentityVerificationApi {

    /**
     * Creates new API instance.
     *
     * @param root Root/parent instance that holds the OAuthToken and Configuration instance.
     */
    public IdentityVerificationApiImpl(MangoPayApi root) {
        super(root);
    }

    @Override
    public IdentityVerification create(IdentityVerification identityVerification, String userId) throws Exception {
        return create(identityVerification, userId, null);
    }

    @Override
    public IdentityVerification create(IdentityVerification identityVerification, String userId, String idempotencyKey) throws Exception {
        return this.createObject(IdentityVerification.class, idempotencyKey, "identify_verification_create", identityVerification, userId);
    }

    @Override
    public IdentityVerification get(String id) throws Exception {
        return this.getObject(IdentityVerification.class, "identify_verification_get", id);
    }

    @Override
    public IdentityVerificationCheck getChecks(String id) throws Exception {
        return this.getObject(IdentityVerificationCheck.class, "identify_verification_checks_get", id);
    }
}
