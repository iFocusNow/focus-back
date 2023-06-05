package com.focus.service;

import com.focus.dto.ParentDTO;
import com.focus.model.Child;
import com.focus.model.Parent;
import com.focus.model.Alert;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    public List<ParentDTO> getAllParents();
    public ParentDTO getParentById(UUID parentId);

}
