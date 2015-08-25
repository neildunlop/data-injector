package com.datinko.prototype.datagenerator.core.factories;

import com.datinko.prototype.datagenerator.core.ChannelType;
import com.datinko.prototype.datagenerator.core.Location;

import java.util.UUID;

/**
 * Created by Neil on 25/08/2015.
 */
public class LocationFactory {


    public static Location getWHLeedsMerrion() {

        UUID id = UUID.fromString("ccdc8e20-d0ae-4afe-a638-1cd8416a08f7");
        String address = "Saint John Street, Merrion St, Leeds LS2 8LQ";
        ChannelType channelType = ChannelType.RETAIL;

        Location location = Location.newBuilder()
                .withId(id)
                .withAddress(address)
                .withChannel(channelType)
                .build();

        return location;
    }

    public static Location getWHLeedsBoarLane() {

        UUID id = UUID.fromString("");
        String address = "23 Boar Ln, Leeds, West Yorkshire LS1 6EA";
        ChannelType channelType = ChannelType.RETAIL;

        Location location = Location.newBuilder()
                .withId(id)
                .withAddress(address)
                .withChannel(channelType)
                .build();

        return location;
    }

    public static Location getWHLeedsStreetLane() {

        UUID id = UUID.fromString("");
        String address = "81 Street Ln, Leeds, West Yorkshire LS8 1AP";
        ChannelType channelType = ChannelType.RETAIL;

        Location location = Location.newBuilder()
                .withId(id)
                .withAddress(address)
                .withChannel(channelType)
                .build();

        return location;
    }

    public static Location getWHLeedsCrossgates() {

        UUID id = UUID.fromString("");
        String address = "H-K Crossgates Shopping Centre, Leeds LS15 8EU";
        ChannelType channelType = ChannelType.RETAIL;

        Location location = Location.newBuilder()
                .withId(id)
                .withAddress(address)
                .withChannel(channelType)
                .build();

        return location;
    }

    public static Location getWHLeedsPrimroseLane() {

        UUID id = UUID.fromString("");
        String address = "1 Primrose Lane, Halton, Leeds LS15 7HS";
        ChannelType channelType = ChannelType.RETAIL;

        Location location = Location.newBuilder()
                .withId(id)
                .withAddress(address)
                .withChannel(channelType)
                .build();

        return location;
    }

    //TODO: Add Internet Anonymous Location
    //TODO: Add Mobile Anonymous Location
    //TODO: Add user specific internet locations (for some)
    //TODO: Add user specific mobile locations (for some)
}
