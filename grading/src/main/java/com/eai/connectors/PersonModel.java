package com.eai.connectors;

import lombok.Data;

@Data
public class PersonModel {
    private Long id;

    private String role;

    private String firstName;
    private String lastName;
    private String email;
}
