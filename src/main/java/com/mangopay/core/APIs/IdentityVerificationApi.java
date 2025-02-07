package com.mangopay.core.APIs;

import com.mangopay.entities.IdentityVerification;


public interface IdentityVerificationApi {
    /**
     * Start an identity verification session and get a link for the hosted experience
     *
     * @param identityVerification The IdentityVerification object. 'ReturnUrl' is required
     * @param userId               The user id
     * @return IdentityVerification instance
     */
    IdentityVerification create(IdentityVerification identityVerification, String userId) throws Exception;

    /**
     * Start an identity verification session and get a link for the hosted experience
     *
     * @param identityVerification the IdentityVerification object. 'ReturnUrl' is required
     * @param userId               the user id
     * @param idempotencyKey       idempotency key for this request.
     * @return IdentityVerification instance
     */
    IdentityVerification create(IdentityVerification identityVerification, String userId, String idempotencyKey) throws Exception;
}
