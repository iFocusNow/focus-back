package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class LinkCreateDTO {
    private UUID device_id;
    private String name;
    private String url;
    private Boolean is_monday;
    private Boolean is_tuesday;
    private Boolean is_wednesday;
    private Boolean is_thursday;
    private Boolean is_friday;
    private Boolean is_saturday;
    private Boolean is_sunday;
}
