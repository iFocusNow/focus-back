package com.focus.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ChildEditDTO {
    private String name;
    private String photo_url;
    private List<DeviceDTO> deviceDTOList;
}
