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

    public BlockPeriod(Boolean is_monday, Boolean is_tuesday, Boolean is_wednesday, Boolean is_thursday, Boolean is_friday, Boolean is_saturday, Boolean is_sunday) {
        this.is_monday = is_monday;
        this.is_tuesday = is_tuesday;
        this.is_wednesday = is_wednesday;
        this.is_thursday = is_thursday;
        this.is_friday = is_friday;
        this.is_saturday = is_saturday;
        this.is_sunday = is_sunday;
    }
}
