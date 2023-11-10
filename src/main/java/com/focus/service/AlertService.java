package com.focus.service;

import com.focus.dto.AlertDTO;

import java.util.List;
import java.util.UUID;

public interface AlertService {

    List<AlertDTO> getAlerts(UUID parent_id);
}
