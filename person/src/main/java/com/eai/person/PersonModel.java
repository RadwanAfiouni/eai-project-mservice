package com.eai.person;

import lombok.Data;

@Data
public class PersonModel {
    private Long groupId;
    private Roles role;
    private String firstName;
    private String lastName;
    private String email;
}
