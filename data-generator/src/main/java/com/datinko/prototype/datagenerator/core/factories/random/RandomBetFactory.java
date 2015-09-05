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

        Bet randomBet = Bet.newBuilder()
                .withCustomer(randomCustomerFactory.getRandomCustomer())
                .withId(UUID.randomUUID())
                .withLocation(randomLocationFactory.getRandomLocation())
                .withSelection(randomSelectionFactory.getRandomSelection())
                .withStake(randomStakeFactory.getRandomStake())
                .withTimestamp(DateTime.now())
                .build();

        return randomBet;
    }
}
