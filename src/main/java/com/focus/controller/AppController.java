package com.focus.controller;

import com.focus.model.App;
import com.focus.service.AppService;
import com.focus.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class AppController {
    @Autowired
    AppService appService;
    @GetMapping("/apps")
    public ResponseEntity<List<App>> getAllApps() {
        List<App> apps = appService.listAll();
        return new ResponseEntity<List<App>>(apps, HttpStatus.OK);
    }

}
