package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "apps")
@NoArgsConstructor
public class App {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    private String name;
    private String logo_url;
    @OneToMany(mappedBy = "app")
    private List<AppDevice> app_devices;
}
