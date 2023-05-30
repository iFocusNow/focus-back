package com.focus.service;

import com.focus.model.Parent;
import com.focus.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository repo;
    public List<Parent> getAllParents() {
        List<Parent> parents = repo.findAll();
        return parents;
    }

    public Parent registerParent(Parent parent){
        return repo.save(parent);
    }
}
