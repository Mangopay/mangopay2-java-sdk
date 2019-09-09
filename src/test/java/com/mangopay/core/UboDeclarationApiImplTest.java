package com.mangopay.core;

import com.mangopay.core.enumerations.CountryIso;
import com.mangopay.core.enumerations.UboDeclarationStatus;
import com.mangopay.entities.Ubo;
import com.mangopay.entities.UboDeclaration;
import com.mangopay.entities.UserLegal;
import org.junit.Test;

import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * UboDeclarationApiImpl test methods.
 */
public class UboDeclarationApiImplTest extends BaseTest {

    @Test
    public void createUboDeclaration() throws Exception {
        UboDeclaration uboDeclaration=this.getMatrixUboDeclaration();

        assertNotNull(uboDeclaration);
        assertEquals(UboDeclarationStatus.CREATED,uboDeclaration.getStatus());
        assertNotNull(uboDeclaration.getId());
    }

    @Test
    public void getUboDeclarationList() throws Exception {
        UboDeclaration uboDeclaration=this.getMatrixUboDeclaration();
        UserLegal matrix=this.getMatrix();
        List<UboDeclaration> declarations=this.api.getUboDeclarationApi().getAll(matrix.getId(),null,null);

        assertNotNull(declarations);
        assertTrue(!declarations.isEmpty());
        assertEquals(1,declarations.size());
        assertEquals(uboDeclaration.getId(),declarations.get(0).getId());
    }

    @Test
    public void getUboDeclaration() throws Exception {
        UboDeclaration uboDeclaration=this.getMatrixUboDeclaration();
        UserLegal matrix=this.getMatrix();

        UboDeclaration declarationFromApi=this.api.getUboDeclarationApi().get(matrix.getId(),uboDeclaration.getId());

        assertNotNull(declarationFromApi);
        assertEquals(uboDeclaration.getId(),declarationFromApi.getId());
    }

    @Test
    public void createUbo() throws Exception {
        Ubo ubo=this.createNewUboForMatrix();
        UserLegal matrix = this.getMatrix();
        UboDeclaration uboDeclaration = this.getMatrixUboDeclaration();
        Ubo newUbo = api.getUboDeclarationApi().createUbo(matrix.getId(), uboDeclaration.getId(), ubo);

        assertNotNull(newUbo);
        assertNotNull(newUbo.getId());
        assertEquals(ubo.getFirstName(),newUbo.getFirstName());
        assertEquals(ubo.getLastName(), newUbo.getLastName());
        assertEquals(ubo.getAddress().getAddressLine1(), newUbo.getAddress().getAddressLine1());
        assertEquals(ubo.getNationality(), newUbo.getNationality());
        assertEquals(ubo.getBirthday(),newUbo.getBirthday());
        assertEquals(ubo.getBirthplace().getCity(), newUbo.getBirthplace().getCity());
    }

    @Test
    public void updateUbo() throws Exception {
        UserLegal matrix=this.getMatrix();
        UboDeclaration uboDeclaration=this.getMatrixUboDeclaration();
        Calendar calendar=Calendar.getInstance();
        calendar.set(1991,12,21,0,0,0);

        Ubo toBeUpdated = this.getMatrixUbo();
        toBeUpdated.setFirstName("UpdatedFirstName");
        toBeUpdated.setLastName("UpdatedLastName");
        toBeUpdated.getAddress().setAddressLine1("UpdatedLine1");
        toBeUpdated.setNationality(CountryIso.GB);
        toBeUpdated.setBirthday(calendar.getTimeInMillis()/1000);
        toBeUpdated.getBirthplace().setCountry(CountryIso.GB);

        Ubo ubo=this.api.getUboDeclarationApi().updateUbo(matrix.getId(),uboDeclaration.getId(),toBeUpdated);

        assertEquals(toBeUpdated.getFirstName(),ubo.getFirstName());
        assertEquals(toBeUpdated.getLastName(),ubo.getLastName());
        assertEquals(toBeUpdated.getAddress().getAddressLine1(), ubo.getAddress().getAddressLine1());
        assertEquals(toBeUpdated.getNationality(),ubo.getNationality());
        assertEquals(toBeUpdated.getBirthday(),ubo.getBirthday());
        assertEquals(toBeUpdated.getBirthplace().getCity(), ubo.getBirthplace().getCity());
    }

    @Test
    public void getUbo() throws Exception {
        UserLegal matrix=this.getMatrix();
        UboDeclaration uboDeclaration=this.getMatrixUboDeclaration();
        Ubo existingUbo=this.getMatrixUbo();

        UboDeclaration declaration=this.api.getUboDeclarationApi().get(matrix.getId(),uboDeclaration.getId());

        Ubo fetchedUbo=this.api.getUboDeclarationApi().getUbo(matrix.getId(),uboDeclaration.getId(),existingUbo.getId());

        assertNotNull(fetchedUbo);
        assertEquals(existingUbo.getFirstName(),fetchedUbo.getFirstName());
        assertEquals(existingUbo.getLastName(),fetchedUbo.getLastName());
        assertEquals(existingUbo.getAddress().getAddressLine1(), fetchedUbo.getAddress().getAddressLine1());
        assertEquals(existingUbo.getNationality(),fetchedUbo.getNationality());
        assertEquals(existingUbo.getBirthday(), fetchedUbo.getBirthday());
        assertEquals(existingUbo.getBirthplace().getCity(), fetchedUbo.getBirthplace().getCity());
    }
}
