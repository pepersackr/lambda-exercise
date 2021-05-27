package com.rogeop.lambda.core.data;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

import com.rogeop.lambda.core.model.Person;

/**
 * @author Robert Pepersack
 */
public class TimerPersonGenerator extends DataGeratorDecorator<Person> {

    /**
     * Constructor that accepts a data generator
     *
     * @param dataGenerator the data generator to be wrapped and timed
     */
    TimerPersonGenerator(IDataGenerator<Person> dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public List<Person> generate(int num) {
        Instant start = Instant.now();

        List<Person> persons = getDataGenerator().generate(num);

        Duration duration = Duration.between(start, Instant.now());
        System.out.println(String.format("Time to generate data: %s minutes %s.%s seconds", duration.toMinutes(),
                duration.getSeconds() % 60, duration.toMillis() % 1000));

        return persons;
    }

}