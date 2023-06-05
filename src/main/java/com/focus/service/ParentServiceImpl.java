package com.focus.service;

import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.model.Parent;
import com.focus.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository repo;

    public Parent registerParent(Parent parent){
        String encodedPassword = BCrypt.hashpw(parent.getPassword(), BCrypt.gensalt());
        parent.setPassword(encodedPassword);
        return repo.save(parent);
    }
    public List<Parent> getAllParents() {
        List<Parent> parents = repo.findAll();
        return parents;
    }
    @Override
    public Parent getParentById(UUID parentId) {
        return repo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));
    }
    @Override
    public List<Child> getChildrenByParentId(UUID parentId) {
        Parent parent = getParentById(parentId);
        return parent.getChildren();
    }
}
