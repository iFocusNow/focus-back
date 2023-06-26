package com.focus.service;

import com.focus.dto.ParentAccountDTO;
import com.focus.dto.ParentDTO;
import com.focus.dto.ParentUserDTO;
import com.focus.exceptions.DuplicateEntryException;
import com.focus.exceptions.InternalServerErrorException;
import com.focus.exceptions.ResourceNotFoundException;
import com.focus.model.*;
import com.focus.repository.AuthorityRepository;
import com.focus.repository.ParentRepository;
import com.focus.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

//Esta sección se encarga sobre el listado de padres, el registro de cada uno de ellos, la autenticación y el Id para relacionar con las demás funciones

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository repo;
    @Autowired
    private UserRepository userRespository;

    @Autowired
    private AuthorityRepository authorityRepository;

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
                        parent.getPhoto_url(),
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

    // Change to ParentUserRegisterDTO
    public Parent registerParent(ParentUserDTO parentUser) {
        try {
            // user User to check if email is already registered
            User existingUser = userRespository.findByUserName(parentUser.getEmail());
            if (existingUser != null) {
                throw new DuplicateEntryException("Email already registered");
            }
            String encodedPassword = BCrypt.hashpw(parentUser.getPassword(), BCrypt.gensalt());

            List<Child> children = new ArrayList<>();

            Parent parent = new Parent(
                    parentUser.getLast_name_mother(),
                    parentUser.getLast_name_father(),
                    parentUser.getPhoto_url(),
                    Timestamp.valueOf(LocalDateTime.now()),
                    Timestamp.valueOf(LocalDateTime.now()),
                    children
            );

            Parent savedParent = repo.save(parent);

            List<String> authorityNames = Arrays.asList("ROLE_PARENT", "READ", "WRITE");
            List<Authority> authorities = authorityNames.stream().map(authorityName -> {
                Authority authority = authorityRepository.findByName(AuthorityName.valueOf(authorityName));
                if (authority == null) {
                    throw new ResourceNotFoundException("Authority not found with name " + authorityName);
                }
                return authority;
            }).toList();

            User user = new User(
                    parentUser.getEmail(),
                    encodedPassword,
                    true,
                    Timestamp.valueOf(LocalDateTime.now()),
                    authorities,
                    savedParent
            );

            User savedUser = userRespository.save(user);

            return savedParent;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error registering parent", e);
        }
    }

    public Boolean authenticateParent(String email, String password) {
        try {
            User user = userRespository.findByUserName(email);
            if (user == null) {
                throw new ResourceNotFoundException("User not found with email " + email);
            }
            if (!BCrypt.checkpw(password, user.getPassword())) {
                throw new ResourceNotFoundException("Invalid password");
            }

            return true;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error authenticating parent", e);
        }
    }

    public ParentAccountDTO getParentById(UUID parentId) {
        try {
            Parent parent = repo.findById(parentId)
                    .orElseThrow(() -> new ResourceNotFoundException("Parent not found with ID " + parentId));

            ParentAccountDTO parentDTO = new ParentAccountDTO(
                    parent.getId(),
                    parent.getLast_name_mother(),
                    parent.getLast_name_father(),
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
