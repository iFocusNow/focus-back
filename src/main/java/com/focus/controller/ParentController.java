package com.focus.controller;

import com.focus.dto.*;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.service.EmailService;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ParentController {
    private final ParentService service;
    private final EmailService emailService;

    @Autowired
    public ParentController(ParentService service, EmailService emailService) {
        this.service = service;
        this.emailService = emailService;
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

    @PutMapping("/session/recover-password")
    public ResponseEntity<Boolean> recoverPassword(@RequestBody PasswordDTO passwordDTO) {
        String updatedPassword = service.updatePassword(passwordDTO);

        if (Objects.equals(updatedPassword, "")) {
            return new ResponseEntity<>(false, HttpStatus.OK);
        }

        String to = passwordDTO.getEmail();
        String subject = "Recuperación de credenciales - Focus Web";
        String text = "Esta es tu nuevo contraseña: " + updatedPassword + "\nPorfavor almacenala en un lugar seguro.";

        try {
            emailService.sendEmail(to, subject, text);
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error sending credentials email: ", e);
        }

        return new ResponseEntity<>(true, HttpStatus.OK);
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
