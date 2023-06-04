package com.focus.controller;

import com.focus.model.BlockPeriod;
import com.focus.service.BlockPeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
