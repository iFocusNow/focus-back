package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AppDTO {
    private UUID id;
    private String name;
    private String logo_url;
}
