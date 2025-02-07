package com.mangopay.core;

import com.mangopay.entities.IdentityVerification;
import com.mangopay.entities.UserNatural;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IdentityVerificationApiImplTest extends BaseTest {

    @Test
    public void createIdentityVerification() throws Exception {
        UserNatural user = this.getJohn();
        IdentityVerification createObject = new IdentityVerification().setReturnUrl("https://example.com");
        IdentityVerification identityVerification = this.getApi().getIdentityVerificationApi()
            .create(createObject, user.getId());

        assertNotNull(identityVerification);
        assertNotNull(identityVerification.getHostedUrl());
        assertNotNull(identityVerification.getReturnUrl());
        assertEquals("PENDING", identityVerification.getStatus());
    }
}
