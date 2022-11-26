package com.eai.assessment.oralproposal;


import com.eai.connectors.PersonConnector;
import com.eai.group.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class OralProposalService {
    private final OralProposalRepository oralProposalRepository;
    private final PersonConnector connector;
    private final GroupService groupService;

    @Autowired
    public OralProposalService(OralProposalRepository oralProposalRepository, PersonConnector connector, GroupService groupService) {
        this.oralProposalRepository = oralProposalRepository;
        this.connector = connector;
        this.groupService = groupService;
    }

    public OralProposal modelToEntity(OralProposalModel oralProposalModel) {
        return OralProposal.builder()
                .id(oralProposalModel.getGroupId())
                .group(groupService.fetchGroupById(oralProposalModel.getGroupId()).get())
                .evaluatorId(oralProposalModel.getEvaluatorId())
                .lastUpdated(new Date())
                .criteria1(oralProposalModel.getCriteria1())
                .criteria2(oralProposalModel.getCriteria2())
                .criteria3(oralProposalModel.getCriteria3())
                .criteria4(oralProposalModel.getCriteria4())
                .criteria5(oralProposalModel.getCriteria5())
                .criteria6(oralProposalModel.getCriteria6())
                .criteria7(oralProposalModel.getCriteria7())
                .criteria8(oralProposalModel.getCriteria8())
                .build();
    }


    public OralProposal saveOralProposal(OralProposal oralProposal) {
        return oralProposalRepository.save(oralProposal);
    }

    public Optional<OralProposal> getOralProposalById(Long id) {
        return oralProposalRepository.findById(id);
    }

    public List<OralProposal> getAllOralProposals() {
        return oralProposalRepository.findAll();
    }

}
