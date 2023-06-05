package com.focus.dto;

import com.focus.model.Child;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.List;

@Data
@AllArgsConstructor
public class ParentDTO {
    private UUID id;
    private String last_name_mother;
    private String last_name_father;
    private String email;
    private String photo_url;
    private String password;
    private Timestamp created_at;
    private Timestamp updated_at;
    private List<Child> children;
}
