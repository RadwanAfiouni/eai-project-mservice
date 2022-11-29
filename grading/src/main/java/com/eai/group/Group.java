package com.eai.group;


import com.eai.assessment.advisorassessment.AdvisorAssessment;
import com.eai.assessment.finalpresentation.FinalPresentation;
import com.eai.assessment.finalreport.FinalReport;
import com.eai.assessment.oralproposal.OralProposal;
import com.eai.assessment.progress.Progress;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "student_group")
public class Group {
    @Id
    private Long id;
    private String name;

}

