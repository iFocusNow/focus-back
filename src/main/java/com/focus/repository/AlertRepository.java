package com.focus.repository;

import com.focus.model.Alert;
import com.focus.model.AppDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, UUID> {
    @Query(value = "SELECT * FROM alerts WHERE device_id = ?1", nativeQuery = true)
    List<Alert> findAllByDevice(UUID device_id);
}
