package com.datinko.prototype.datagenerator.core.factories;

import com.datinko.prototype.datagenerator.core.Market;
import com.datinko.prototype.datagenerator.core.Selection;

import java.util.UUID;

/**
 * Created by Neil on 25/08/2015.
 */
public class SelectionFactory {

    public static Selection getMiddlesbroughToWin() {

        UUID id = UUID.fromString("5bc5be63-de7e-4304-bb56-bebbda60c060");
        EventFactory.getMiddlesbroughVsNewcastle();
        Market market = MarketFactory.getToWin();
        String price = "2/1";
        String name = "Middlesbrough";

        Selection result = Selection.newBuilder()
                .withId(id)
                .withMarket(market)
                .withSelectionValue(name)
                .withPrice(price)
                .build();

        return result;
    }

    public static Selection getNewcastleToWin() {

        UUID id = UUID.fromString("3b10cbc1-d79c-4186-b60e-39c6462f2374");
        EventFactory.getMiddlesbroughVsNewcastle();
        Market market = MarketFactory.getToWin();
        String price = "2/1";
        String name = "Newcastle";

        Selection result = Selection.newBuilder()
                .withId(id)
                .withMarket(market)
                .withSelectionValue(name)
                .withPrice(price)
                .build();

        return result;
    }
}
