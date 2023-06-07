package com.focus.service;

import com.focus.dto.ParentAccountDTO;
import com.focus.dto.ParentDTO;
import com.focus.dto.ChildDTO;
import com.focus.model.Child;
import com.focus.model.Parent;
import com.focus.model.Alert;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    public List<ParentDTO> getAllParents();
    public ParentAccountDTO getParentById(UUID parentId);
    public Parent registerParent(Parent parent);
    List<ChildDTO> getParentChildren(UUID parentId);
    public boolean authenticateParent(String email, String password);
}