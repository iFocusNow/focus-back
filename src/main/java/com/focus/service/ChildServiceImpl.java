package com.focus.service;

import com.focus.dto.ChildDTO;
import com.focus.dto.ChildEditDTO;
import com.focus.dto.DeviceDTO;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
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
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ChildServiceImpl implements ChildService{
    @Autowired
    private ChildRepository childRepository;
    @Autowired
    private DeviceRepository deviceRepository;
    @Autowired
    private  ParentRepository parentRepository;

    @Transactional
    public Child save(Child child) {
        try {
            Child newChild = childRepository.save(child);
            return newChild;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }
    public Child saveNew(Child child, Parent parent) {
        try {
            child.setParent(parent);
            //update times
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            child.setCreated_at(timestamp);
            child.setUpdated_at(timestamp);
            //obtaining code child
            String number = String.format("%03d", childRepository.count());
            child.setChild_code("C" + number);
            Child newChild = childRepository.save(child);
            return newChild;
        } catch (Exception e) {
            throw new ResolutionException("Internal server error", e);
        }
    }

    public Child listById(UUID id){
        try {
            Child child = childRepository.findById(id).get();
            if (child == null) {
                throw new ResourceNotFoundException("Child not found with id: " + id);
            }
            return child;
        }catch (Exception e){
            throw new ResolutionException("Internal server error", e);
        }
    }

    public ChildEditDTO listChildDTO(UUID id) {
        try {
            Child child = childRepository.findById(id).get();
            if (child == null) {
                throw new ResourceNotFoundException("Child not found");
            }
            List<Device> devices = deviceRepository.findAllByChild(id);
            if (devices == null) {
                throw new ResourceNotFoundException("Devices not found with child id: " + id);
            }
            List<DeviceDTO> deviceDTOs = new ArrayList<>();

            for (Device device : devices) {
                DeviceDTO deviceDTO = new DeviceDTO(
                        device.getId(),
                        device.getChild().getId(),
                        device.getType(),
                        device.getBrand()
                );
                deviceDTOs.add(deviceDTO);
            }
            ChildEditDTO childEditDTO = new ChildEditDTO(child.getName(), child.getParent().getPhoto_url(), deviceDTOs);


            return childEditDTO;

        } catch (Exception e) {
            throw new ResolutionException("Internal server error", e);
        }
    }
    public long countChild() {
        try {
            return childRepository.count();
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error", e);
        }
    }

    public List<ChildDTO> getParentChildren(UUID parentId) {
        try {
            List<Child> children = childRepository.findAllByParentId(parentId);
            if (children == null) {
                throw new ResourceNotFoundException("Children not found with parent id: " + parentId);
            }
            List<ChildDTO> childrenDTOs = new ArrayList<>();
            for (Child child : children) {
                ChildDTO childDTO = new ChildDTO(
                        child.getId(),
                        child.getName()
                );
                childrenDTOs.add(childDTO);
            }
            return childrenDTOs;
        } catch (Exception e) {
            throw new ResolutionException("Internal server error", e);
        }
    }


}
