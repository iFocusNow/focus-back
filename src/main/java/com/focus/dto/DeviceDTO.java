package com.focus.dto;

import com.focus.model.Device;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DeviceDTO {
    private UUID id;
    private UUID child_id;
    private Device.DeviceType type;
    private String brand;
}
