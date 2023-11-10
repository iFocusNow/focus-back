package com.focus.controller;

import com.focus.dto.AlertDTO;
import com.focus.service.AlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/alerts/{parent_id}")
    public ResponseEntity<List<AlertDTO>> getAlerts(@PathVariable UUID parent_id) {
        List<AlertDTO> alertDTOs = alertService.getAlerts(parent_id);
        return new ResponseEntity<>(alertDTOs, HttpStatus.OK);
    }
}
