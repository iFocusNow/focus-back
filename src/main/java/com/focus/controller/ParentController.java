package com.focus.controller;

import com.focus.dto.*;
import com.focus.model.Parent;
import com.focus.model.User;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ParentController {
    private final ParentService service;

    @Autowired
    public ParentController(ParentService service) {
        this.service = service;
    }
    @PostMapping("/session/register-parent")
    public ResponseEntity<?> registerParent(@RequestBody ParentUserDTO parentUser) {
        try {
            Boolean registeredParent = service.registerParent(parentUser);
            return new ResponseEntity<>(registeredParent, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            String errorMessage = "An error occurred: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PostMapping("/session/authenticate-parent")
    public ResponseEntity<?> authenticateParent(@RequestBody ParentAuthDTO parentAuthDTO) {
        try {
            Boolean authenticatedParent = service.authenticateParent(parentAuthDTO.getEmail(), parentAuthDTO.getPassword());
            return new ResponseEntity<>(authenticatedParent, HttpStatus.OK);
        } catch (RuntimeException e) {
            String errorMessage = "An error occurred: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
        }
    }

    @PutMapping("/session/toggle-enable/{parent_id}")
    public ResponseEntity<Boolean> toggleEnableUser(@PathVariable("parent_id") UUID parent_id) {
        boolean response;
        if (parent_id != null) {
            response = service.enableUser(parent_id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/session/admin-parents")
    public ResponseEntity<List<ParentAdminDTO>> getAdminParents() {
        List<ParentAdminDTO> parentAdminDTOS = service.getAllParentAdmin();
        return new ResponseEntity<>(parentAdminDTOS, HttpStatus.OK);
    }

    // Test api
    @GetMapping("/parents")
    public ResponseEntity<List<ParentDTO>> getAllParents() {
        List<ParentDTO> parentDTOs = service.getAllParents();
        return new ResponseEntity<>(parentDTOs, HttpStatus.OK);
    }

    @GetMapping("/parent")
    public ResponseEntity<ParentAccountDTO> getParent(@RequestParam("email") String email) {
        ParentAccountDTO parentDTO = service.getParent(email);
        return new ResponseEntity<>(parentDTO, HttpStatus.OK);
    }

}
