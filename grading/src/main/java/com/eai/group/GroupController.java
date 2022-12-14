package com.eai.group;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/group")
public class GroupController {
    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Group>> getAllGroups() {
        return new ResponseEntity<>(groupService.fetchAllGroups(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PopulatedGroup> getGroupById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(groupService.getPopulatedGroup(id), HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    public ResponseEntity<Group> saveGroup(@RequestBody GroupModel groupModel) {
        return new ResponseEntity<>(groupService.saveGroup(Group.builder().id(groupModel.getId()).build()), HttpStatus.OK);
    }

    @GetMapping(path = "/exists/{id}")
    public ResponseEntity<Boolean> createIfNotExists(@PathVariable("id") Long id) {
        return new ResponseEntity<>(groupService.createIfNotExists(id), HttpStatus.OK);
    }

}
