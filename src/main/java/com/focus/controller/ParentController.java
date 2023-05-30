package com.focus.controller;


import com.focus.model.Parent;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ParentController {
    @Autowired
    private ParentService service;
    @GetMapping("/parents")
    public ResponseEntity <List<Parent>> getAllParents() {
        List<Parent> parents = service.getAllParents();
        return new ResponseEntity<List<Parent>>(parents, HttpStatus.OK);
    }
    @PostMapping("/register-parent")
    public ResponseEntity<Parent> registerParent(@RequestBody Parent parent) {
        Parent registeredParent = service.registerParent(parent);
        return new ResponseEntity<>(registeredParent, HttpStatus.CREATED);
    }
}
