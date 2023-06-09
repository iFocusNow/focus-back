package com.focus.controller;

import com.focus.dto.ChildDeviceDTO;
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
    @PutMapping("/edit/child/{child_id}")
    public ResponseEntity<ChildEditDTO> updateChild (@PathVariable("child_id") UUID child_id, @RequestBody ChildDeviceDTO child){
        Child newChild = childService.listById(child_id);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        /*if (child.getDevices()!=null) {
            newchild.setDevices(child.getDevices());
        };*/

        List<Device> devices = deviceService.getDevices(child_id);
        List<Device> newDevices = child.getDevices();

        for (Device update: newDevices){
            Device existingDevice = devices.stream().filter(d->d.getId().equals(update.getId())).findFirst().orElse(null);
            if(existingDevice!= null){

            }
            else{
                deviceService.
            }
        }
        if (child.getName()!=null) {
            //throw exception
        };


        Child updateChild = new Child(
                newChild.getParent(),
                child.getName(),
                newChild.getChild_code(),
                newChild.getCreated_at(),
                timestamp,
                newChild.getAlerts(),


        );

       // Child updateChild = childService.save(newChild);
        ChildEditDTO childEditDTO =childService.listChildDTO(updateChild.getId());

        return new ResponseEntity<>(childEditDTO, HttpStatus.OK);
    }
}
