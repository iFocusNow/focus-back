package com.focus.dto;

import com.focus.model.App;
import com.focus.model.BlockPeriod;
import com.focus.model.Device;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
public class AppDeviceDTO {
    private UUID device_id;
    private UUID app_id;
    private String logo_url;
    private String name;
    private UUID block_period_id;
    private Boolean is_monday;
    private Boolean is_tuesday;
    private Boolean is_wednesday;
    private Boolean is_thursday;
    private Boolean is_friday;
    private Boolean is_saturday;
    private Boolean is_sunday;
}
