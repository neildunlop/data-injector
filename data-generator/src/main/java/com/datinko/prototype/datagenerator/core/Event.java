package com.datinko.prototype.datagenerator.core;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * Simple representation of an Event.
 */
public class Event {

    protected final UUID id;
    protected final String name;
    protected Collection<Market> markets;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<Market> getMarkets() {
        return Collections.unmodifiableCollection(markets);
    }

    private Event(Builder builder) {
        id = builder.id;
        name = builder.name;
        markets = builder.markets;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Event copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.name = copy.name;
        builder.markets = copy.markets;
        return builder;
    }


    public static final class Builder {
        private UUID id;
        private String name;
        private Collection<Market> markets;

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

        public Builder withMarkets(Collection<Market> val) {
            markets = val;
            return this;
        }

        public Event build() {
            return new Event(this);
        }
    }
}
