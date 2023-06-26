package com.focus.controller;

import com.focus.dto.LinkBlockPeriodDTO;
import com.focus.model.Link;
import com.focus.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class LinkController {
    @Autowired
    private LinkService linkService;

    @GetMapping("/links/{device_id}")
    public ResponseEntity<List<LinkBlockPeriodDTO>> getAllLinkBlockPeriods(@PathVariable("device_id") UUID device_id) {
        List<LinkBlockPeriodDTO> linkBlockPeriods = linkService.getAllLinkBlockPeriods(device_id);
        return new ResponseEntity<>(linkBlockPeriods, HttpStatus.OK);
    }

    @DeleteMapping("/links/{id}")
    public ResponseEntity<Boolean> deleteLink(@PathVariable("id") UUID id) {
        boolean isDeleted = linkService.deleteLink(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }

    @PostMapping("/links/create")
    public ResponseEntity<Boolean> createLink(@RequestBody Link link){
        boolean isCreated = linkService.save(link);
        return new ResponseEntity<>(isCreated,HttpStatus.CREATED);
    }

}
