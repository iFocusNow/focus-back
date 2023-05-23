package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
@Entity
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    private String last_name_mother;
    private String last_name_father;
    private String email;
    private String photo_url;
    private String password;
    private Timestamp created_at;
    private Timestamp updated_at;
}
