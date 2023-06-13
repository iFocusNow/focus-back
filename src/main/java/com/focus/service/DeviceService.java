package com.focus.service;

import com.focus.dto.DeviceDTO;
import com.focus.model.Child;
import com.focus.model.Device;

import java.util.List;
import java.util.UUID;

public interface DeviceService {
    public List<DeviceDTO> getAllDevices(UUID child_id);
    public List<Device> getDevices(UUID child_id);
    public Device save(Device device, Child child);
    public void delete(UUID id, boolean forced);
}
