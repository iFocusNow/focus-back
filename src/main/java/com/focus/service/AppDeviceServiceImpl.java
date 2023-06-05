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
            AppDeviceDTO appDeviceDTO = new AppDeviceDTO(
                    appDevice.getId(),
                    appDevice.getApp().getId(),
                    appDevice.getApp().getLogo_url(),
                    appDevice.getApp().getName(),
                    appDevice.getBlock_period().getId(),
                    appDevice.getBlock_period().getIs_monday(),
                    appDevice.getBlock_period().getIs_tuesday(),
                    appDevice.getBlock_period().getIs_wednesday(),
                    appDevice.getBlock_period().getIs_thursday(),
                    appDevice.getBlock_period().getIs_friday(),
                    appDevice.getBlock_period().getIs_saturday(),
                    appDevice.getBlock_period().getIs_sunday()

            );
            appDeviceDTOs.add(appDeviceDTO);
        }
        return appDeviceDTOs;
    }
}
