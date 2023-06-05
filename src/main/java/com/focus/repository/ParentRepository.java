package com.focus.repository;

import com.focus.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ParentRepository extends JpaRepository<Parent, UUID> {
    Parent findByEmail(String email);

}
