package com.focus.service;

import com.focus.dto.DeviceDTO;
import com.focus.model.Device;
import com.focus.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceRepository repo;
    public List<DeviceDTO> getAllDevices(UUID child_id) {
        List<Device> devices = repo.findAllByChild(child_id);
        List<DeviceDTO> deviceDTOs = new ArrayList<>();

        for (Device device: devices) {
            DeviceDTO deviceDTO = new DeviceDTO(
                    device.getId(),
                    device.getChild().getId(),
                    device.getType(),
                    device.getBrand()
            );
            deviceDTOs.add(deviceDTO);
        }
        return deviceDTOs;
    }
}
