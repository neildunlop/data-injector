package com.datinko.prototype.datagenerator.core;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * Simple representation of a Market.
 */
public class Market {

    protected final UUID id;
    protected final String name;
    protected final Event event;
    protected Collection<Selection> selections;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Event getEvent() {
        return event;
    }

    public Collection<Selection> getSelections() {
        return Collections.unmodifiableCollection(selections);
    }

    private Market(Builder builder) {
        id = builder.id;
        name = builder.name;
        event = builder.event;
        selections = builder.selections;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Market copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.event = copy.event;
        builder.selections = copy.selections;
        return builder;
    }

    public static final class Builder {
        private UUID id;
        private String name;
        private Event event;
        private Collection<Selection> selections;

        private Builder() {
        }

        public Builder withId(UUID val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withEvent(Event val) {
            event = val;
            return this;
        }

        public Builder withSelections(Collection<Selection> val) {
            selections = val;
            return this;
        }

        public Market build() {
            return new Market(this);
        }
    }
}
