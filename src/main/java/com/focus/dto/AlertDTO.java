package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AlertDTO {
    private UUID childId;
    private String childName;
    private String type;
    private String deviceBrand;
    private String deviceType;
}
