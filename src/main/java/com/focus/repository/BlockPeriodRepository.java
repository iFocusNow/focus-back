package com.focus.repository;

import com.focus.model.BlockPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BlockPeriodRepository extends JpaRepository<BlockPeriod, UUID> {
}
