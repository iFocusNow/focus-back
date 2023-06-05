package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "block_periods")
@NoArgsConstructor
public class BlockPeriod {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    private Boolean is_monday;
    private Boolean is_tuesday;
    private Boolean is_wednesday;
    private Boolean is_thursday;
    private Boolean is_friday;
    private Boolean is_saturday;
    private Boolean is_sunday;
}
