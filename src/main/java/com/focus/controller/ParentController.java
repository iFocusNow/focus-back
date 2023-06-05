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
    public ResponseEntity<Parent> getParent(@PathVariable UUID parentId) {
        Parent parent = service.getParentById(parentId);
        return new ResponseEntity<>(parent, HttpStatus.OK);
    }

    @GetMapping("/parents/{parentId}/children")
    public ResponseEntity<List<Child>> getParentChildren(@PathVariable UUID parentId) {
        List<Child> children = service.getChildrenByParentId(parentId);
        return new ResponseEntity<>(children, HttpStatus.OK);
    }
    @GetMapping("/parents/{parentId}/notifications")
    public ResponseEntity<List<Alert>> getParentNotifications(@PathVariable UUID parentId) {
        List<Alert> notifications = service.getNotificationsByParentId(parentId);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
}
