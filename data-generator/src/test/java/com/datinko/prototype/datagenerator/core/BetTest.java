package com.datinko.prototype.datagenerator.core;

import com.datinko.prototype.datagenerator.core.factories.CustomerFactory;
import com.datinko.prototype.datagenerator.core.factories.LocationFactory;
import com.datinko.prototype.datagenerator.core.factories.SelectionFactory;
import com.datinko.prototype.datagenerator.core.serializer.MoneyDeserializer;
import com.datinko.prototype.datagenerator.core.serializer.MoneySerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import junit.framework.TestCase;
import org.joda.money.Money;
import org.joda.time.DateTime;
import org.junit.Test;

import java.util.UUID;

import static junit.framework.Assert.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Tests to confirm the Bet class functions as expected.
 */
public class BetTest {

    @Test
    public void canCreateBet() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getBobSmith();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake = Money.parse("GBP 20");
        DateTime timestamp = DateTime.now();

        Bet testBet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .withTimestamp(timestamp)
                .build();

        assertNotNull(testBet);
        assertEquals(id, testBet.getId());
        assertEquals(testCustomer, testBet.getCustomer());
        assertEquals(testLocation, testBet.getLocation());
        assertEquals(testSelection, testBet.getSelection());
        assertEquals(testStake, testBet.getStake());
        assertEquals(timestamp, testBet.getTimestamp());
    }

    @Test
    public void canModifyAnExistingBet() {

        UUID id = UUID.randomUUID();
        Customer testCustomer = CustomerFactory.getBobSmith();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake1 = Money.parse("GBP 20");
        Money testStake2 = Money.parse("GBP 30");
        DateTime timestamp = DateTime.now();

        Bet testBet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake1)
                .withTimestamp(timestamp)
                .build();

        assertNotNull(testBet);
        assertEquals(id, testBet.getId());
        assertEquals(testCustomer, testBet.getCustomer());
        assertEquals(testLocation, testBet.getLocation());
        assertEquals(testSelection, testBet.getSelection());
        assertEquals(testStake1, testBet.getStake());
        assertEquals(timestamp, testBet.getTimestamp());

        //here.. this is how you update the selection for a Bet (should be called from the 'addBet' method for a selection.
        Bet updatedBet = Bet.newBuilder(testBet)
                .withStake(testStake2)
                .build();

        assertNotNull(updatedBet);
        assertEquals(id, updatedBet.getId());
        assertEquals(testCustomer, updatedBet.getCustomer());
        assertEquals(testLocation, updatedBet.getLocation());
        assertEquals(testSelection, updatedBet.getSelection());
        assertEquals(testStake2, updatedBet.getStake());
        assertEquals(timestamp, updatedBet.getTimestamp());
    }

    @Test
    public void canSerializeBet() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JodaModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Money.class, new MoneyDeserializer());
        module.addSerializer(Money.class, new MoneySerializer());
        mapper.registerModule(module);


        String expectedJson = "{\"id\":\"c84a7630-8e06-4996-8adb-a2632dd2aa9e\",\"timestamp\":\"2015-09-04T23:07:08.030Z\",\"customer\":{\"id\":\"caff853f-3a50-412c-a5fa-23551c22b3fd\",\"name\":\"Bob Smith\"},\"location\":{\"id\":\"ccdc8e20-d0ae-4afe-a638-1cd8416a08f7\",\"address\":\"Saint John Street, Merrion St, Leeds LS2 8LQ\",\"channel\":\"RETAIL\"},\"selection\":{\"id\":\"5bc5be63-de7e-4304-bb56-bebbda60c060\",\"selectionValue\":\"Middlesbrough\",\"price\":\"2/1\",\"market\":{\"id\":\"6bc5be74-af9e-4405-cc56-bebbda60c061\",\"name\":\"To Win\",\"event\":{\"id\":\"709da48e-9bfa-4255-afda-bb00725958d8\",\"name\":\"Middlesbrough Vs Newcastle\"}}},\"stake\":\"GBP 20.00\"}";

        UUID id = UUID.fromString("c84a7630-8e06-4996-8adb-a2632dd2aa9e");
        Customer testCustomer = CustomerFactory.getBobSmith();
        Location testLocation = LocationFactory.getWHLeedsMerrion();
        Selection testSelection = SelectionFactory.getMiddlesbroughToWin();
        Money testStake = Money.parse("GBP 20");
        DateTime timestamp = DateTime.now();

        Bet testBet = Bet.newBuilder()
                .withId(id)
                .withCustomer(testCustomer)
                .withLocation(testLocation)
                .withSelection(testSelection)
                .withStake(testStake)
                .withTimestamp(timestamp)
                .build();

        String result = mapper.writeValueAsString(testBet);

        assertNotNull(result);
        assertEquals(expectedJson, result);

    }

}
