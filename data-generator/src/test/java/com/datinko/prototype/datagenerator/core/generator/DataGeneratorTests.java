package com.datinko.prototype.datagenerator.core.generator;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

/**
 * Created by Neil on 05/09/2015.
 */
public class DataGeneratorTests {

    @Test
    public void canGenerateRandomBetsForKnownEvents() throws JsonProcessingException {

        DataGenerator generator = new DataGenerator();

        generator.generateTotallyRandomBets(2000, 500, 10000);

    }

    @Test
    public void canGeneratePsuedoRandomBetsForKnownEvents() throws JsonProcessingException {

        DataGenerator generator = new DataGenerator();

        generator.generatePseudoRandomBets(2000, 500, 10000);

    }


}
