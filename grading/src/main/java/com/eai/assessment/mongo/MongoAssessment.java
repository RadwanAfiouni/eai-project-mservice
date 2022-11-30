package com.eai.assessment.mongo;

import com.eai.assessment.Assessment;
import com.eai.assessment.Level;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document
public class MongoAssessment {
    @Id
    private String id;
    private Date date;
    private Long evaluatorId;
    private Long groupId;
    private List<Level> evaluatedTopics;
    private Assessment assessment;
}
