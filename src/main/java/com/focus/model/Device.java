package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "devices")
public class Device {
    public enum DeviceType {
        TABLET,
        PHONE,
        LAPTOP,
        PC
    }
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "device_type")
    private Device.DeviceType type;
    private String brand;
    @OneToMany(mappedBy = "device")
    private List<Link> links;
}
