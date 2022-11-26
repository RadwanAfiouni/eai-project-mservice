package com.eai.person;


import com.eai.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    private final Connector connector;

    @Autowired
    public PersonService(PersonRepository personRepository, Connector connector) {
        this.personRepository = personRepository;
        this.connector = connector;
    }

    public List<Person> fetchAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> fetchPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {

        connector.createIfNotExists(person.getGroupId());

        if (person.getRole() == null) {
            person.setRole(Roles.STUDENT);
        }

        return personRepository.save(person);
    }

    public List<Person> fetchPersonsByGroupId(Long id) {
        return personRepository.findByGroupId(id);
    }

}
