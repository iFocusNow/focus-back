package com.focus.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class DTODeviceSummary {
    private UUID id;
    private String brand;
    private String type;
    private UUID child_id;
}
