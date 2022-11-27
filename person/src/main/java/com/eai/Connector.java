package com.eai;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Connector {

    RestTemplate restTemplate;

    public Connector(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Boolean createIfNotExists(Long groupId) {
        return restTemplate.getForObject("http://GRADING/api/v1/group/exists/" + groupId, Boolean.class);
    }

}
