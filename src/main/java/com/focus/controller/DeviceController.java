package com.focus.controller;

import com.focus.dto.ChildEditDTO;
import com.focus.dto.DeviceDTO;
import com.focus.model.Child;
import com.focus.model.Device;
import com.focus.service.ChildService;
import com.focus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @Autowired
    private ChildService childService;
    @GetMapping("/devices/{child_id}")
    public ResponseEntity<List<DeviceDTO>> getAllDevices(@PathVariable("child_id") UUID child_id) {
        List<DeviceDTO> devices = deviceService.getAllDevices(child_id);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

    @PostMapping("/add/device/{child_id}")
    public ResponseEntity<Boolean> addDevice(@PathVariable("child_id") UUID child_id, @RequestBody Device device) {
        boolean result;
        if((!device.getBrand().isEmpty() || !device.getBrand().isBlank()) && (!device.getType().name().equals(""))) {
            Child child = childService.listById(child_id);
            //Update to updated_at

            Device newDevice = deviceService.save(device, child);
            //Check if the new device was saved successfully
           result = newDevice != null;

            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        else {
            result=false;
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }
}
