package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Table(name = "app_devices")
public class AppDevices {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    @ManyToOne
    @JoinColumn(name = "app_id")
    private App app;
    @OneToOne
    @JoinColumn(name = "blockperiod_id")
    private BlockPeriod block_period;
}
