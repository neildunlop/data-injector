package com.datinko.prototype.datagenerator.core;

import org.junit.Test;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Tests to confirm the Selection class behaves as expected.
 */
public class SelectionTest {

    @Test
    public void canCreateSelection() {

        UUID id = UUID.randomUUID();
        String event = "Middlesbrough Vs Leeds";
        String market = "To Win";
        String selection = "Middlesbrough";
        String price = "2/1";

        Selection testSelection = Selection.newBuilder()
                .withId(id)
                .withEvent(event)
                .withMarket(market)
                .withSelection(selection)
                .withPrice(price)
                .build();

        assertNotNull(testSelection);
        assertEquals(id, testSelection.getId());
        assertEquals(event, testSelection.getEvent());
        assertEquals(market, testSelection.getMarket());
        assertEquals(selection, testSelection.getSelection());
        assertEquals(price, testSelection.getPrice());
    }

}
