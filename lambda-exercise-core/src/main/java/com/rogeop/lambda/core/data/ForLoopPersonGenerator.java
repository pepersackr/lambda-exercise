package com.rogeop.lambda.core.data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.javafaker.Faker;
import com.rogeop.lambda.core.model.Gender;
import com.rogeop.lambda.core.model.Person;

import it.unimi.dsi.util.XoRoShiRo128PlusRandom;

/**
 * @author Robert Pepersack
 */
public class ForLoopPersonGenerator implements DataGenerator<Person> {

    private final XoRoShiRo128PlusRandom prng;
    private final Faker faker;

    public ForLoopPersonGenerator() {
        prng = new XoRoShiRo128PlusRandom();
        faker = new Faker(new Locale("en-US"));
    }

    @Override
    public List<Person> generate(int num) {
        List<Person> persons = new ArrayList<>();
        for (int personId = 1; personId <= num; personId++) {
            String firstName = faker.name().firstName();
            String middleName = faker.name().firstName();
            String lastName = faker.name().lastName();
            String suffix = randomPercent(0.10d) ? faker.options().option("Sr.", "Jr.", "I", "II", "III", "IV", "V")
                    : null;
            LocalDate birthDate = faker.date().birthday(1, 100).toInstant().atZone(ZoneId.systemDefault())
                    .toLocalDate();
            String gender = faker.demographic().sex().toUpperCase();
            String ssn = faker.idNumber().ssnValid();
            String email = faker.internet().emailAddress();
            Boolean homeOwner = randomPercent(0.50d) ? true : false;
            String ipAddress = randomPercent(0.70d) ? faker.internet().ipV4Address() : null;
            String dog = randomPercent(0.40d) ? faker.dog().breed() : null;
            Person person = Person.builder().personId(personId).firstName(firstName).middleName(middleName)
                    .lastName(lastName).suffix(suffix).birthDate(birthDate).gender(Enum.valueOf(Gender.class, gender))
                    .ssn(ssn).email(email).homeOwner(homeOwner).ipAddress(ipAddress).dog(dog).person();
            persons.add(person);
        }
        return persons;
    }

    private boolean randomPercent(double percent) {
        return prng.nextDoubleFast() <= percent;
    }

}