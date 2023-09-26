package com.focus.service;

import com.focus.dto.ParentAccountDTO;
import com.focus.dto.ParentAdminDTO;
import com.focus.dto.ParentDTO;
import com.focus.dto.ParentUserDTO;
import com.focus.model.Parent;
import com.focus.model.User;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    public List<ParentDTO> getAllParents();
    public ParentAccountDTO getParent(String email);
    public Parent getById(UUID parentId);
    public Boolean registerParent(ParentUserDTO parentUser);
    public Boolean authenticateParent(String email, String password);
    public Boolean enableUser(UUID parentId);
    public List<ParentAdminDTO> getAllParentAdmin();

}