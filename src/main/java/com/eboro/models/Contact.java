package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "contacts", schema = "eboro")
public class Contact {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", length = 191)
    private String email;

    @Column(name = "phone", length = 191)
    private String phone;

    @Column(name = "name", length = 191)
    private String name;

    @Column(name = "subject", length = 191)
    private String subject;

    @Lob
    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "file", length = 191)
    private String file;

    @Lob
    @Column(name = "re_message", nullable = false)
    private String reMessage;

    @ColumnDefault("'closed'")
    @Lob
    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}