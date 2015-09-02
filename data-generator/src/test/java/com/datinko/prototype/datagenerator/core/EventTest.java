package com.datinko.prototype.datagenerator.core;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertEquals;

import java.util.UUID;

import org.junit.Test;

/**
 * Tests to confirm the Event class behaves as expected.
 */
public class EventTest {

    @Test
    public void canCreateEvent() {

        UUID id = UUID.randomUUID();
        String name = "Middlesbrough Vs Leeds";

        Event testEvent = Event.newBuilder()
                .withId(id)
                .withName(name)
                .build();

        assertNotNull(testEvent);
        assertEquals(id, testEvent.getId());
        assertEquals(name, testEvent.getName());

    }
}
