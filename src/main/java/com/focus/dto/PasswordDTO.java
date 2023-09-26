package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PasswordDTO {
    private String email;
    private String last_name_mother;
    private String last_name_father;
}
