package com.focus.controller;

import com.focus.model.Device;
import com.focus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    DeviceService deviceService;
    @GetMapping("/devices/id/{id}")
    public ResponseEntity<List<Device>> getDeviceById(@PathVariable("id")UUID id){
        List<Device> device = deviceService.getDeviceByChildID(id);
        return new ResponseEntity<List<Device>>(device, HttpStatus.OK);

    }
}
