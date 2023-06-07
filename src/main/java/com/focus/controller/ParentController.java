package com.focus.controller;

import com.focus.dto.ParentAccountDTO;
import com.focus.dto.ParentAuthDTO;
import com.focus.dto.ParentDTO;
import com.focus.dto.ChildDTO;
import com.focus.model.Parent;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ParentController {

    private final ParentService service;

    @Autowired
    public ParentController(ParentService service) {
        this.service = service;
    }
    @PostMapping("/parents/register-parent")
    public ResponseEntity<Parent> registerParent(@RequestBody Parent parent) {
        try {
            Parent registeredParent = service.registerParent(parent);
            return new ResponseEntity<>(registeredParent, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/parents/authenticate-parent")
    public ResponseEntity<String> authenticateParent(@RequestBody ParentAuthDTO parentAuthDTO) {
        boolean authenticated = service.authenticateParent(parentAuthDTO.getEmail(), parentAuthDTO.getPassword());
        if (authenticated) {
            return ResponseEntity.ok("Authentication successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }

    // Test api
    @GetMapping("/parents")
    public ResponseEntity<List<ParentDTO>> getAllParents() {
        List<ParentDTO> parentDTOs = service.getAllParents();
        return new ResponseEntity<>(parentDTOs, HttpStatus.OK);
    }

    @GetMapping("/parents/{parentId}")
    public ResponseEntity<ParentAccountDTO> getParent(@PathVariable UUID parentId) {
        ParentAccountDTO parentDTO = service.getParentById(parentId);
        return new ResponseEntity<>(parentDTO, HttpStatus.OK);
    }

    @GetMapping("/children/{parentId}")
    public ResponseEntity<List<ChildDTO>> getParentChildren(@PathVariable UUID parentId) {
        List<ChildDTO> childrenDTOs = service.getParentChildren(parentId);
        return new ResponseEntity<>(childrenDTOs, HttpStatus.OK);
    }

}
