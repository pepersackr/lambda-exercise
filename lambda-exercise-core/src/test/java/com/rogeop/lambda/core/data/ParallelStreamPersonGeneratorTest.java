package com.rogeop.lambda.core.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.rogeop.lambda.core.model.Person;

/**
 * @author Robert Pepersack
 */
public class ParallelStreamPersonGeneratorTest {

    @Test
    public void testGenerate10Persons() {
        IDataGenerator<Person> generator = new ParallelStreamPersonGenerator();
        List<Person> persons = generator.generate(10);
        assertEquals(10, persons.size());
    }

    @Test
    public void testGenerate100KPersons() {
        IDataGenerator<Person> generator = new ParallelStreamPersonGenerator();
        List<Person> persons = generator.generate(100000);
        assertEquals(100000, persons.size());
    }

    @Test
    public void testTimerDecoratorGenerate100KPersons() {
        IDataGenerator<Person> generator = new TimerPersonGenerator(new ParallelStreamPersonGenerator());
        List<Person> persons = generator.generate(100000);
        assertEquals(100000, persons.size());
    }

}