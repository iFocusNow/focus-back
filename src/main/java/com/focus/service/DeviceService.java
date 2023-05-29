package com.focus.service;

import com.focus.model.Device;

import java.util.List;
import java.util.UUID;


public interface DeviceService {
    public List<Device> getDeviceByChildID (UUID id);
}
