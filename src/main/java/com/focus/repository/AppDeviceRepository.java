package com.focus.repository;

import com.focus.model.AppDevice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppDeviceRepository extends JpaRepository<AppDevice, UUID> {
}
