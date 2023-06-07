package com.focus.service;

import com.focus.dto.ChildDTO;

import java.util.List;
import java.util.UUID;

public interface ChildService {
    List<ChildDTO> getParentChildren(UUID parentId);
}
