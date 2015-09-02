package com.datinko.prototype.datagenerator.core;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import java.util.UUID;

import com.datinko.prototype.datagenerator.core.factories.EventFactory;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by neild on 26/08/2015.
 */
public class MarketTest {

    @Test
    public void canCreateMarket() {

        UUID id = UUID.randomUUID();
        Event event = EventFactory.getMiddlesbroughVsNewcastle();
        String name = "To Win";

        Market testMarket = Market.newBuilder()
                .withId(id)
                .withEvent(event)
                .withName(name)
                //no selections on this one
                .build();

        assertNotNull(testMarket);
        assertEquals(id, testMarket.getId());
        assertEquals(event, testMarket.getEvent());
        assertEquals(name, testMarket.getName());

    }
}
