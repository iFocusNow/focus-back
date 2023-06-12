package com.focus.service;

import com.focus.dto.ChildDTO;
import com.focus.dto.ChildEditDTO;
import com.focus.model.Child;
import com.focus.model.Device;


import java.util.List;
import java.util.UUID;

public interface ChildService {
    public Child save(Child child);
    public Child listById(UUID id);
    public ChildEditDTO listChildDTO(UUID id);
    List<ChildDTO> getParentChildren(UUID parentId);
}