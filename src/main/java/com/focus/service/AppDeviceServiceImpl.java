package com.focus.service;

import com.focus.model.App;
import com.focus.model.AppDevice;
import com.focus.model.BlockPeriod;
import com.focus.model.Device;
import com.focus.repository.AppDeviceRepository;
import com.focus.repository.AppRepository;
import com.focus.repository.BlockPeriodRepository;
import com.focus.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppDeviceServiceImpl implements AppDeviceService {
    @Autowired
    AppDeviceRepository appDeviceRepository;
    @Autowired
    DeviceRepository deviceRepository;

    @Autowired
    AppRepository appRepository;

    @Autowired
    BlockPeriodRepository blockPeriodRepository;

    public AppDevice save(AppDevice appDevices) {
        App appFound = appRepository.findById(appDevices.getApp().getId()).get();
        BlockPeriod blockPeriodFound = blockPeriodRepository.findById(appDevices.getBlock_period().getId()).get();
        Device deviceFound = deviceRepository.findById(appDevices.getDevice().getId()).get();

        AppDevice newAppDevices = new AppDevice(deviceFound,appFound,blockPeriodFound);
        AppDevice savedAppDevices = appDeviceRepository.save(newAppDevices);
        return savedAppDevices;

    }
}
