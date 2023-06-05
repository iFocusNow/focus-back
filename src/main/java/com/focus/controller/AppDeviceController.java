package com.focus.controller;

import com.focus.model.AppDevice;
import com.focus.service.AppDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppDeviceController {
    @Autowired
    AppDeviceService appDeviceService;

    @PostMapping("/appDevice")
    public ResponseEntity<AppDevice> createAppDevices(@RequestBody AppDevice appDevices) {
        AppDevice savedAppDevices = appDeviceService.save(appDevices);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
