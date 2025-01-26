package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "failed_jobs", schema = "eboro")
public class FailedJob {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Lob
    @Column(name = "connection", nullable = false)
    private String connection;

    @Lob
    @Column(name = "queue", nullable = false)
    private String queue;

    @Lob
    @Column(name = "payload", nullable = false)
    private String payload;

    @Lob
    @Column(name = "exception", nullable = false)
    private String exception;

    @ColumnDefault("current_timestamp()")
    @Column(name = "failed_at", nullable = false)
    private Instant failedAt;

}