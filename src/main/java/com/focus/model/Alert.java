package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;


@Data
@Entity
@Table(name = "alerts")
public class Alert {
    public enum AlertType {
        BLOCK_ENTRY,
        SOLICIT_UNBLOCK,
        PHONE_TIME_EXCEEDED,
    }

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", columnDefinition = "uuid", updatable = false)
    private UUID id;
    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "alert_type")
    private AlertType type;
    private Timestamp created_at;
    private Timestamp updated_at;
}
