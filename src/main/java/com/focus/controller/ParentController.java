package com.focus.controller;

import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.model.Parent;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.Date;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ParentController {
    @Autowired
    private ParentService service;

    @PostMapping("/register-parent")
    public ResponseEntity<Parent> registerParent(@RequestBody Parent parent) {
        Date currentDate = new Date();
        parent.setCreated_at(new Timestamp(currentDate.getTime()));
        parent.setUpdated_at(new Timestamp(currentDate.getTime()));

        Parent registeredParent = service.registerParent(parent);
        return new ResponseEntity<>(registeredParent, HttpStatus.CREATED);
    }

    @GetMapping("/parents")
    public ResponseEntity <List<Parent>> getAllParents() {
        List<Parent> parents = service.getAllParents();
        return new ResponseEntity<List<Parent>>(parents, HttpStatus.OK);
    }

    @GetMapping("/parents/{parentId}")
    public ResponseEntity<Parent> getParent(@PathVariable UUID parentId) {
        Parent parent = service.getParentById(parentId);
        return new ResponseEntity<>(parent, HttpStatus.OK);
    }

    @GetMapping("/parents/{parentId}/children")
    public ResponseEntity<List<Child>> getParentChildren(@PathVariable UUID parentId) {
        List<Child> children = service.getChildrenByParentId(parentId);
        return new ResponseEntity<>(children, HttpStatus.OK);
    }
}