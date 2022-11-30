package com.eai.assessment.mongo;

import com.eai.assessment.Assessment;
import com.eai.assessment.Level;
import com.eai.group.GroupService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Service
@AllArgsConstructor
public class MongoAssessmentService {

    private final MongoAssessmentRepository mongoAssessmentRepository;
    private final GroupService groupService;

    public void save(MongoAssessment mongoAssessment) {
        mongoAssessment.setDate(new Date());
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
        AtomicReference<Long> sumGrade = new AtomicReference<>(0L);
        AtomicReference<Long> maxGrade = new AtomicReference<>(0L);
        mongoAssessments.forEach(mongoAssessment -> {
            evaluatedTopics.put(mongoAssessment.getEvaluatorId(), mongoAssessment.getEvaluatedTopics());
            maxGrade.updateAndGet(v -> v + 4L * mongoAssessment.getEvaluatedTopics().size());
            sumGrade.updateAndGet(v -> v + mongoAssessment.getEvaluatedTopics().stream().mapToLong(Level::getValue).sum());
        });

        Double averageGrade = 20.0 * ((double) sumGrade.get() / maxGrade.get());

        return PopulatedAssessment.builder()
                .group(groupService.getPopulatedGroup(groupId))
                .evaluatedTopics(evaluatedTopics)
                .assessment(assessment)
                .finalGrade(averageGrade)
                .build();
    }
}
