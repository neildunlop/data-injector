package com.datinko.prototype.datagenerator.core.factories;

import com.datinko.prototype.datagenerator.core.Bet;
import com.datinko.prototype.datagenerator.core.Customer;
import com.datinko.prototype.datagenerator.core.Location;
import com.datinko.prototype.datagenerator.core.Selection;

import java.util.UUID;

/**
 * Created by Neil on 25/08/2015.
 */
public class BetFactory {

    public static Bet getBet1() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getBobSmith();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();

        Bet bet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .build();

        return bet;
    }

}
