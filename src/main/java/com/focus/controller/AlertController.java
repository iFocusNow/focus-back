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

    @GetMapping("/alerts/{parentId}")
    public ResponseEntity<List<AlertDTO>> getParentAlerts(@PathVariable UUID parentId) {
        List<AlertDTO> alertDTOs = alertService.getParentAlerts(parentId);
        return new ResponseEntity<>(alertDTOs, HttpStatus.OK);
    }
}
