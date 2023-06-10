package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AlertDTO {
    private UUID childId;
    private UUID parenId;
    private String type;
    private Timestamp created_at;
    private Timestamp updated_at;
}
