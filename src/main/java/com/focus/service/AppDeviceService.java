package com.focus.service;

import com.focus.dto.AppDeviceDTO;

import java.util.List;
import java.util.UUID;

public interface AppDeviceService {
    public List<AppDeviceDTO> getAllAppDevices(UUID device_id);
}
