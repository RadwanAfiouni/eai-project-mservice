package com.eai.assessment.mongo;

import com.eai.assessment.Assessment;
import com.eai.assessment.Level;
import com.eai.group.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class MongoAssessmentService {

    private final MongoAssessmentRepository mongoAssessmentRepository;
    private final GroupService groupService;

    public void save(MongoAssessment mongoAssessment) {
        mongoAssessmentRepository.save(mongoAssessment);
    }

    public MongoAssessment get(String id) {
        return mongoAssessmentRepository.findById(id).orElse(null);
    }

    public List<MongoAssessment> getByEvaluatorId(Long evaluatorId) {
        List<MongoAssessment> mongoAssessments = mongoAssessmentRepository.findByEvaluatorId(evaluatorId);

        if (mongoAssessments.isEmpty()) {
            throw new RuntimeException("No assessments found for evaluatorId: " + evaluatorId);
        }
        return mongoAssessments;
    }

    public PopulatedAssessment getByGroupIdAndAssessment(Long groupId, Assessment assessment) {
        List<MongoAssessment> mongoAssessments = mongoAssessmentRepository.findByGroupIdAndAssessment(groupId, assessment);

        Map<Long, List<Level>> evaluatedTopics = new HashMap<>();

        mongoAssessments.forEach(mongoAssessment -> {
            evaluatedTopics.put(mongoAssessment.getEvaluatorId(), mongoAssessment.getEvaluatedTopics());
        });

        return PopulatedAssessment.builder()
                .group(groupService.getPopulatedGroup(groupId))
                .evaluatedTopics(evaluatedTopics)
                .assessment(assessment)
                .build();

    }
}
