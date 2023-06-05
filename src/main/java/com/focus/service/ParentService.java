package com.focus.service;

import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.model.Parent;

import java.util.List;
import java.util.UUID;

public interface ParentService {
    public Parent registerParent(Parent parent);
    public List<Parent> getAllParents();
    public Parent getParentById(UUID parentId);
    public List<Child> getChildrenByParentId(UUID parentId);
}
