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
    private UUID id;
    private UUID device_id;
    private UUID app_id;
    private UUID block_period_id;
}
