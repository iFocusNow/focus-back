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

    @Transactional
    public Child save(Child child){

        Child newChild = childRepository.save(child);

        return newChild;
    }
    public Child listById(UUID id){
        Child child=childRepository.findById(id).get();

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
    public long countChild(){
        return childRepository.count();
    }
}
