package com.datinko.prototype.datagenerator.core;

import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.joda.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.joda.ser.LocalDateTimeSerializer;
import org.joda.money.Money;
import org.joda.time.DateTime;

/**
 * Representation of a bet placed by a customer.
 */
public class Bet {

    protected final UUID id;
    protected final DateTime timestamp;
    protected final Customer customer;
    protected final Location location;
    protected Selection selection;
    protected final Money stake;

    public UUID getId() {
        return id;
    }

    public DateTime getTimestamp() {
        return timestamp;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Location getLocation() {
        return location;
    }

    public Selection getSelection() {
        return selection;
    }

    public Money getStake() {
        return stake;
    }


    private Bet(Builder builder) {
        id = builder.id;
        timestamp = builder.timestamp;
        customer = builder.customer;
        location = builder.location;
        selection = builder.selection;
        stake = builder.stake;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Bet copy) {
        Builder builder = new Builder();
        builder.id = copy.id;
        builder.timestamp = copy.timestamp;
        builder.customer = copy.customer;
        builder.location = copy.location;
        builder.selection = copy.selection;
        builder.stake = copy.stake;
        return builder;
    }

    public static final class Builder {
        private UUID id;
        private DateTime timestamp;
        private Customer customer;
        private Location location;
        private Selection selection;
        private Money stake;

        private Builder() {
        }

        public Builder withId(UUID val) {
            id = val;
            return this;
        }

        public Builder withTimestamp(DateTime val) {
            timestamp = val;
            return this;
        }

        public Builder withCustomer(Customer val) {
            customer = val;
            return this;
        }

        public Builder withLocation(Location val) {
            location = val;
            return this;
        }

        public Builder withSelection(Selection val) {
            selection = val;
            return this;
        }

        public Bet build() {
            return new Bet(this);
        }

        public Builder withStake(Money val) {
            stake = val;
            return this;
        }
    }

    //should implement a copy method so we can update properties?


}
