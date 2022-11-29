package com.eai.group;

import com.eai.connectors.PersonModel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PopulatedGroup {
    private Long id;
    private String name;
    private List<PersonModel> persons;
}
