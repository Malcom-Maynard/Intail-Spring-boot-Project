package com.example.SpringPractice.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.example.SpringPractice.model.Person;

//Swap the Database from local to Postgres by changing the Qualifier tag at the service level
@Repository("postgres")
public class PersonDataAccessService implements PersonDao {

    @Override
    public int insertPerson(UUID id, Person Person) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public List<Person> selectPeople() {
        // TODO Auto-generated method stub
        return List.of(new Person(UUID.randomUUID(), "FROM POSTGRES DB"));
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }

    @Override
    public int deletePersonByID(UUID id) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int updatePersonByID(UUID id, Person person) {
        // TODO Auto-generated method stub
        return 0;
    }

}
