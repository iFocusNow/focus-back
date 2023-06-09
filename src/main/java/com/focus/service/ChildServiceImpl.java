package com.focus.service;

import com.focus.dto.ChildEditDTO;
import com.focus.dto.DeviceDTO;
import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.model.Device;
import com.focus.model.Parent;
import com.focus.repository.ChildRepository;
import com.focus.repository.DeviceRepository;
import com.focus.repository.ParentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.lang.module.ResolutionException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChildServiceImpl implements ChildService{
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private DeviceRepository deviceRepository;


   /*public ChildEditDTO editChild(UUID child_id,  List<Device> devices){
        Child child = childRepository.findById(child_id).get();
        List<DeviceDTO> deviceDTOList = new ArrayList<>();
        for (Device device: devices) {
            DeviceDTO deviceDTO = new DeviceDTO(
                    device.getId(),
                    device.getChild().getId(),
                    device.getType(),
                    device.getBrand()
            );
            deviceDTOList.add(deviceDTO);
        }
        ChildEditDTO childEditDTO = new ChildEditDTO(child.getName(), child.getParent().getPhoto_url());

        return childEditDTO;

    }*/

    @Transactional
    public Child save(Child child){
        for (Device de: child.getDevices()){
            de.setChild(null);
        }
        for (Alert a: child.getAlerts()){
            a.setChild(null);
        }
        Child newChild = childRepository.save(child);
        /*List<Device> newDevices = deviceRepository.findAllByChild(child.getId());
        List<Device> deviceList = new ArrayList<>();
        for (Device device: devices) {
            for (Device device1:newDevices){
                if(device1.getId()==device.getId()){
                    deviceList.add(device);
                }
                else{
                    deviceList.add(device1);
                }
            }

        }
        for (Device device: deviceList){
            device=deviceRepository.save(device);
        }
*/

        return newChild;
    }
    public Child listById(UUID id){
        Child child=childRepository.findById(id).get();

        for (Device de: child.getDevices()){
            de.setChild(null);
        }
        for (Alert a: child.getAlerts()){
            a.setChild(null);
        }

        return child;
    }

    public ChildEditDTO listChildDTO(UUID id) {
        Child child = childRepository.findById(id).get();
        List<Device> devices = deviceRepository.findAllByChild(id);
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
        ChildEditDTO childEditDTO = new ChildEditDTO(child.getName(),child.getParent().getPhoto_url(), deviceDTOs);


        return childEditDTO;

    }
}
