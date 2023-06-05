package com.focus.service;

import com.focus.dto.ParentDTO;
import com.focus.model.Parent;
import com.focus.repository.ParentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


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

    public Parent registerParent(Parent parent) {
        Parent existingParent = repo.findByEmail(parent.getEmail());
        if (existingParent != null) {
            throw new RuntimeException("El correo electrónico ya está en uso");
        }

        String encodedPassword = BCrypt.hashpw(parent.getPassword(), BCrypt.gensalt());
        parent.setPassword(encodedPassword);
        return repo.save(parent);
    }

}
