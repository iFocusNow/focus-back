package com.focus.repository;

import com.focus.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
    @Query(value = "SELECT * FROM devices d WHERE d.child_id =?1", nativeQuery = true)
    List<Device> findByChildId(UUID id);
}
