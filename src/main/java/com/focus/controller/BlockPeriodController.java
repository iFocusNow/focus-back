package com.focus.controller;

import com.focus.model.BlockPeriod;
import com.focus.service.BlockPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class BlockPeriodController {
    @Autowired
    private BlockPeriodService blockPeriodService;
    @PutMapping("/blockPeriods/{id}")
    public boolean editBlockPeriod(@PathVariable UUID id, @RequestBody BlockPeriod blockPeriod) {
        return blockPeriodService.editBlockPeriod(id, blockPeriod);
    }
}
