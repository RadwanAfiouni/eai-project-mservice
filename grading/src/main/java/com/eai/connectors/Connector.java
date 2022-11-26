package com.eai.connectors;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class Connector {
    RestTemplate restTemplate;

    public Connector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<PersonModel> getPersonsByGroupId(Long groupId) {
        return restTemplate.getForObject("http://localhost:8080/api/v1/person/byGroup/" + groupId, List.class);
    }

    public PersonModel getPersonById(Long id) {
        return restTemplate.getForObject("http://localhost:8080/api/v1/person/" + id, PersonModel.class);
    }

}
