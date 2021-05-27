package com.rogeop.lambda.core.data;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.rogeop.lambda.core.model.Person;

/**
 * PersonJsonFileReader reads a List of Person objects from a specified file
 * resource on the classpath.
 *
 * @author Robert Pepersack
 */
public class PersonJsonFileReader implements IDataReader<String, List<Person>> {

    @Override
    public List<Person> read(String file) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        CollectionType typeReference = TypeFactory.defaultInstance().constructCollectionType(List.class, Person.class);

        try {
            List<Person> results = objectMapper.readValue(getClass().getResourceAsStream(file), typeReference);
            return results;
        } catch (IOException e) {
            throw new DataReaderException(e);
        }
    }

}