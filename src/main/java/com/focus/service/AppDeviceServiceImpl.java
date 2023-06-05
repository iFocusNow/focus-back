package com.focus.service;

import com.focus.dto.AppDeviceDTO;
import com.focus.model.AppDevice;
import com.focus.model.BlockPeriod;
import com.focus.repository.AppDeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AppDeviceServiceImpl implements AppDeviceService {
    @Autowired
    private AppDeviceRepository repo;
    public List<AppDeviceDTO> getAllAppDevices(UUID device_id) {
        List<AppDevice> appDevices = repo.findAllByDevice(device_id);
        List<AppDeviceDTO> appDeviceDTOs = new ArrayList<>();

        for (AppDevice appDevice: appDevices) {
            BlockPeriod blockPeriod = appDevice.getBlock_period();
            AppDeviceDTO appDeviceDTO = new AppDeviceDTO(
                    appDevice.getId(),
                    appDevice.getDevice().getId(),
                    appDevice.getApp().getId(),
                    blockPeriod.getId()
            );
            appDeviceDTOs.add(appDeviceDTO);
        }
        return appDeviceDTOs;
    }
}
