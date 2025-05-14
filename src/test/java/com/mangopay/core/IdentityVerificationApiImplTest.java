package com.mangopay.core;

import com.mangopay.entities.IdentityVerification;
import com.mangopay.entities.UserNatural;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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

    @Test
    public void getAllIdentityVerificationsForUser() throws Exception {
        UserNatural user = getJohn();
        List<IdentityVerification> fetched = getApi().getIdentityVerificationApi().getAll(user.getId(), null);
        assertNotNull(fetched);
        assertFalse(fetched.isEmpty());
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
