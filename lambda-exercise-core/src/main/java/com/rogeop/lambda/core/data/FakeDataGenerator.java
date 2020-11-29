package com.rogeop.lambda.core.data;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.rogeop.lambda.core.model.Address;
import com.rogeop.lambda.core.model.AddressType;
import com.rogeop.lambda.core.model.Gender;
import com.rogeop.lambda.core.model.Person;

import it.unimi.dsi.util.XoRoShiRo128PlusRandom;

public class FakeDataGenerator {

    private final XoRoShiRo128PlusRandom prng = new XoRoShiRo128PlusRandom();
    private final AtomicInteger addressId = new AtomicInteger(1);
    private final Faker faker = new Faker(new Locale("en-US"));

    public void generateJsonFile(int num, String file) throws IOException {
        Instant start = Instant.now();

        List<Person> persons = new ArrayList<>();
        Faker faker = new Faker(new Locale("en-US"));
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

        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Time to generate data: " + timeElapsed);

        writeFile(persons, file);
    }

    private boolean randomPercent(double percent) {
        return prng.nextDoubleFast() <= percent;
    }

    private DoublePredicate percent = percent -> prng.nextDoubleFast() <= percent;

    private Consumer<Person> addresses = person -> {
        person.setAddresses(IntStream.rangeClosed(1, prng.nextInt(3) + 1)
                .mapToObj(numAddr -> Address.builder().addressId(addressId.getAndIncrement())
                        .street1(faker.address().streetAddress()).city(faker.address().city())
                        .state(faker.address().stateAbbr()).zipCode(faker.address().zipCode())
                        .addressType(AddressType.values[numAddr - 1]).address())
                .collect(Collectors.toCollection(ArrayList::new)));
    };

    public void generateJsonFileParallelIntStream(int num, String file) throws IOException {
        Instant start = Instant.now();

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

        Duration duration = Duration.between(start, Instant.now());
        System.out.println(String.format("Time to generate data: %s minutes %s.%s seconds", duration.toMinutes(),
                duration.getSeconds() % 60, duration.toMillis() % 1000));

        writeFile(persons, file);
    }

    private void writeFile(List<Person> persons, String file) throws IOException {
        Instant start = Instant.now();

        System.out.println("Writing " + persons.size() + " Persons to JSON file...");
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(file), persons);
        // ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        // writer.writeValue(Paths.get(file).toFile(), persons);

        long timeElapsed = Duration.between(start, Instant.now()).toMillis();
        System.out.println("Time to write file: " + timeElapsed);
        System.out.println("Done!");
    }

    public static void main(String[] args) throws IOException {
        // new FakeDataGenerator().generateJsonFile(5000000,
        // "C:\\Users\\Robert\\person5000000-1.json");
        new FakeDataGenerator().generateJsonFileParallelIntStream(5000000, "C:\\Users\\Robert\\person5M.json");
    }

}