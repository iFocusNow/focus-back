package com.focus.service;

import com.focus.dto.DeviceDTO;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    public List<DeviceDTO> getAllDevices(UUID child_id);
}
