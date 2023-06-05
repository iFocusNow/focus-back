package com.focus.controller;

import com.focus.model.AppDevices;
import com.focus.service.AppDeviceService;
import com.focus.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppDevicesController {
    @Autowired
    AppDeviceService appDeviceService;

    @PostMapping("/appDevice")
    public ResponseEntity<AppDevices> createAppDevices(@RequestBody AppDevices appDevices) {
        AppDevices savedAppDevices = appDeviceService.save(appDevices);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
