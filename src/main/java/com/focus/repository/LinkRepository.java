package com.focus.repository;

import com.focus.model.AppDevice;
import com.focus.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface LinkRepository extends JpaRepository<Link, UUID> {
    @Query(value = "SELECT * FROM links WHERE device_id = ?1", nativeQuery = true)
    List<Link> findAllByDevice(UUID device_id);
}
