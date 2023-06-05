package com.focus.controller;

import com.focus.dto.ParentDTO;
import com.focus.model.Child;
import com.focus.model.Parent;
import com.focus.model.Alert;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import java.sql.Timestamp;
import java.util.Date;
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

    @GetMapping("/parents")
    public ResponseEntity<List<ParentDTO>> getAllParents() {
        List<ParentDTO> parentDTOs = service.getAllParents();
        return new ResponseEntity<>(parentDTOs, HttpStatus.OK);
    }

    @GetMapping("/parents/{parentId}")
    public ResponseEntity<ParentDTO> getParent(@PathVariable UUID parentId) {
        ParentDTO parentDTO = service.getParentById(parentId);
        return new ResponseEntity<>(parentDTO, HttpStatus.OK);
    }

    @GetMapping("/parents/{parentId}/notifications")
    public ResponseEntity<List<Alert>> getParentNotifications(@PathVariable UUID parentId) {
        List<Alert> notifications = service.getNotificationsByParentId(parentId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }

}
