package com.datinko.prototype.datagenerator.core;

import com.datinko.prototype.datagenerator.core.factories.CustomerFactory;
import com.datinko.prototype.datagenerator.core.factories.LocationFactory;
import com.datinko.prototype.datagenerator.core.factories.SelectionFactory;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Tests to confirm the Bet class functions as expected.
 */
public class BetTest {

    @Test
    public void canCreateBet() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getBobSmith();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();

        Bet testBet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .build();

        assertNotNull(testBet);
        assertEquals(id, testBet.getId());
        assertEquals(testCustomer, testBet.getCustomer());
        assertEquals(testLocation, testBet.getLocation());
        assertEquals(testSelection, testBet.getSelection());
    }

}
