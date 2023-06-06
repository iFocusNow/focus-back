package com.focus.service;

import com.focus.model.BlockPeriod;
import com.focus.repository.BlockPeriodRepository;
import org.springframework.cglib.core.Block;

import java.util.UUID;

public interface BlockPeriodService {
    public boolean editBlockPeriod(UUID id, BlockPeriod blockPeriod);

    public BlockPeriod save(BlockPeriod blockPeriod);

}
