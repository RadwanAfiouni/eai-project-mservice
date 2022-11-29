package com.eai.assessment.mongo;

import com.eai.assessment.Assessment;
import com.eai.assessment.Level;
import com.eai.group.PopulatedGroup;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Builder
public class PopulatedAssessment {
    private PopulatedGroup group;
    private Assessment assessment;
    private Map<Long, List<Level>> evaluatedTopics;
}
