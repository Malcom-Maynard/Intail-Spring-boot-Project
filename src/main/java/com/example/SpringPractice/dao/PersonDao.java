package com.example.SpringPractice.dao;

import com.example.SpringPractice.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    int insertPerson(UUID id, Person Person);

    default int addPerson(Person person) {

        UUID ID = UUID.randomUUID();
        return insertPerson(ID, person);
    }

    List<Person> selectPeople();

    Optional<Person> selectPersonById(UUID id);

    int deletePersonByID(UUID id);

    int updatePersonByID(UUID id, Person person);

}
