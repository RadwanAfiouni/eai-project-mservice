package com.eai.assessment.mongo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MongoAssessmentService {

    private final MongoAssessmentRepository mongoAssessmentRepository;

    public void save(MongoAssessment mongoAssessment) {
        mongoAssessmentRepository.save(mongoAssessment);
    }


}
