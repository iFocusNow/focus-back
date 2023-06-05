package com.focus.service;

import com.focus.model.BlockPeriod;
import org.springframework.cglib.core.Block;

import java.util.List;

public interface BlockPeriodService {
    public BlockPeriod save(BlockPeriod blockPeriod);

    public List<BlockPeriod> listAll();
}
