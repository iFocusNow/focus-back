package com.focus.service;

import com.focus.model.BlockPeriod;
import com.focus.repository.BlockPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Block;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlockPeriodServiceImpl implements BlockPeriodService {
    @Autowired
    BlockPeriodRepository blockPeriodRepository;

    public BlockPeriod save(BlockPeriod blockPeriod) {
        BlockPeriod newBlockPeriod = new BlockPeriod(blockPeriod.getIs_monday(),blockPeriod.getIs_tuesday(),blockPeriod.getIs_wednesday(),blockPeriod.getIs_thursday(),blockPeriod.getIs_friday(),blockPeriod.getIs_saturday(), blockPeriod.getIs_sunday());
        BlockPeriod savedBlockPeriod = blockPeriodRepository.save(newBlockPeriod);
        return savedBlockPeriod;
    }

    public List<BlockPeriod> listAll() {
        List<BlockPeriod> blockPeriods;
        blockPeriods = blockPeriodRepository.findAll();
        return blockPeriods;
    }
}
