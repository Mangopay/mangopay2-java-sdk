package com.mangopay.core;

import com.mangopay.entities.IdentityVerification;
import com.mangopay.entities.UserNatural;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class IdentityVerificationApiImplTest extends BaseTest {

    private static IdentityVerification identityVerification;

    @Before
    public void initialize() throws Exception {
        identityVerification = getNewIdentityVerification();
    }

    @Test
    public void createIdentityVerification() throws Exception {
        assertNotNull(identityVerification);
        assertNotNull(identityVerification.getHostedUrl());
        assertNotNull(identityVerification.getReturnUrl());
        assertEquals("PENDING", identityVerification.getStatus());
    }

    @Test
    public void getIdentityVerification() throws Exception {
        IdentityVerification fetched = getApi().getIdentityVerificationApi().get(identityVerification.getId());
        assertNotNull(identityVerification);
        assertEquals(identityVerification.getHostedUrl(), fetched.getHostedUrl());
        assertEquals(identityVerification.getReturnUrl(), fetched.getReturnUrl());
        assertEquals(identityVerification.getStatus(), fetched.getStatus());
    }

    private IdentityVerification getNewIdentityVerification() throws Exception {
        UserNatural user = this.getJohn();
        IdentityVerification createObject = new IdentityVerification().setReturnUrl("https://example.com");
        return this.getApi().getIdentityVerificationApi().create(createObject, user.getId());
    }
}
