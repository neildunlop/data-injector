package com.datinko.prototype.datagenerator.core.factories.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.datinko.prototype.datagenerator.core.Customer;
import com.datinko.prototype.datagenerator.core.factories.CustomerFactory;

/**
 * Created by neild on 05/09/2015.
 */
public class RandomCustomerFactory {

    protected List<Customer> customers = new ArrayList<>();
    protected Random rand = new Random();

    public RandomCustomerFactory() {
        this.customers.add(CustomerFactory.getAmyBrown());
        this.customers.add(CustomerFactory.getBobSmith());
        this.customers.add(CustomerFactory.getColinBladen());
        this.customers.add(CustomerFactory.getEmmaGreen());
        this.customers.add(CustomerFactory.getEricSmith());
        this.customers.add(CustomerFactory.getEveWhitworth());
        this.customers.add(CustomerFactory.getPeteRose());
        this.customers.add(CustomerFactory.getSarahWhite());
        this.customers.add(CustomerFactory.getSteveJones());
        this.customers.add(CustomerFactory.getTonyGold());
    }

    public Customer getKnownRandomCustomer() {

        int index = rand.nextInt(customers.size() - 1);
        return customers.get(index);
    }

    public Customer getAnonymousCustomer() {

        return CustomerFactory.getAnonymous();
    }
}
