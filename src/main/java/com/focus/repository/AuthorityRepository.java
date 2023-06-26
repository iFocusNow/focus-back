package com.focus.repository;

import com.focus.model.Authority;
import com.focus.model.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorityRepository extends JpaRepository<Authority, UUID> {
    public Authority findByName(AuthorityName name);
}
