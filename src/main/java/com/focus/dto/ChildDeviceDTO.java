package com.focus.dto;

import com.focus.model.Device;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ChildDeviceDTO {

    private UUID id;
    private String name;
    private List<Device> devices;
}
