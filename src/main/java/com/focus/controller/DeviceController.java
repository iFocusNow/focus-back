package com.focus.controller;

import com.focus.dto.DeviceDTO;
import com.focus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;
    @GetMapping("/devices/{child_id}")
    public ResponseEntity<List<DeviceDTO>> getAllDevices(@PathVariable("child_id") UUID child_id) {
        List<DeviceDTO> devices = deviceService.getAllDevices(child_id);
        return new ResponseEntity<>(devices, HttpStatus.OK);
    }

}
