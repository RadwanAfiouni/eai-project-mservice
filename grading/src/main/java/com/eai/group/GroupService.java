package com.eai.group;

import com.eai.connectors.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {
    private final GroupRepository groupRepository;
    private final Connector connector;

    @Autowired
    public GroupService(GroupRepository groupRepository, Connector connector) {
        this.groupRepository = groupRepository;
        this.connector = connector;
    }

    public List<Group> fetchAllGroups() {
        return groupRepository.findAll();
    }

    public Group saveGroup(Group group) {
        group.setName("Group " + group.getId());
        return groupRepository.save(group);
    }

    public Optional<Group> fetchGroupById(Long id) {
        return groupRepository.findById(id);
    }

    public boolean createIfNotExists(Long id) {
        if (groupRepository.existsById(id)) {
            return true;
        } else {
            saveGroup(Group.builder().id(id).build());
            return false;
        }
    }

    public PopulatedGroup getPopulatedGroup(Long groupId) {
        Group group = fetchGroupById(groupId).orElseThrow(() -> new IllegalStateException("Group with id " + groupId + " does not exist."));

        return PopulatedGroup.builder()
                .id(groupId)
                .name(group.getName())
                .persons(connector.getPersonsByGroupId(groupId))
                .advisorAssessment(group.getAdvisorAssessment())
                .finalPresentation(group.getFinalPresentation())
                .finalReport(group.getFinalReport())
                .oralProposal(group.getOralProposal())
                .progress(group.getProgress())
                .build();

    }
}
