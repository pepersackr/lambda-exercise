package com.rogeop.lambda.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

/**
 * Person is a model class that contains a person's information
 *
 * @author Robert Pepersack
 * @version 1.0
 */
public class Person implements Serializable {

    private static final long serialVersionUID = 3116121050705943772L;

    private int personId;

    private String firstName;

    private String middleName;

    private String lastName;

    private String suffix;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate birthDate;

    private Gender gender;

    private String ssn;

    private String email;

    private Boolean homeOwner;

    private String ipAddress;

    private String dog;

    private List<Address> addresses;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean isHomeOwner() {
        return homeOwner;
    }

    public void setHomeOwner(Boolean homeOwner) {
        this.homeOwner = homeOwner;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDog() {
        return dog;
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses, birthDate, dog, email, firstName, gender, homeOwner, ipAddress, lastName,
                middleName, personId, ssn, suffix);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Person other = (Person) obj;
        return Objects.equals(addresses, other.addresses) && Objects.equals(birthDate, other.birthDate)
                && Objects.equals(dog, other.dog) && Objects.equals(email, other.email)
                && Objects.equals(firstName, other.firstName) && gender == other.gender
                && Objects.equals(homeOwner, other.homeOwner) && Objects.equals(ipAddress, other.ipAddress)
                && Objects.equals(lastName, other.lastName) && Objects.equals(middleName, other.middleName)
                && personId == other.personId && Objects.equals(ssn, other.ssn) && Objects.equals(suffix, other.suffix);
    }

    @Override
    public String toString() {
        return "Person [personId=" + personId + ", firstName=" + firstName + ", middleName=" + middleName
                + ", lastName=" + lastName + ", suffix=" + suffix + ", birthDate=" + birthDate + ", gender=" + gender
                + ", ssn=" + ssn + ", email=" + email + ", homeOwner=" + homeOwner + ", ipAddress=" + ipAddress
                + ", dog=" + dog + ", addresses=" + addresses + "]";
    }

    public static class PersonBuilder {

        private final Person person;

        private PersonBuilder() {
            person = new Person();
        }

        public PersonBuilder personId(Integer personId) {
            person.setPersonId(personId);
            return this;
        }

        public PersonBuilder firstName(String firstName) {
            person.setFirstName(firstName);
            return this;
        }

        public PersonBuilder middleName(String middleName) {
            person.setMiddleName(middleName);
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            person.setLastName(lastName);
            return this;
        }

        public PersonBuilder suffix(String suffix) {
            person.setSuffix(suffix);
            return this;
        }

        public PersonBuilder birthDate(LocalDate birthDate) {
            person.setBirthDate(birthDate);
            return this;
        }

        public PersonBuilder gender(Gender gender) {
            person.setGender(gender);
            return this;
        }

        public PersonBuilder ssn(String ssn) {
            person.setSsn(ssn);
            return this;
        }

        public PersonBuilder email(String email) {
            person.setEmail(email);
            return this;
        }

        public PersonBuilder homeOwner(Boolean homeOwner) {
            person.setHomeOwner(homeOwner);
            return this;
        }

        public PersonBuilder ipAddress(String ipAddress) {
            person.setIpAddress(ipAddress);
            return this;
        }

        public PersonBuilder dog(String dog) {
            person.setDog(dog);
            return this;
        }

        public PersonBuilder addresses(List<Address> addresses) {
            person.setAddresses(addresses);
            return this;
        }

        public Person person() {
            return person;
        }
    }

}