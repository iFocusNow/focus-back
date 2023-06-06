package com.focus.service;

import com.focus.dto.AppDeviceDTO;
import com.focus.model.App;
import com.focus.model.AppDevice;

import java.util.List;
import java.util.UUID;

public interface AppDeviceService {
    public List<AppDeviceDTO> getAllAppDevices(UUID device_id);
    public boolean deleteAppDevice(UUID device_id, UUID app_id);

    public boolean save(AppDevice appDevice);
}
