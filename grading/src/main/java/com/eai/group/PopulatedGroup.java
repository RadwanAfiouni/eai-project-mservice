package com.eai.group;

import com.eai.assessment.advisorassessment.AdvisorAssessment;
import com.eai.assessment.finalpresentation.FinalPresentation;
import com.eai.assessment.finalreport.FinalReport;
import com.eai.assessment.oralproposal.OralProposal;
import com.eai.assessment.progress.Progress;
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

    private AdvisorAssessment advisorAssessment;
    private FinalPresentation finalPresentation;
    private FinalReport finalReport;
    private OralProposal oralProposal;
    private Progress progress;



}
