package com.focus.repository;

import com.focus.model.App;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AppRepository extends JpaRepository<App, UUID> {
}
