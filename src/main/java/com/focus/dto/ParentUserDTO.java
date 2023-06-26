package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ParentUserDTO {
    private String email;
    private String password;
    private String last_name_mother;
    private String last_name_father;
    private String photo_url;
}
