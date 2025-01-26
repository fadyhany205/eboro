package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "subscribers", schema = "eboro", uniqueConstraints = {
        @UniqueConstraint(name = "subscribers_email_unique", columnNames = {"email"})
})
public class Subscriber {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "email", nullable = false, length = 191)
    private String email;

    @Column(name = "email_verified_at")
    private Instant emailVerifiedAt;

    @ColumnDefault("'subscribe'")
    @Lob
    @Column(name = "state", nullable = false)
    private String state;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}