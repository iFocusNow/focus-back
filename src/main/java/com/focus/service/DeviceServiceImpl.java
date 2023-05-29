package com.focus.service;

import com.focus.model.Device;
import com.focus.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceRepository devicerepo;
    public List<Device> getDeviceByChildID(UUID id){
        System.out.println("Searching devices for child ID: " + id);
        List<Device> device;
        device = devicerepo.findByChildId(id);
        System.out.println("Searching devices for child ID: " + id);
        return device;
    }
}
