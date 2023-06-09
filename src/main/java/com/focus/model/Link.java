package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "links")
@NoArgsConstructor
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;
    @OneToOne
    @JoinColumn(name = "blockperiod_id")
    private BlockPeriod block_period;
    private String name;
    private String url;

    public Link(Device device, BlockPeriod block_period, String name, String url) {
        this.device = device;
        this.block_period = block_period;
        this.name = name;
        this.url = url;
    }
}
