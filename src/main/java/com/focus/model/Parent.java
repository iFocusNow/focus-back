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
    private String email;
    private String photo_url;
    private String password;
    private boolean active;
    private Timestamp created_at;
    private Timestamp updated_at;
    @OneToMany(mappedBy = "parent")
    private List<Child> children;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="parent_authorities",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            },
            inverseJoinColumns = {
                    @JoinColumn(
                            name = "authority_id",
                            referencedColumnName = "id",
                            nullable = false
                    )
            }
    )
    private List<Authority> authorities;

    public Parent(String last_name_mother, String last_name_father, String email, String photo_url, String password, Timestamp created_at, Timestamp updated_at, List<Child> children) {
        this.last_name_mother = last_name_mother;
        this.last_name_father = last_name_father;
        this.email = email;
        this.photo_url = photo_url;
        this.password = password;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.children = children;
    }
}
