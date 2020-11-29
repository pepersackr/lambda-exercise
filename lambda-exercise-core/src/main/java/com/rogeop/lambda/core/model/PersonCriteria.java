package com.rogeop.lambda.core.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;

/**
 * PersonCriteria is model class that has criteria for filtering Person objects
 *
 * @author Robert Pepersack
 * @version 1.0
 */
public class PersonCriteria implements Serializable {

    private static final long serialVersionUID = 1189076927986459870L;

    private String firstName;

    private String middleName;

    private String lastName;

    private LocalDate fromBirthDate;

    private LocalDate toBirthDate;

    private Gender gender;

    private String ssn;

    private Boolean homeOwner;

    private String dog;

    public Optional<String> getFirstName() {
        return getStringCriterion(firstName);
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getMiddleName() {
        return getStringCriterion(middleName);
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Optional<String> getLastName() {
        return getStringCriterion(lastName);
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Optional<LocalDate> getFromBirthDate() {
        return Optional.ofNullable(fromBirthDate);
    }

    public void setFromBirthDate(LocalDate fromBirthDate) {
        this.fromBirthDate = fromBirthDate;
    }

    public Optional<LocalDate> getToBirthDate() {
        return Optional.ofNullable(toBirthDate);
    }

    public void setToBirthDate(LocalDate toBirthDate) {
        this.toBirthDate = toBirthDate;
    }

    public Optional<Gender> getGender() {
        return Optional.ofNullable(gender);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Optional<String> getSsn() {
        return getStringCriterion(ssn);
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public Optional<Boolean> isHomeOwner() {
        return Optional.ofNullable(homeOwner);
    }

    public void setHomeOwner(Boolean homeOwner) {
        this.homeOwner = homeOwner;
    }

    public Optional<String> getDog() {
        return getStringCriterion(dog);
    }

    public void setDog(String dog) {
        this.dog = dog;
    }

    private Optional<String> getStringCriterion(String s) {
        return Optional.ofNullable(s).filter(StringUtils::isNotBlank).map(String::trim);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((dog == null) ? 0 : dog.hashCode());
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((fromBirthDate == null) ? 0 : fromBirthDate.hashCode());
        result = prime * result + ((gender == null) ? 0 : gender.hashCode());
        result = prime * result + ((homeOwner == null) ? 0 : homeOwner.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
        result = prime * result + ((ssn == null) ? 0 : ssn.hashCode());
        result = prime * result + ((toBirthDate == null) ? 0 : toBirthDate.hashCode());
        return result;
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
        PersonCriteria other = (PersonCriteria) obj;
        if (dog == null) {
            if (other.dog != null) {
                return false;
            }
        } else if (!dog.equals(other.dog)) {
            return false;
        }
        if (firstName == null) {
            if (other.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(other.firstName)) {
            return false;
        }
        if (fromBirthDate == null) {
            if (other.fromBirthDate != null) {
                return false;
            }
        } else if (!fromBirthDate.equals(other.fromBirthDate)) {
            return false;
        }
        if (gender != other.gender) {
            return false;
        }
        if (homeOwner == null) {
            if (other.homeOwner != null) {
                return false;
            }
        } else if (!homeOwner.equals(other.homeOwner)) {
            return false;
        }
        if (lastName == null) {
            if (other.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(other.lastName)) {
            return false;
        }
        if (middleName == null) {
            if (other.middleName != null) {
                return false;
            }
        } else if (!middleName.equals(other.middleName)) {
            return false;
        }
        if (ssn == null) {
            if (other.ssn != null) {
                return false;
            }
        } else if (!ssn.equals(other.ssn)) {
            return false;
        }
        if (toBirthDate == null) {
            if (other.toBirthDate != null) {
                return false;
            }
        } else if (!toBirthDate.equals(other.toBirthDate)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonCriteria [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName
                + ", fromBirthDate=" + fromBirthDate + ", toBirthDate=" + toBirthDate + ", gender=" + gender + ", ssn="
                + ssn + ", homeOwner=" + homeOwner + ", dog=" + dog + "]";
    }

}