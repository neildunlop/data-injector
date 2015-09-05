package com.datinko.prototype.datagenerator.core.factories.random;

import java.util.UUID;

import com.datinko.prototype.datagenerator.core.Bet;
import org.joda.time.DateTime;

/**
 * Created by neild on 05/09/2015.
 */
public class RandomBetFactory {

    protected RandomCustomerFactory randomCustomerFactory = new RandomCustomerFactory();
    protected RandomLocationFactory randomLocationFactory = new RandomLocationFactory();
    protected RandomSelectionFactory randomSelectionFactory = new RandomSelectionFactory();
    protected RandomStakeFactory randomStakeFactory = new RandomStakeFactory();

    public Bet generateRandomBet() {
        return generateRandomBet(DateTime.now());
    }

    public Bet generateRandomBet(DateTime timestamp) {

        Bet randomBet = Bet.newBuilder()
                .withCustomer(randomCustomerFactory.getKnownRandomCustomer())
                .withId(UUID.randomUUID())
                .withLocation(randomLocationFactory.getRandomLocation())
                .withSelection(randomSelectionFactory.getRandomSelection())
                .withStake(randomStakeFactory.getRandomStake())
                .withTimestamp(timestamp)
                .build();

        return randomBet;
    }

    public Bet generateKnownRandomCustomerBet(DateTime timestamp) {

        Bet randomBet = Bet.newBuilder()
                .withCustomer(randomCustomerFactory.getKnownRandomCustomer())
                .withId(UUID.randomUUID())
                .withLocation(randomLocationFactory.getRandomLocation())
                .withSelection(randomSelectionFactory.getRandomSelection())
                .withStake(randomStakeFactory.getRandomStake())
                .withTimestamp(timestamp)
                .build();

        return randomBet;
    }

    public Bet generateAnonymousOnlineOrMobileRandomBet(DateTime timestamp) {

        Bet randomBet = Bet.newBuilder()
                .withCustomer(randomCustomerFactory.getAnonymousCustomer())
                .withId(UUID.randomUUID())
                .withLocation(randomLocationFactory.getRandomOnlineOrMobileLocation())
                .withSelection(randomSelectionFactory.getRandomSelection())
                .withStake(randomStakeFactory.getRandomStake())
                .withTimestamp(timestamp)
                .build();

        return randomBet;
    }

    public Bet generateAnonymousRetailRandomBet(DateTime timestamp) {

        Bet randomBet = Bet.newBuilder()
                .withCustomer(randomCustomerFactory.getAnonymousCustomer())
                .withId(UUID.randomUUID())
                .withLocation(randomLocationFactory.getRandomRetailLocation())
                .withSelection(randomSelectionFactory.getRandomSelection())
                .withStake(randomStakeFactory.getRandomStake())
                .withTimestamp(timestamp)
                .build();

        return randomBet;
    }
}
