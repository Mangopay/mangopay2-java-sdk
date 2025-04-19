package com.mangopay.core;

import com.mangopay.entities.IdentityVerification;
import com.mangopay.entities.UserNatural;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

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

    @Ignore("Endpoint returns 404")
    @Test
    public void getIdentityVerificationChecks() throws Exception {
        IdentityVerificationCheck check = getApi().getIdentityVerificationApi().getChecks(identityVerification.getId());
        assertNotNull(check);
        assertEquals(identityVerification.getId(), check.getSessionId());
        assertEquals("PENDING", check.getStatus());
        assertTrue(check.getCreationDate() > 0);
        assertTrue(check.getLastUpdate() > 0);
        assertNotNull(check.getChecks());
    }

    private IdentityVerification getNewIdentityVerification() throws Exception {
        if (identityVerification == null) {
            UserNatural user = getJohn();
            IdentityVerification createObject = new IdentityVerification().setReturnUrl("https://example.com");
            createObject.setTag("Created by the Java SDK");
            identityVerification = getApi().getIdentityVerificationApi().create(createObject, user.getId());
        }
        return identityVerification;
    }
}
