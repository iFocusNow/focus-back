package com.focus.controller;

import com.focus.dto.ChildDTO;
import com.focus.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @GetMapping("/children/parents/{parentId}")
    public ResponseEntity<List<ChildDTO>> getParentChildren(@PathVariable UUID parentId) {
        List<ChildDTO> childrenDTOs = childService.getParentChildren(parentId);
        return new ResponseEntity<>(childrenDTOs, HttpStatus.OK);
    }
}
