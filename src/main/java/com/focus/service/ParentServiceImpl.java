package com.focus.service;

import com.focus.dto.AlertDTO;
import com.focus.dto.ParentAccountDTO;
import com.focus.dto.ParentDTO;
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

    public List<ParentDTO> getAllParents() {
        List<Parent> parents = repo.findAll();
        List<ParentDTO> parentDTOs = new ArrayList<>();
        for (Parent parent : parents) {
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

    public Parent registerParent(Parent parent) {
        Parent existingParent = repo.findByEmail(parent.getEmail());
        if (existingParent != null) {
            throw new RuntimeException("El correo electrónico ya está en uso");
        }

        String encodedPassword = BCrypt.hashpw(parent.getPassword(), BCrypt.gensalt());
        parent.setPassword(encodedPassword);
        return repo.save(parent);
    }

    public boolean authenticateParent(String email, String password) {
        Parent parent = repo.findByEmail(email);
        if (parent != null) {
            return BCrypt.checkpw(password, parent.getPassword());
        }
        return false;
    }

    public ParentAccountDTO getParentById(UUID parentId) {
        Parent parent = repo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        ParentAccountDTO parentDTO = new ParentAccountDTO(
                parent.getId(),
                parent.getLast_name_mother(),
                parent.getLast_name_father(),
                parent.getEmail(),
                parent.getPhoto_url()
        );

        return parentDTO;
    }

    public List<AlertDTO> getParentAlerts(UUID parentId) {
        Parent parent = repo.findById(parentId)
                .orElseThrow(() -> new RuntimeException("Parent not found"));

        List<Child> children = parent.getChildren();
        List<AlertDTO> alertDTOs = new ArrayList<>();

        for (Child child : children) {
            List<Alert> alerts = child.getAlerts();
            for (Alert alert : alerts) {
                AlertDTO alertDTO = new AlertDTO(
                        alert.getId(),
                        child.getId(),
                        alert.getType().toString(),
                        alert.getCreated_at(),
                        alert.getUpdated_at()
                );
                alertDTOs.add(alertDTO);
            }
        }

        return alertDTOs;
    }

}

