package com.rogeop.lambda.core.filter;

import static org.apache.commons.lang3.StringUtils.startsWithIgnoreCase;
import static org.apache.commons.lang3.StringUtils.trim;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.rogeop.lambda.core.model.Person;
import com.rogeop.lambda.core.model.PersonCriteria;

/**
 * PersonFilter filters a list of Person objects in parallel using specified
 * PersonCriteria
 *
 * @author Robert Pepersack
 * @version 1.0
 */
public class ParallelPersonFilter implements CriteriaFilter<Person, PersonCriteria> {

    @Override
    public List<Person> filter(List<Person> data, PersonCriteria criteria) {
        List<Predicate<Person>> predicates = new ArrayList<>();

        criteria.getFirstName().ifPresent(s -> predicates.add(p -> startsWithIgnoreCase(trim(p.getFirstName()), s)));

        criteria.getMiddleName().ifPresent(s -> predicates.add(p -> startsWithIgnoreCase(trim(p.getMiddleName()), s)));

        criteria.getLastName().ifPresent(s -> predicates.add(p -> startsWithIgnoreCase(trim(p.getLastName()), s)));

        criteria.getFromBirthDate().ifPresent(d -> predicates.add(p -> !d.isAfter(p.getBirthDate())));

        criteria.getToBirthDate().ifPresent(d -> predicates.add(p -> !d.isBefore(p.getBirthDate())));

        criteria.getGender().ifPresent(g -> predicates.add(p -> p.getGender().equals(g)));

        criteria.isHomeOwner().ifPresent(h -> predicates.add(p -> p.isHomeOwner().equals(h)));

        criteria.getSsn().ifPresent(s -> predicates.add(p -> startsWithIgnoreCase(trim(p.getSsn()), s)));

        criteria.getDog().ifPresent(s -> predicates.add(p -> startsWithIgnoreCase(trim(p.getDog()), s)));

        List<Person> results = data.parallelStream().filter(predicates.stream().reduce(i -> true, Predicate::and))
                .collect(Collectors.toList());

        return results;
    }

}