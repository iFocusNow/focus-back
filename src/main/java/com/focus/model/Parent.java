package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "parents")
@NoArgsConstructor
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    private String last_name_mother;
    private String last_name_father;
    private String photo_url;
    private Timestamp created_at;
    private Timestamp updated_at;
    @OneToMany(mappedBy = "parent")
    private List<Child> children;
    // In User:
    // email - userName
    // password - password

    public Parent(String last_name_mother, String last_name_father, String photo_url, Timestamp created_at, Timestamp updated_at, List<Child> children) {
        this.last_name_mother = last_name_mother;
        this.last_name_father = last_name_father;
        this.photo_url = photo_url;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.children = children;
    }
}
