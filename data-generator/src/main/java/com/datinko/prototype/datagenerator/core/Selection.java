package com.datinko.prototype.datagenerator.core;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

/**
 * Simple representation of what the customer bet on.
 */
public class Selection {

    protected final UUID id;
    protected final String selectionValue;
    protected final String price;
    protected final Market market;
    protected final Collection<Bet> bets;

    public UUID getId() {
        return id;
    }

    public String getSelectionValue() {
        return selectionValue;
    }

    public String getPrice() {
        return price;
    }

    public Market getMarket() {
        return market;
    }

    public Collection<Bet> getBets() {
        return Collections.unmodifiableCollection(bets);
    }

    private Selection(Builder builder) {
        id = builder.id;
        selectionValue = builder.selectionValue;
        price = builder.price;
        market = builder.market;
        bets = builder.bets;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Selection copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.selectionValue = copy.selectionValue;
        builder.price = copy.price;
        builder.market = copy.market;
        builder.bets = copy.bets;
        return builder;
    }


    public static final class Builder {
        private UUID id;
        private String selectionValue;
        private String price;
        private Market market;
        private Collection<Bet> bets;

        private Builder() {
        }

        public Builder withId(UUID val) {
            id = val;
            return this;
        }

        public Builder withName(String val) {
            selectionValue = val;
            return this;
        }

        public Builder withPrice(String val) {
            price = val;
            return this;
        }

        public Builder withMarket(Market val) {
            market = val;
            return this;
        }

        public Builder withBets(Collection<Bet> val) {
            bets = val;
            return this;
        }

        public Selection build() {
            return new Selection(this);
        }
    }
}
