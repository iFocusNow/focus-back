package com.focus.service;

import com.focus.dto.*;
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

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

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
    public Boolean registerParent(ParentUserDTO parentUser) {
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

            try {
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

                try {
                    userRespository.save(user);
                } catch (Exception e) {
                    repo.delete(savedParent);
                    throw new InternalServerErrorException("Internal server error registering parent", e);
                }

                return true;

            } catch (Exception e) {
                throw new InternalServerErrorException("Internal server error registering parent", e);
            }

        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error registering parent", e);
        }
    }

    public Boolean authenticateParent(String email, String password) {
        try {
            User user = userRespository.findByUserName(email);
            if (!user.isActive()) {
                return false;
            }

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

    public ParentAccountDTO getParent(String email) {
        try {
            User user = userRespository.findByUserName(email);
            if (user == null) {
                throw new ResourceNotFoundException("User not found with email " + email);
            }

            ParentAccountDTO parentDTO = new ParentAccountDTO(
                    user.getParent().getId(),
                    user.getParent().getLast_name_mother(),
                    user.getParent().getLast_name_father(),
                    user.getParent().getPhoto_url()
            );

            return parentDTO;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error getting parent by id: ", e);
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
    public Boolean enableUser(UUID parentId) {
        try {
            User newUser = userRespository.findByParentId(parentId);
            if (newUser == null) {
                throw new ResourceNotFoundException("User not found with ID " + parentId);
            }

            Parent newParent = repo.findById(parentId).get();
            if (newParent == null) {
                throw new ResourceNotFoundException("Parent not found with ID " + parentId);
            }

            // Toggle active/inactive
             newUser.setActive(!newUser.isActive());

            // Update recent change
            newParent.setUpdated_at(Timestamp.valueOf(LocalDateTime.now()));

            // Save changes
            userRespository.save(newUser);
            repo.save(newParent);

            return newUser.isActive();

        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error getting parent by id: " + parentId, e);
        }
    }

    public List<ParentAdminDTO> getAllParentAdmin() {
        try {
            // List parents
            List<Parent> parents = repo.findAll();
            if (parents.isEmpty()) {
                throw new ResourceNotFoundException("Parents not found");
            }

            // Get if user is enabled
            List<ParentAdminDTO> parentAdminDTOs = new ArrayList<>();
            for (Parent parent : parents) {
                User user = userRespository.findByParentId(parent.getId());
                ParentAdminDTO parentAdminDTO = new ParentAdminDTO(
                        parent.getId(),
                        parent.getLast_name_mother(),
                        parent.getLast_name_father(),
                        parent.getCreated_at(),
                        parent.getUpdated_at(),
                        user.isActive()
                );
                parentAdminDTOs.add(parentAdminDTO);
            }
            return parentAdminDTOs;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error getting parents", e);
        }
    }

    public String updatePassword(PasswordDTO passwordDTO) {
        try {
            User newUser = userRespository.findByEmail(passwordDTO.getEmail());

            Parent parent = repo.findById(newUser.getParent().getId()).get();

            if (!Objects.equals(parent.getLast_name_father(), passwordDTO.getLast_name_father()) || !Objects.equals(parent.getLast_name_mother(), passwordDTO.getLast_name_mother())) {
                return "";
            }

            // Generate a new random password
            StringBuilder password = getStringBuilder();
            String strPassword = password.toString();

            // Save encrypted password
            String encodedPassword = BCrypt.hashpw(strPassword, BCrypt.gensalt());
            newUser.setPassword(encodedPassword);
            newUser.setPasswordLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
            userRespository.save(newUser);

            // Return password to send on email
            return strPassword;
        } catch (Exception e) {
            throw new InternalServerErrorException("Internal server error updating password: ", e);
        }
    }

    private static StringBuilder getStringBuilder() {
        String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+";
        int PASSWORD_LENGTH = 10;
        Random random = new SecureRandom();
        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            password.append(randomChar);
        }
        return password;
    }
}
