package com.focus.controller;

import com.focus.dto.AppDTO;
import com.focus.model.App;
import com.focus.service.AppService;
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
public class AppController {
    @Autowired
    AppService appService;

    @GetMapping("/apps")
    public ResponseEntity<List<AppDTO>> getAllApps() {
        List<AppDTO> apps = appService.listApp();
        return new ResponseEntity<List<AppDTO>>(apps,HttpStatus.OK);
    }

 }
