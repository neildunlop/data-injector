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

    public static Bet getBobSmithBetting20OnMiddlesbroughToWinFromLeedsMerrion() {
        return BetFactory.getBobSmithBetting20OnMiddlesbroughToWinFromLeedsMerrion(DateTime.now());
    }

    public static Bet getBobSmithBetting20OnMiddlesbroughToWinFromLeedsMerrion(DateTime timestamp) {

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
                .withTimestamp(timestamp)
                .build();

        return bet;
    }

    public static Bet getAmyBrownBetting10OnMiddlesbroughToWinFromLeedsMerrion() {
        return BetFactory.getAmyBrownBetting10OnMiddlesbroughToWinFromLeedsMerrion(DateTime.now());
    }

    public static Bet getAmyBrownBetting10OnMiddlesbroughToWinFromLeedsMerrion(DateTime timestamp) {

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
                .withTimestamp(timestamp)
                .build();

        return bet;
    }

    public static Bet getEveWhitworthBetting5OnMiddlesbroughToWinFromLeedsMerrion() {

        return getEveWhitworthBetting5OnMiddlesbroughToWinFromLeedsMerrion(DateTime.now());
    }

    public static Bet getEveWhitworthBetting5OnMiddlesbroughToWinFromLeedsMerrion(DateTime timestamp) {

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
                .withTimestamp(timestamp)
                .build();

        return bet;
    }

}
