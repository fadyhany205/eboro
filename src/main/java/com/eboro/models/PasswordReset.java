package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "password_resets", schema = "eboro", indexes = {
        @Index(name = "password_resets_email_index", columnList = "email")
})
public class PasswordReset {
    @Column(name = "email", nullable = false, length = 191)
    private String email;

    @Column(name = "token", nullable = false, length = 191)
    private String token;

    @Column(name = "created_at")
    private Instant createdAt;
    @Id
    private Long id;
}