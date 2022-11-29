package com.eai.assessment.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoAssessmentRepository extends MongoRepository<MongoAssessment, Long> {
}
