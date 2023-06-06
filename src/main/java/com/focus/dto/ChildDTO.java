package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ChildDTO {
    private UUID id;
    private UUID parentId;
    private String name;
    private String child_code;
    private Timestamp created_at;
    private Timestamp updated_at;
}
