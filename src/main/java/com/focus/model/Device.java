package com.focus.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "devices")
@NoArgsConstructor
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
    @OneToMany(mappedBy = "device")
    private List<AppDevice> app_devices;
    @OneToMany(mappedBy = "device")
    private List<Alert> alerts;

    public Device(Child child, DeviceType type, String brand) {
        this.child = child;
        this.type = type;
        this.brand = brand;
    }
}
