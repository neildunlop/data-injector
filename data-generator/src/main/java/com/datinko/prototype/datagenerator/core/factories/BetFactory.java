package com.datinko.prototype.datagenerator.core.factories;

import com.datinko.prototype.datagenerator.core.Bet;
import com.datinko.prototype.datagenerator.core.Customer;
import com.datinko.prototype.datagenerator.core.Location;
import com.datinko.prototype.datagenerator.core.Selection;
import org.joda.money.Money;

import java.util.UUID;

/**
 * Created by Neil on 25/08/2015.
 */
public class BetFactory {

    public static Bet getBobSmithBetting20OnMiddlesbroughToWinFromLeedsMerrion() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getBobSmith();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake = Money.parse("GBP 20");

        Bet bet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .build();

        return bet;
    }

    public static Bet getAmyBrownBetting10OnMiddlesbroughToWinFromLeedsMerrion() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getAmyBrown();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake = Money.parse("GBP 10");

        Bet bet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .build();

        return bet;
    }

    public static Bet getEveWhitworthBetting5OnMiddlesbroughToWinFromLeedsMerrion() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getEveWhitworth();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake = Money.parse("GBP 5");

        Bet bet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .build();

        return bet;
    }

}
