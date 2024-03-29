package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ParentAdminDTO {
    private UUID id;
    private String last_name_mother;
    private String last_name_father;
    private Timestamp created_at;
    private Timestamp updated_at;
    private boolean isEnabled;
}
