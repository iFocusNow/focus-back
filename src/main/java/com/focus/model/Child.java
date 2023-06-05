package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "children")
@NoArgsConstructor
public class Child {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Parent parent;
    private String name;
    private String child_code;
    private Timestamp created_at;
    private Timestamp updated_at;
    @OneToMany(mappedBy = "child")
    private List<Alert> alerts;
    @OneToMany(mappedBy = "child")
    private List<Device> devices;

    public Child(Parent parent, String name, String child_code, Timestamp created_at, Timestamp updated_at, List<Alert> alerts, List<Device> devices) {
        this.parent = parent;
        this.name = name;
        this.child_code = child_code;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.alerts = alerts;
        this.devices = devices;
    }
}
