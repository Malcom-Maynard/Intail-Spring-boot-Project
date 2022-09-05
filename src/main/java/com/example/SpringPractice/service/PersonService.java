package com.example.SpringPractice.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.SpringPractice.dao.PersonDao;
import com.example.SpringPractice.model.Person;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("postgres") PersonDao personDao) {

        this.personDao = personDao;
    }

    public int addPerson(Person person) {

        return personDao.addPerson(person);
    }

    public List<Person> getAllPeople() {

        return personDao.selectPeople();
    }

    public Optional<Person> selectPersonById(UUID id) {
        return personDao.selectPersonById(id);

    }

    public int deletePersonByID(UUID id) {
        return personDao.deletePersonByID(id);
    }

    public int updatePersonByID(UUID id, Person person) {

        return personDao.updatePersonByID(id, person);
    }
}
