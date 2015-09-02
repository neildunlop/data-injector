package com.datinko.prototype.datagenerator.core;

import com.datinko.prototype.datagenerator.core.factories.MarketFactory;
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
        Market market = MarketFactory.getToWin();
        String selectionValue = "Middlesbrough";
        String price = "2/1";

        Selection testSelection = Selection.newBuilder()
                .withId(id)
                .withMarket(market)
                .withName(selectionValue)
                .withPrice(price)
                .build();

        assertNotNull(testSelection);
        assertEquals(id, testSelection.getId());
        assertEquals(market, testSelection.getMarket());
        assertEquals(selectionValue, testSelection.getSelectionValue());
        assertEquals(price, testSelection.getPrice());
    }

}
