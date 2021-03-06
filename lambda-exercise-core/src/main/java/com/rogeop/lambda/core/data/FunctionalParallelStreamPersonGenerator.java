package com.rogeop.lambda.core.data;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;
import com.rogeop.lambda.core.model.Address;
import com.rogeop.lambda.core.model.AddressType;
import com.rogeop.lambda.core.model.Gender;
import com.rogeop.lambda.core.model.Person;

import it.unimi.dsi.util.XoRoShiRo128PlusRandom;

/**
 * @author Robert Pepersack
 */
public class FunctionalParallelStreamPersonGenerator {

    private final XoRoShiRo128PlusRandom prng = new XoRoShiRo128PlusRandom();
    private final Faker faker = new Faker(new Locale("en-US"));;
    private final AtomicInteger addressId = new AtomicInteger(1);

    private final DoublePredicate percent = percent -> prng.nextDoubleFast() <= percent;

    private final Consumer<Person> addresses = person -> {
        person.setAddresses(IntStream.rangeClosed(1, prng.nextInt(3) + 1)
                .mapToObj(numAddr -> Address.builder().addressId(addressId.getAndIncrement())
                        .street1(faker.address().streetAddress()).city(faker.address().city())
                        .state(faker.address().stateAbbr()).zipCode(faker.address().zipCode())
                        .addressType(AddressType.values[numAddr - 1]).address())
                .collect(Collectors.toCollection(ArrayList::new)));
    };

    private final Function<Integer, List<Person>> persons = num -> {
        List<Person> persons = IntStream.rangeClosed(1, num).parallel().mapToObj(personId -> Person.builder()
                .personId(personId).firstName(faker.name().firstName()).middleName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .suffix(percent.test(0.10d) ? faker.options().option("Sr.", "Jr.", "I", "II", "III", "IV", "V") : null)
                .birthDate(faker.date().birthday(1, 100).toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                .gender(Enum.valueOf(Gender.class, faker.demographic().sex().toUpperCase()))
                .ssn(faker.idNumber().ssnValid()).email(faker.internet().emailAddress())
                .homeOwner(percent.test(0.50d) ? true : false)
                .ipAddress(percent.test(0.70d) ? faker.internet().ipV4Address() : null)
                .dog(percent.test(0.40d) ? faker.dog().breed() : null).person()).peek(addresses)
                .collect(Collectors.toCollection(ArrayList::new));

        return persons;
    };

}