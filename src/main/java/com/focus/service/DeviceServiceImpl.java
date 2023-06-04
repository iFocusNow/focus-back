package com.focus.service;

import com.focus.dtos.DTODeviceSummary;
import com.focus.model.Device;
import com.focus.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DeviceServiceImpl implements DeviceService{
    @Autowired
    private DeviceRepository devicerepo;
    public List<Device> getDeviceByChildID(UUID id){

        List<Device> device;
        device = devicerepo.findByChildId(id);
        return device;
    }

    public List<DTODeviceSummary> listDeviceSummary(UUID id) {
        List<Device> deviceList = devicerepo.findAll();
        List<DTODeviceSummary> deviceSummaryList = new ArrayList<>();

        for(Device d: deviceList){
            if(d.getChild().getId().equals(id)){
                DTODeviceSummary deviceSummary = new DTODeviceSummary(d.getId(),d.getBrand(),d.getType().toString(),d.getChild().getId());
                deviceSummaryList.add(deviceSummary);
            }
        }
        return deviceSummaryList;
    }

}
