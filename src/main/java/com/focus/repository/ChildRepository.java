package com.focus.repository;

import com.focus.model.Child;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;
import java.util.List;

public interface ChildRepository extends JpaRepository<Child, UUID> {
    List<Child> findAllByParentId(UUID parentId);
}