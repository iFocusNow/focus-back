package com.focus.service;

import com.focus.dto.ParentAccountDTO;
import com.focus.dto.ParentDTO;
import com.focus.exceptions.DuplicateEntryException;
import com.focus.exceptions.IncompleteDataException;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
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
        try {
            List<Parent> parents = repo.findAll();
            if (parents.isEmpty()) {
                throw new ResourceNotFoundException("Parents not found");
            }
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
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error getting parents", e);
        }
    }

    public Parent registerParent(Parent parent) {
        try {
            Parent existingParent = repo.findByEmail(parent.getEmail());
            // if (existingParent != null) {
            //     throw new DuplicateEntryException("Email already registered");
            // }
            // String encodedPassword = BCrypt.hashpw(parent.getPassword(), BCrypt.gensalt());
            // parent.setPassword(encodedPassword);
            return repo.save(parent);
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error registering parent", e);
        }
    }


    // public boolean authenticateParent(String email, String password) {
    //     try {
    //         Parent parent = repo.findByEmail(email);
    //         if (parent != null) {
    //             return BCrypt.checkpw(password, parent.getPassword());
    //         }
    //         return false;
    //     } catch (Exception e) {
    //         throw new IncompleteDataException("Internal server error authenticating parent" + e);
    //     }
    // }

    public ParentAccountDTO getParentById(UUID parentId) {
        try {
            Parent parent = repo.findById(parentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Parent not found with ID " + parentId));

            ParentAccountDTO parentDTO = new ParentAccountDTO(
                    parent.getId(),
                    parent.getLast_name_mother(),
                    parent.getLast_name_father(),
                    parent.getEmail(),
                    parent.getPhoto_url()
            );

            return parentDTO;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error getting parent by id: " + parentId, e);
        }
    }
    public Parent getById(UUID parentId) {
        try {
            Parent parent = repo.findById(parentId).get();
            if (parent == null) {
                throw new ResourceNotFoundException("Parent not found with ID " + parentId);
            }
            parent.setChildren(null);
            return parent;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error getting parent by id: " + parentId, e);
        }
    }
}
