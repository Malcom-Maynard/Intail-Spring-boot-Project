package com.example.SpringPractice.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringPractice.model.Person;
import com.example.SpringPractice.service.PersonService;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person) {

        personService.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople() {

        return personService.getAllPeople();
    }

    @GetMapping(path = "/{id}")
    public Person getPersonByID(@PathVariable("id") UUID id) {

        return personService.selectPersonById(id).orElse(null);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePersonByID(@PathVariable("id") UUID id) {

        personService.deletePersonByID(id);

    }

    @PutMapping(path = "/{id}")
    public void updatePersonByID(@PathVariable("id") UUID id, @Valid @NotBlank @NonNull @RequestBody Person person) {
        personService.updatePersonByID(id, person);

    }
}
