package com.datinko.prototype.datagenerator.core;

import com.datinko.prototype.datagenerator.core.factories.CustomerFactory;
import com.datinko.prototype.datagenerator.core.factories.LocationFactory;
import com.datinko.prototype.datagenerator.core.factories.SelectionFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        String expectedJson = "{\"id\":\"ebbcaa47-3f33-403e-995f-82975c768b0c\"," +
                "\"timestamp\":{\"year\":2015,\"dayOfMonth\":2,\"dayOfWeek\":3,\"era\":1,\"dayOfYear\":245,\"secondOfMinute\":3,\"millisOfSecond\":35,\"weekOfWeekyear\":36,\"yearOfCentury\":15,\"millisOfDay\":80643035,\"monthOfYear\":9,\"hourOfDay\":22,\"minuteOfHour\":24,\"yearOfEra\":2015,\"weekyear\":2015,\"centuryOfEra\":20,\"secondOfDay\":80643,\"minuteOfDay\":1344,\"millis\":1441229043035,\"zone\":{\"fixed\":false,\"uncachedZone\":{\"cachable\":true,\"fixed\":false,\"id\":\"Europe/London\"},\"id\":\"Europe/London\"},\"chronology\":{\"zone\":{\"fixed\":false,\"uncachedZone\":{\"cachable\":true,\"fixed\":false,\"id\":\"Europe/London\"},\"id\":\"Europe/London\"}},\"afterNow\":false,\"beforeNow\":true,\"equalNow\":false}," +
                "\"customer\":{\"id\":\"caff853f-3a50-412c-a5fa-23551c22b3fd\",\"name\":\"Bob Smith\"}," +
                "\"location\":{\"id\":\"ccdc8e20-d0ae-4afe-a638-1cd8416a08f7\",\"address\":\"Saint John Street, Merrion St, Leeds LS2 8LQ\"," +
                "\"channel\":\"RETAIL\"}," +
                "\"selection\":{\"id\":\"5bc5be63-de7e-4304-bb56-bebbda60c060\",\"selectionValue\":\"Middlesbrough\",\"price\":\"2/1\"," +
                "\"market\":{\"id\":\"6bc5be74-af9e-4405-cc56-bebbda60c061\",\"name\":\"To Win\"," +
                "\"event\":{\"id\":\"709da48e-9bfa-4255-afda-bb00725958d8\",\"name\":\"Middlesbrough Vs Newcastle\"," +
                "\"markets\":null}," +
                "\"selections\":null}," +
                "\"bets\":null}," +
                "\"stake\":{\"zero\":false,\"negative\":false,\"amountMajorLong\":20,\"amountMajorInt\":20,\"amountMinorLong\":2000,\"amountMinorInt\":2000,\"currencyUnit\":{\"code\":\"GBP\",\"numericCode\":826,\"decimalPlaces\":2,\"currencyCode\":\"GBP\",\"symbol\":\"£\",\"defaultFractionDigits\":2,\"numeric3Code\":\"826\",\"countryCodes\":[\"GG\",\"IM\",\"IO\",\"GB\",\"JE\",\"GS\"],\"pseudoCurrency\":false},\"scale\":2,\"amount\":20.00,\"amountMajor\":20,\"amountMinor\":2000,\"minorPart\":0,\"positive\":true,\"positiveOrZero\":true,\"negativeOrZero\":false}}";

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

        String result = mapper.writeValueAsString(testBet);

        assertNotNull(result);

        //TODO: The JSON sucks... the parent obejcts are not being set correctly
    }

}
