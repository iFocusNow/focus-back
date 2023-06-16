package com.focus.controller;

import com.focus.dto.ChildDeviceDTO;
import com.focus.dto.ChildEditDTO;
import com.focus.model.Child;
import com.focus.model.Device;
import com.focus.model.Parent;
import com.focus.service.ChildService;
import com.focus.service.DeviceService;
import com.focus.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ChildController {
    @Autowired
    private ChildService childService;
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ParentService parentService;
    @PutMapping("/edit/child/{child_id}")
    public ResponseEntity<ChildEditDTO> updateChild (@PathVariable("child_id") UUID child_id, @RequestBody ChildDeviceDTO child) {
        Child newChild = childService.listById(child_id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        if (child.getName()!=null) {
            newChild.setName(child.getName());
        };

        // Update timestamp in child
        newChild.setUpdated_at(timestamp);

        List<Device> devices = deviceService.getDevices(child_id);
        List<Device> newDevices = child.getDevices();

        // Update child's devices list
        for (Device updates: newDevices){
            for (Device existing: devices){
                if(existing.getId().equals(updates.getId())){
                    existing.setBrand(updates.getBrand());
                    break;
                }
            }
        }

        // Replace old devices with updated devices
        List<UUID> updatedDeviceIds = new ArrayList<>();
        for (Device updatedDevice : child.getDevices()) {
            updatedDeviceIds.add(updatedDevice.getId());
        }

        // Delete devices that are not in the updated list
        for (Device existingDevice : devices) {
            if (!updatedDeviceIds.contains(existingDevice.getId())) {
                deviceService.delete(existingDevice.getId(), true);
            }
        }

        // Save the updated Child
        Child updateChild = childService.save(newChild);

        // Get the updated Child with DTO
        ChildEditDTO childEditDTO =childService.listChildDTO(updateChild.getId());

        return new ResponseEntity<>(childEditDTO, HttpStatus.OK);
    }

    @PostMapping("/add/child/{parent_id}")
    public ResponseEntity<Boolean> addChild(@PathVariable("parent_id") UUID parent_id, @RequestBody Child child) {
        boolean response;
        //C
        if (!child.getName().isEmpty() || !child.getName().isBlank()) {
            Parent parent = parentService.getById(parent_id);
            //save child
            Child newChild = childService.saveNew(child,parent);
            //save devices
            for (Device de : child.getDevices()) {
                de.setChild(newChild);
                deviceService.save(de);
            }

            //Check if it was inserted correctly
            if (newChild != null && newChild.getId() != null && newChild.getName() != null ) {
                // child was successfully inserted into the database
                ChildEditDTO childEditDTO = childService.listChildDTO(newChild.getId());
                response=true;
                return new ResponseEntity<>(response, HttpStatus.CREATED);
            } else {
                // Error inserting child into database or missing name
                response=false;
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            //ChildEditDTO childEditDTO = childService.listChildDTO(newChild.getId());
            //return new ResponseEntity<>(childEditDTO,HttpStatus.CREATED);
        }
        else{
            response=false;
            return new ResponseEntity<>(response,HttpStatus.OK);
        }
    }

}
