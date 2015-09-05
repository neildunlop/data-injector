package com.datinko.prototype.datagenerator.core.generator;

import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.datinko.prototype.datagenerator.core.Bet;
import com.datinko.prototype.datagenerator.core.factories.random.RandomBetFactory;
import com.datinko.prototype.datagenerator.core.serializer.MoneyDeserializer;
import com.datinko.prototype.datagenerator.core.serializer.MoneySerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.joda.money.Money;
import org.joda.time.DateTime;

/**
 * Created by neild on 05/09/2015.
 */
public class DataGenerator {

    protected ObjectMapper mapper = new ObjectMapper();
    protected RandomBetFactory randomBetFactory = new RandomBetFactory();


    public DataGenerator() {

        mapper.registerModule(new JodaModule());
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        SimpleModule module = new SimpleModule();
        module.addDeserializer(Money.class, new MoneyDeserializer());
        module.addSerializer(Money.class, new MoneySerializer());
        mapper.registerModule(module);
    }

    public List<Bet> generateTotallyRandomBets(int numberOfBetsToGenerate, int maxMsBetSpacing, int minMsBetSpacing) throws JsonProcessingException {

        Random rand = new Random();
        DateTime timestamp = DateTime.now();

        List<Bet> bets = new ArrayList<>();
        for(int i=0; i<numberOfBetsToGenerate; i++) {
            int millisecondBetSpacing = rand.nextInt(maxMsBetSpacing) + minMsBetSpacing;
            timestamp = timestamp.plusMillis(millisecondBetSpacing);
            Bet bet = randomBetFactory.generateRandomBet(timestamp);
            bets.add(bet);
            System.out.println(mapper.writeValueAsString(bet));
        }

        return bets;
    }


    public List<Bet> generatePseudoRandomBets(int numberOfBetsToGenerate, int maxMsBetSpacing, int minMsBetSpacing) throws JsonProcessingException {

        Random rand = new Random();
        DateTime timestamp = DateTime.now();

        int anonymousRetailPercentage = 60;
        int anonymousOnlineAndMobilePercentage = 85;
        int identifiedCustomer = 100;
        List<Bet> bets = new ArrayList<>();

        for(int i=0; i<numberOfBetsToGenerate; i++) {
            Bet bet = null;

            int millisecondBetSpacing = rand.nextInt(maxMsBetSpacing) + minMsBetSpacing;
            timestamp = timestamp.plusMillis(millisecondBetSpacing);

            int typeOfBet = rand.nextInt(100);
            if(typeOfBet <= anonymousRetailPercentage) {
                bet = randomBetFactory.generateAnonymousRetailRandomBet(timestamp);
            }
            else if(typeOfBet <= anonymousOnlineAndMobilePercentage) {
                bet = randomBetFactory.generateAnonymousOnlineOrMobileRandomBet(timestamp);
            }
            else if(typeOfBet <= identifiedCustomer) {
                bet = randomBetFactory.generateRandomBet(timestamp);
            }
            bets.add(bet);
            System.out.println(mapper.writeValueAsString(bet));
        }

        return bets;
    }

}
