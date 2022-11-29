package com.eai.assessment.mongo;

import com.eai.assessment.Assessment;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/assessments")
@AllArgsConstructor
public class MongoAssessmentController {

    private final MongoAssessmentService mongoAssessmentService;

    @PostMapping("/save")
    public void saveAssessment(@RequestBody MongoAssessment mongoAssessment) {
        mongoAssessmentService.save(mongoAssessment);
    }

    @GetMapping("/get/{id}")
    public MongoAssessment getAssessment(@PathVariable String id) {
        return mongoAssessmentService.get(id);
    }

    @GetMapping("/get/byEvaluatorId/{evaluatorId}")
    public List<MongoAssessment> getAssessmentByEvaluatorId(@PathVariable Long evaluatorId) {
        return mongoAssessmentService.getByEvaluatorId(evaluatorId);
    }

    @GetMapping("/get/filter")
    public PopulatedAssessment getAssessmentByGroupIdAndAssessmentId(@RequestParam Long groupId, @RequestParam Assessment assessment) {
        return mongoAssessmentService.getByGroupIdAndAssessment(groupId, assessment);
    }

}
