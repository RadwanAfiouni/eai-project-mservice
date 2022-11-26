package com.eai.person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;


    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> fetchAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> fetchPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {


        return personRepository.save(person);
    }

}
