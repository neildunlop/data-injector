package com.datinko.prototype.datagenerator.core;

import java.util.UUID;

/**
 * Simple representation of what the customer bet on.
 */
public class Selection {

    protected final UUID id;
    protected final String selection;
    protected final String market;
    protected final String event;
    protected final String price;

    public UUID getId() {
        return id;
    }

    public String getSelection() {
        return selection;
    }

    public String getMarket() {
        return market;
    }

    public String getEvent() {
        return event;
    }

    public String getPrice() {
        return price;
    }

    private Selection(Builder builder) {
        id = builder.id;
        selection = builder.selection;
        market = builder.market;
        event = builder.event;
        price = builder.price;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Selection copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.selection = copy.selection;
        builder.market = copy.market;
        builder.event = copy.event;
        builder.price = copy.price;
        return builder;
    }


    public static final class Builder {

        private UUID id;
        private String selection;
        private String market;
        private String event;
        private String price;

        private Builder() {
        }

        public Builder withId(UUID val) {
            id = val;
            return this;
        }

        public Builder withSelection(String val) {
            selection = val;
            return this;
        }

        public Builder withMarket(String val) {
            market = val;
            return this;
        }

        public Builder withEvent(String val) {
            event = val;
            return this;
        }

        public Builder withPrice(String val) {
            price = val;
            return this;
        }

        public Selection build() {
            return new Selection(this);
        }
    }
}
