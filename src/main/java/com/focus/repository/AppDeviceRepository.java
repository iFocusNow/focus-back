package com.focus.repository;

import com.focus.model.AppDevice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AppDeviceRepository extends JpaRepository<AppDevice, UUID> {
    @Query(value = "SELECT * FROM app_devices WHERE device_id = ?1", nativeQuery = true)
    List<AppDevice> findAllByDevice(UUID device_id);

    @Query(value = "SELECT * FROM app_devices WHERE device_id = ?1 AND app_id = ?2", nativeQuery = true)
    List<AppDevice> findByDeviceAndApp(UUID device_id, UUID app_id);
}
