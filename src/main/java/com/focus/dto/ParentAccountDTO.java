package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@AllArgsConstructor
public class ParentAccountDTO {
    private UUID id;
    private String last_name_mother;
    private String last_name_father;
    private String email;
    private String photo_url;
}
