package com.focus.controller;

import com.focus.dto.*;
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
    public ResponseEntity<?> registerParent(@RequestBody ParentUserDTO parentUser) {
        try {
            Parent registeredParent = service.registerParent(parentUser);
            return new ResponseEntity<>(registeredParent, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            String errorMessage = "An error occurred: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
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

}
