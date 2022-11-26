package com.eai.assessment.finalpresentation;

import com.eai.assessment.Level;
import com.eai.group.Group;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
@Table(name = "final_presentation")
public class FinalPresentation {
    @Id
    @Column(name = "group_id")
    private Long id;
    private Long evaluatorId;

    @JsonManagedReference(value = "final-presentation-group")
    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "group_id")
    private Group group;

    private Level criteria1;
    private Level criteria2;

}
