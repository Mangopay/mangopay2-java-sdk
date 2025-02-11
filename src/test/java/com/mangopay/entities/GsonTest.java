package com.mangopay.entities;

import com.mangopay.core.BaseTest;
import com.mangopay.core.enumerations.CardInfoType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class GsonTest extends BaseTest {
    @Test
    public void testSerializeCardInfoType() {
        CardInfoType type = CardInfoType.CHARGE_CARD;
        String json = getApi().getGson().toJson(type);
        assertEquals("\"CHARGE CARD\"", json);

        type = null;
        json = getApi().getGson().toJson(type);
        assertEquals("null", json);
    }

    @Test
    public void testDeserializeCardInfoType() {
        String jsonInput = "\"CHARGE CARD\"";
        CardInfoType deserialized = getApi().getGson().fromJson(jsonInput, CardInfoType.class);
        assertEquals(CardInfoType.CHARGE_CARD, deserialized);

        jsonInput = "null";
        deserialized = getApi().getGson().fromJson(jsonInput, CardInfoType.class);
        assertNull(deserialized);
    }
}
