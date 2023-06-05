package com.focus.controller;


import com.focus.dto.ParentAuthDTO;
import com.focus.dto.ParentDTO;
import com.focus.model.Parent;
import com.focus.repository.ParentRepository;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ParentController {
    @Autowired
    private ParentService parentService;
    @GetMapping("/parents")
    public ResponseEntity <List<ParentDTO>> getAllParents() {
        List<ParentDTO> parents = parentService.getAllParents();
        return new ResponseEntity<>(parents, HttpStatus.OK);
    }
    @PostMapping("/parents/register-parent")
    public ResponseEntity<Parent> registerParent(@RequestBody Parent parent) {
        try {
            Parent registeredParent = parentService.registerParent(parent);
            return new ResponseEntity<>(registeredParent, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/parents/authenticate-parent")
    public ResponseEntity<String> authenticateParent(@RequestBody ParentAuthDTO parentAuthDTO) {
        boolean authenticated = parentService.authenticateParent(parentAuthDTO.getEmail(), parentAuthDTO.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }
}
