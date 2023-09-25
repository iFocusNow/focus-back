package com.focus.repository;

import com.focus.model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AlertRepository extends JpaRepository<Alert, UUID> {
    @Query(value = "SELECT * FROM alerts WHERE child_id = ?1", nativeQuery = true)
    List<Alert> findAllByChild(UUID child_id);
}
