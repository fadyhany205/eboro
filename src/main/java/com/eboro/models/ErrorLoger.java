package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "error_logers", schema = "eboro")
public class ErrorLoger {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "file", nullable = false, length = 191)
    private String file;

    @Column(name = "line", nullable = false, length = 191)
    private String line;

    @Lob
    @Column(name = "error", nullable = false)
    private String error;

    @Lob
    @Column(name = "request", nullable = false)
    private String request;

    @Column(name = "method", nullable = false, length = 191)
    private String method;

    @Column(name = "url", nullable = false, length = 191)
    private String url;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}