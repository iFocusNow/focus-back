package com.focus.service;

import com.focus.model.BlockPeriod;
import com.focus.repository.BlockPeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class BlockPeriodServiceImpl implements BlockPeriodService {
    @Autowired
    private BlockPeriodRepository repo;
    public boolean editBlockPeriod(UUID id, BlockPeriod blockPeriod) {
        Optional<BlockPeriod> optBlockPeriod = repo.findById(id);

        if(optBlockPeriod.isEmpty()) return false;

        BlockPeriod foundBlockPeriod = optBlockPeriod.get();

        foundBlockPeriod.setIs_monday(blockPeriod.getIs_monday());
        foundBlockPeriod.setIs_tuesday(blockPeriod.getIs_tuesday());
        foundBlockPeriod.setIs_wednesday(blockPeriod.getIs_wednesday());
        foundBlockPeriod.setIs_thursday(blockPeriod.getIs_thursday());
        foundBlockPeriod.setIs_friday(blockPeriod.getIs_friday());
        foundBlockPeriod.setIs_saturday(blockPeriod.getIs_saturday());
        foundBlockPeriod.setIs_sunday(blockPeriod.getIs_sunday());

        repo.save(foundBlockPeriod);
        return true;
    }

    public boolean save(BlockPeriod blockPeriod) {
        if (blockPeriod.getIs_monday() == null) return false;
        if (blockPeriod.getIs_tuesday() == null) return false;
        if (blockPeriod.getIs_wednesday() == null) return false;
        if (blockPeriod.getIs_thursday() == null) return false;
        if (blockPeriod.getIs_friday() == null) return false;
        if (blockPeriod.getIs_saturday() == null) return false;
        if (blockPeriod.getIs_sunday() == null) return false;

        BlockPeriod newBlockPeriod = new BlockPeriod(blockPeriod.getIs_monday(),
                                        blockPeriod.getIs_tuesday(),
                                        blockPeriod.getIs_wednesday(),
                                        blockPeriod.getIs_thursday(),
                                        blockPeriod.getIs_friday(),
                                        blockPeriod.getIs_saturday(),
                                        blockPeriod.getIs_sunday());
        repo.save(newBlockPeriod);
        return true;
    }
}
