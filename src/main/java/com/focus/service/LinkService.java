package com.focus.service;

import com.focus.dto.LinkBlockPeriodDTO;

import java.util.List;
import java.util.UUID;

public interface LinkService {
    public List<LinkBlockPeriodDTO> getAllLinkBlockPeriods(UUID device_id);
}
