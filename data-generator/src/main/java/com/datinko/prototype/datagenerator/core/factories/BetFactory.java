package com.datinko.prototype.datagenerator.core.factories;

import com.datinko.prototype.datagenerator.core.Bet;
import com.datinko.prototype.datagenerator.core.Customer;
import com.datinko.prototype.datagenerator.core.Location;
import com.datinko.prototype.datagenerator.core.Selection;
import org.joda.money.Money;
import org.joda.time.DateTime;

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
        Money testStake = Money.parse("GBP 10.00");

        Bet bet = Bet.newBuilder()
                .withId(id)
                .withTimestamp(DateTime.now().minusHours(1))
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .build();

        return bet;
    }

    public static Bet getBet2() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getAmyBrown();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake = Money.parse("GBP 20.00");

        Bet bet = Bet.newBuilder()
                .withId(id)
                .withTimestamp(DateTime.now().plusSeconds(5))
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .build();

        return bet;
    }

    public static Bet getBet3() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getColinBladen();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake = Money.parse("GBP 2.00");

        Bet bet = Bet.newBuilder()
                .withId(id)
                .withTimestamp(DateTime.now().plusSeconds(8))
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .build();

        return bet;
    }

}
