package com.datinko.prototype.datagenerator.core.factories;

import com.datinko.prototype.datagenerator.core.Selection;

import java.util.UUID;

/**
 * Created by Neil on 25/08/2015.
 */
public class SelectionFactory {

    public static Selection getMiddlesbroughToWin() {

        UUID id = UUID.fromString("5bc5be63-de7e-4304-bb56-bebbda60c060");
        String event = "Middlesbrough Vs Leeds";
        String market = "To Win";
        String selection = "Middlesbrough";
        String price = "2/1";

        Selection result = Selection.newBuilder()
                .withId(id)
                .withEvent(event)
                .withMarket(market)
                .withSelection(selection)
                .withPrice(price)
                .build();

        return result;
    }
}
