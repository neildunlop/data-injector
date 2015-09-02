package com.datinko.prototype.datagenerator.core.factories;

import java.util.UUID;

import com.datinko.prototype.datagenerator.core.Event;
import com.datinko.prototype.datagenerator.core.Market;

public class MarketFactory {

    public static Market getToWin() {

        UUID id = UUID.fromString("6bc5be74-af9e-4405-cc56-bebbda60c061");
        Event event = EventFactory.getMiddlesbroughVsNewcastle();
        String name = "To Win";

        Market result = Market.newBuilder()
                .withId(id)
                .withEvent(event)
                .withName(name)
                //no selections for now
                .build();

        return result;
    }
}
