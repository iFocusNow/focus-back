package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "app_devices")
@NoArgsConstructor
public class AppDevice {
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
