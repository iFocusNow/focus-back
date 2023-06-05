package com.focus.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.UUID;


@Data
@Entity
@Table(name = "alerts")
@NoArgsConstructor
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

    public Alert(Child child, AlertType type, Timestamp created_at, Timestamp updated_at) {
        this.child = child;
        this.type = type;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
}
