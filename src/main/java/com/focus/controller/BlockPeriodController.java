package com.focus.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.focus.model.BlockPeriod;
import com.focus.service.BlockPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BlockPeriodController {
    @Autowired
    BlockPeriodService blockPeriodService;

    @PostMapping("/blockperiod")
    public ResponseEntity<BlockPeriod> createBlockPeriod(@RequestBody BlockPeriod blockPeriod) {
        BlockPeriod savedBlockPeriod = blockPeriodService.save(blockPeriod);
        return new ResponseEntity<BlockPeriod>(savedBlockPeriod, HttpStatus.CREATED);
    }

    @GetMapping("/blockperiods")
    public ResponseEntity<List<BlockPeriod>> getAllBlockPeriods() {
        List<BlockPeriod> blockPeriods = blockPeriodService.listAll();
        return new ResponseEntity<List<BlockPeriod>>(blockPeriods, HttpStatus.OK);
    }

}
