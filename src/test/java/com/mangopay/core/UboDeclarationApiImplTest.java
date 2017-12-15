package com.mangopay.core;

import com.mangopay.core.enumerations.UboDeclarationStatus;
import com.mangopay.entities.UboDeclaration;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * UboDeclarationApiImpl test methods.
 */
public class UboDeclarationApiImplTest extends BaseTest {

    @Test
    public void getUboDeclaration() throws Exception {
        UboDeclaration declaration = getCreatedUboDeclaration(false);
        UboDeclaration retrievedDeclaration = this.api.getUboDeclarationApi().get(declaration.getId());

        assertNotNull(retrievedDeclaration);
    }

    @Test
    public void updateUboDeclaration() throws Exception {
        UboDeclaration declaration = getCreatedUboDeclaration(false);
        declaration.setStatus(UboDeclarationStatus.VALIDATION_ASKED);
        UboDeclaration updatedDeclaration = this.api.getUboDeclarationApi().update(declaration);

        assertNotNull(updatedDeclaration);
        assertTrue(updatedDeclaration.getStatus() == UboDeclarationStatus.VALIDATION_ASKED);
    }
}
