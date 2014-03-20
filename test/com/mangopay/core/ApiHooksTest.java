package com.mangopay.core;

import com.mangopay.entities.*;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * ApiHooks test methods.
 */
public class ApiHooksTest extends BaseTest {
    
    @Test
    public void test_Hooks_Create() {
        try {
            Hook hook = this.getJohnsHook();
            assertTrue(hook.Id.length() > 0);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_Hooks_Get() {
        try {
            Hook hook = this.getJohnsHook();
            Hook getHook = this._api.Hooks.get(hook.Id);
            
            assertEquals(getHook.Id, hook.Id);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_Hooks_Update() {
        try {
            Hook hook = this.getJohnsHook();
            hook.Url = "http://test123.com";
            
            Hook saveHook = this._api.Hooks.update(hook);
            
            assertEquals(saveHook.Id, hook.Id);
            assertEquals(saveHook.Url, "http://test123.com");
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
    @Test
    public void test_Hooks_All() {
        try {
            Hook hook = this.getJohnsHook();
            Pagination pagination = new Pagination(1, 1);
            
            List<Hook> list = this._api.Hooks.getAll(pagination);
            
            assertTrue(list.get(0) instanceof Hook);
            assertEquals(hook.Id, list.get(0).Id);
            assertEquals(pagination.Page, 1);
            assertEquals(pagination.ItemsPerPage, 1);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
    
}
