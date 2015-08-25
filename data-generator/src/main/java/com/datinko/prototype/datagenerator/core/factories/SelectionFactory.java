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

    public static Selection getLeedsToWin() {

        UUID id = UUID.fromString("3b10cbc1-d79c-4186-b60e-39c6462f2374");
        String event = "Middlesbrough Vs Leeds";
        String market = "To Win";
        String selection = "Leeds";
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

    public static Selection getMiddlesbroughLeedsToDraw() {

        UUID id = UUID.fromString("baa7be95-be7c-4755-a828-e5334050558d");
        String event = "Middlesbrough Vs Leeds";
        String market = "To Draw";
        String selection = "";
        String price = "3/4";

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
