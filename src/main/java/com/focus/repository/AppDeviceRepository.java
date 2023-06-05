package com.focus.repository;

import com.focus.model.AppDevices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppDeviceRepository extends JpaRepository<AppDevices, UUID> {
}
