package com.example.SpringPractice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.SpringPractice.model.Person;

@Repository("fakeDoa")
public class FakePersonDataAccessService implements PersonDao {
    private static ArrayList<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person Person) {
        // TODO Auto-generated method stub
        DB.add(new Person(id, Person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectPeople() {
        return DB;
    }

    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(Person -> Person.getUID().equals(id)).findFirst();

    }

    //
    public int deletePersonByID(UUID id) {

        Optional<Person> possiblePerson = selectPersonById(id);

        if (possiblePerson.isEmpty()) {
            return 0;
        }

        DB.remove(possiblePerson.get());
        return 1;

    }

    public int updatePersonByID(UUID id, Person person) {
        return selectPersonById(id).map(p -> {

            int indexOfPerson = DB.indexOf(p);

            if (indexOfPerson >= 0) {

                DB.set(indexOfPerson, new Person(id, person.getName()));
                return 1;
            }
            return 0;

        }).orElse(0);
    }

}
