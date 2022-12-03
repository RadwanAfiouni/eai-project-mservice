package com.eai.person;

import com.eai.Connector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @Mock
    private Connector connector;


    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository, connector);
    }

    @Test
    void fetchAllPersons() {
        personService.fetchAllPersons();
        verify(personRepository).findAll();
    }

    @Test
    void fetchPersonById() {
        personService.fetchPersonById(1L);
        verify(personRepository).findById(1L);
    }

    @Test
    void savePerson() {
        when(connector.createIfNotExists(any())).thenReturn(true);
        personService.savePerson(new Person());
        verify(personRepository).save(any());
    }

    @Test
    void fetchPersonsByGroupId() {
        personService.fetchPersonsByGroupId(1L);
        verify(personRepository).findByGroupId(1L);
    }
}