package com.focus.service;

import com.focus.dto.ParentAccountDTO;
import com.focus.dto.ParentDTO;
import com.focus.model.Parent;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    public List<ParentDTO> getAllParents();
    public ParentAccountDTO getParentById(UUID parentId);
    public Parent registerParent(Parent parent);
    public boolean authenticateParent(String email, String password);
}