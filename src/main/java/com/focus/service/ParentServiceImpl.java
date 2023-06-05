package com.focus.service;

import com.focus.dto.ParentDTO;
import com.focus.model.Alert;
import com.focus.model.Child;
import com.focus.model.Parent;
import com.focus.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository repo;

    public List<ParentDTO> getAllParents() {
        List<Parent> parents = repo.findAll();
        List<ParentDTO> parentDTOs = new ArrayList<>();

        for (Parent parent: parents) {
            ParentDTO parentDTO = new ParentDTO(
                    parent.getId(),
                    parent.getLast_name_mother(),
                    parent.getLast_name_father(),
                    parent.getEmail(),
                    parent.getPhoto_url(),
                    parent.getPassword(),
                    parent.getCreated_at(),
                    parent.getUpdated_at()
            );
            parentDTOs.add(parentDTO);
        }
        return parentDTOs;
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

    @Override
    public List<Alert> getNotificationsByParentId(UUID parentId) {
        Parent parent = repo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        List<Child> children = parent.getChildren();

        List<Alert> notifications = new ArrayList<>();
        for (Child child : children) {
            List<Alert> childAlerts = child.getAlerts();
            notifications.addAll(childAlerts);
        }

        return notifications;
    }

    }
