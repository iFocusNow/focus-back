package com.focus.service;

import com.focus.dto.ParentDTO;
import com.focus.model.Parent;

import java.util.List;

public interface ParentService {
    public List<Parent> getAllParents();

    public Parent registerParent(Parent parent);
}
