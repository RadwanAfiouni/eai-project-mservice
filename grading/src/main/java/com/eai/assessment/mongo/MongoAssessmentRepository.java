package com.eai.assessment.mongo;

import com.eai.assessment.Assessment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MongoAssessmentRepository extends MongoRepository<MongoAssessment, String> {

    List<MongoAssessment> findByEvaluatorId(Long evaluatorId);

    List<MongoAssessment> findByGroupIdAndAssessment(Long groupId, Assessment assessmentId);
}
