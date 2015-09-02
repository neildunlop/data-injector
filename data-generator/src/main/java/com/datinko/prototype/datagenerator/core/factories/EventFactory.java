package com.datinko.prototype.datagenerator.core.factories;

import java.util.UUID;

import com.datinko.prototype.datagenerator.core.Event;

/**
 * Created by neild on 26/08/2015.
 */
public class EventFactory {

    public static Event getMiddlesbroughVsNewcastle() {

        UUID id = UUID.fromString("709da48e-9bfa-4255-afda-bb00725958d8");
        String name = "Middlesbrough Vs Newcastle";

        Event event = Event.newBuilder()
                .withId(id)
                .withName(name)
                .build();

        return event;
    }
}
