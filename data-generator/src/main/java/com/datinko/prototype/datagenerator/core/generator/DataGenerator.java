package com.datinko.prototype.datagenerator.core.generator;

import java.util.ArrayList;
import java.util.List;

import com.datinko.prototype.datagenerator.core.Bet;
import com.datinko.prototype.datagenerator.core.factories.random.RandomBetFactory;
import com.datinko.prototype.datagenerator.core.serializer.MoneyDeserializer;
import com.datinko.prototype.datagenerator.core.serializer.MoneySerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.joda.money.Money;

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

    public List<Bet> generateRandomBets(int numberOfBetsToGenerate) throws JsonProcessingException {

        List<Bet> bets = new ArrayList<>();
        for(int i=0; i<numberOfBetsToGenerate; i++) {
            Bet bet = randomBetFactory.generateRandomBet();
            bets.add(bet);
            System.out.println(mapper.writeValueAsString(bet));
        }

        return bets;
    }

}
