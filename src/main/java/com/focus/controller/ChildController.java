package com.focus.controller;

import com.focus.dto.ChildNameDTO;
import com.focus.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/api")
public class ChildController {
    @Autowired
    private ChildService childService;

    @GetMapping("/child/{child_id}")
    public ResponseEntity<ChildNameDTO> getNameChild (@PathVariable("child_id") UUID child_id){
        ChildNameDTO childNameDTO = childService.getChildName(child_id);

        return new ResponseEntity<>(childNameDTO, HttpStatus.OK);
    }
}
