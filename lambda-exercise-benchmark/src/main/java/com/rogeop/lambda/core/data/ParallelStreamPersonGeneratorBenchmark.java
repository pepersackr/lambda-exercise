package com.rogeop.lambda.core.data;

import java.util.List;

import org.openjdk.jmh.annotations.Benchmark;

import com.rogeop.lambda.core.model.Person;

public class ParallelStreamPersonGeneratorBenchmark {

    @Benchmark
    public void generate10Persons() {
        IDataGenerator<Person> generator = new ParallelStreamPersonGenerator();
        List<Person> persons = generator.generate(10);
    }

    @Benchmark
    public void generate100KPersons() {
        IDataGenerator<Person> generator = new ParallelStreamPersonGenerator();
        List<Person> persons = generator.generate(100000);
    }

}