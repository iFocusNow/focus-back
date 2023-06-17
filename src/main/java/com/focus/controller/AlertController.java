package com.focus.controller;

import com.focus.dto.AlertDTO;
import com.focus.service.AlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AlertController {

    private final AlertService alertService;

    public AlertController(AlertService alertService) {
        this.alertService = alertService;
    }

    @GetMapping("/alerts/get/{childId}")
    public ResponseEntity<List<AlertDTO>> getChildAlerts(@PathVariable UUID childId) {
        List<AlertDTO> alertDTOs = alertService.getChildAlerts(childId);
        return new ResponseEntity<>(alertDTOs, HttpStatus.OK);
    }
}
