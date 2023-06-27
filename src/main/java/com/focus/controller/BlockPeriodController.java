package com.focus.controller;

import com.focus.model.BlockPeriod;
import com.focus.service.BlockPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "https://ifocusnow.azurewebsites.net", allowedHeaders = "*")
@RequestMapping("/api")
public class BlockPeriodController {
    @Autowired
    private BlockPeriodService blockPeriodService;
    @PutMapping("/blockperiods/{id}")
    public ResponseEntity<Boolean> editBlockPeriod(@PathVariable UUID id, @RequestBody BlockPeriod blockPeriod) {
        boolean isEdited = blockPeriodService.editBlockPeriod(id, blockPeriod);
        return new ResponseEntity<>(isEdited, HttpStatus.OK);
    }

    @PostMapping("/blockperiods")
    public ResponseEntity<Boolean> createBlockPeriod (@RequestBody BlockPeriod blockPeriod) {
        boolean isCreated = blockPeriodService.save(blockPeriod);
        return new ResponseEntity<>(isCreated, HttpStatus.CREATED);
    }
}
