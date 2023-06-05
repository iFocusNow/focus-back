package com.focus.controller;

import com.focus.dto.AppDeviceDTO;
import com.focus.service.AppDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class AppDeviceController {
    @Autowired
    private AppDeviceService appDeviceService;
    @GetMapping("/appDevices/{device_id}")
    public ResponseEntity<List<AppDeviceDTO>> getAllAppDevices(@PathVariable("device_id") UUID device_id) {
        List<AppDeviceDTO> appDevices = appDeviceService.getAllAppDevices(device_id);
        return new ResponseEntity<>(appDevices, HttpStatus.OK);
    }

    @DeleteMapping("/appDevices/{device_id}/{app_id}")
    public ResponseEntity<Boolean> deleteAppDevice(@PathVariable("device_id") UUID device_id, @PathVariable("app_id") UUID app_id) {
        boolean isDeleted = appDeviceService.deleteAppDevice(device_id, app_id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }
}
