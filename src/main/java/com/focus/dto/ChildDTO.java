package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ChildDTO {
    private UUID id;
    private UUID parentId;
    private String name;
    private Timestamp created_at;
    private Timestamp updated_at;
}
