package com.datinko.prototype.datagenerator.core.factories.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.datinko.prototype.datagenerator.core.Selection;
import org.joda.money.Money;

/**
 * Created by neild on 05/09/2015.
 */
public class RandomStakeFactory {


    protected List<Money> stakes = new ArrayList<>();
    protected Random rand = new Random();

    public RandomStakeFactory() {

        stakes.add(Money.parse("GBP 1"));
        stakes.add(Money.parse("GBP 2"));
        stakes.add(Money.parse("GBP 5"));
        stakes.add(Money.parse("GBP 10"));
        stakes.add(Money.parse("GBP 15"));
        stakes.add(Money.parse("GBP 20"));
        stakes.add(Money.parse("GBP 25"));
        stakes.add(Money.parse("GBP 50"));
        stakes.add(Money.parse("GBP 100"));
        stakes.add(Money.parse("GBP 250"));
        stakes.add(Money.parse("GBP 500"));
        stakes.add(Money.parse("GBP 1000"));
        stakes.add(Money.parse("GBP 2000"));
        stakes.add(Money.parse("GBP 3000"));
        stakes.add(Money.parse("GBP 4000"));
        stakes.add(Money.parse("GBP 5000"));
        stakes.add(Money.parse("GBP 10000"));
        stakes.add(Money.parse("GBP 15000"));
        stakes.add(Money.parse("GBP 20000"));
        stakes.add(Money.parse("GBP 25000"));
        stakes.add(Money.parse("GBP 30000"));
        stakes.add(Money.parse("GBP 40000"));
        stakes.add(Money.parse("GBP 50000"));
        stakes.add(Money.parse("GBP 100000"));
        stakes.add(Money.parse("GBP 200000"));
        stakes.add(Money.parse("GBP 250000"));
        stakes.add(Money.parse("GBP 300000"));
        stakes.add(Money.parse("GBP 400000"));
        stakes.add(Money.parse("GBP 500000"));

    }

    public Money getRandomStake() {

        int index = rand.nextInt(stakes.size() - 1);
        return stakes.get(index);
    }
}
