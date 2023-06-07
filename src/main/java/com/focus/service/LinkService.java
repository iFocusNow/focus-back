package com.focus.service;

import com.focus.dto.LinkBlockPeriodDTO;
import com.focus.model.Link;

import java.util.List;
import java.util.UUID;

public interface LinkService {
    public List<LinkBlockPeriodDTO> getAllLinkBlockPeriods(UUID device_id);
    public boolean deleteLink(UUID id);

    public boolean save (Link link);
}
