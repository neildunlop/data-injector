package com.datinko.prototype.datagenerator.core.factories.random;

/**
 * Created by neild on 05/09/2015.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.datinko.prototype.datagenerator.core.Customer;
import com.datinko.prototype.datagenerator.core.Location;
import com.datinko.prototype.datagenerator.core.factories.LocationFactory;

/**
 * Created by neild on 05/09/2015.
 */
public class RandomLocationFactory {

    protected List<Location> locations = new ArrayList<>();
    protected Random rand = new Random();

    public RandomLocationFactory() {
        this.locations.add(LocationFactory.getWHAnonymousMobile());
        this.locations.add(LocationFactory.getWHAnonymousOnline());
        this.locations.add(LocationFactory.getWHLeedsBoarLane());
        this.locations.add(LocationFactory.getWHLeedsCrossgates());
        this.locations.add(LocationFactory.getWHLeedsMerrion());
        this.locations.add(LocationFactory.getWHLeedsPrimroseLane());
        this.locations.add(LocationFactory.getWHLeedsStreetLane());
    }

    public Location getRandomLocation() {

        int index = rand.nextInt(locations.size() - 1);
        return locations.get(index);
    }
}
