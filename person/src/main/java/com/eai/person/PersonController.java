package com.eai.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Person>> getAllPersons() {
        return new ResponseEntity<>(personService.fetchAllPersons(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Optional<Person>> getPersonById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(personService.fetchPersonById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Person> postPerson(@RequestBody PersonModel personModel) {
        Person person = Person.builder()
                .groupId(personModel.getGroupId())
                .firstName(personModel.getFirstName())
                .lastName(personModel.getLastName())
                .email(personModel.getEmail())
                .build();
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.OK);
    }

}
