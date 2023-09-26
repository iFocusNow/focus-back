package com.focus.repository;

import com.focus.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    public User findByUserName(String userName);

    @Query(value = "SELECT * FROM users WHERE parent_id = ?1", nativeQuery = true)
    public User findByParentId(UUID parentId);

    @Query(value = "SELECT * FROM users WHERE user_name = ?1", nativeQuery = true)
    public User findByEmail(String email);
}
