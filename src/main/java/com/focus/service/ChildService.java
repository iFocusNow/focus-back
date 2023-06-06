package com.focus.service;

import com.focus.dto.ChildNameDTO;


import java.util.UUID;

public interface ChildService {

    public ChildNameDTO getChildName(UUID child_id);
}
