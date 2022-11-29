package com.eai.assessment.mongo;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/assessments")
@AllArgsConstructor
public class MongoAssessmentController {

    private final MongoAssessmentService mongoAssessmentService;

    @PostMapping("/save")
    public void saveAssessment(@RequestBody MongoAssessment mongoAssessment) {
        mongoAssessmentService.save(mongoAssessment);
    }

}
