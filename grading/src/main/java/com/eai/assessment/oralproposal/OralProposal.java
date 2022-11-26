package com.eai.assessment.oralproposal;

import com.eai.assessment.Level;
import com.eai.group.Group;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "oral_proposal")
public class OralProposal {
    @Id
    @Column(name = "group_id")
    private Long id;
    private Long evaluatorId;

    @JsonManagedReference(value = "oral-proposal-group")
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "group_id")
    private Group group;

    private Date lastUpdated;

    private Level criteria1;
    private Level criteria2;
    private Level criteria3;
    private Level criteria4;
    private Level criteria5;
    private Level criteria6;
    private Level criteria7;
    private Level criteria8;



}
