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
    public void createHook() {
        try {
            Hook hook = this.getJohnsHook();
            assertTrue(hook.getId().length() > 0);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void getHook() {
        try {
            Hook hook = this.getJohnsHook();
            Hook getHook = this.api.getHooks().get(hook.getId());

            assertEquals(getHook.getEventType(), hook.getEventType());
            assertEquals(getHook.getId(), hook.getId());
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void updateHook() {
        try {
            Hook hook = this.getJohnsHook();
            hook.setUrl("http://test123.com");

            Hook saveHook = this.api.getHooks().update(hook);

            assertEquals(saveHook.getId(), hook.getId());
            assertEquals(saveHook.getUrl(), "http://test123.com");
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }

    @Test
    public void getHooks() {
        try {
            Hook hook = this.getJohnsHook();
            Pagination pagination = new Pagination(1, 1);

            List<Hook> list = this.api.getHooks().getAll(pagination, null);

            assertTrue(list.get(0) instanceof Hook);
            assertEquals(hook.getId(), list.get(0).getId());
            assertEquals(pagination.getPage(), 1);
            assertEquals(pagination.getItemsPerPage(), 1);
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());
        }
    }
}
