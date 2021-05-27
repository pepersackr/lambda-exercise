package com.rogeop.lambda.core.filter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import com.rogeop.lambda.core.data.PersonJsonFileReader;
import com.rogeop.lambda.core.model.Person;
import com.rogeop.lambda.core.model.PersonCriteria;

public class PersonFilterBenchmark {

    @State(Scope.Thread)
    public static class PersonFilterState {
        public List<Person> persons;
        public PersonCriteria criteria;

        @Setup(Level.Trial)
        public void setup() {
            persons = new PersonJsonFileReader().read("/person10K.json");

            criteria = new PersonCriteria();
            criteria.setLastName("b");
            // criteria.setFirstName("c");
            criteria.setHomeOwner(Boolean.TRUE);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            criteria.setFromBirthDate(LocalDate.parse("11/27/1950", formatter));
            // criteria.setToBirthDate(LocalDate.parse("09/10/1990", formatter));
            // criteria.setDog("h");
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.All)
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void filter10KPerssons(PersonFilterState state) {
        CriteriaFilter<Person, PersonCriteria> filter = new PersonFilter();
        filter.filter(state.persons, state.criteria);
    }

}