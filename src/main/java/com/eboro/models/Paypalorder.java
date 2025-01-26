package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "paypalorders", schema = "eboro")
public class Paypalorder {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private com.eboro.models.User user;

    @Column(name = "drop_lat", length = 191)
    private String dropLat;

    @Column(name = "drop_long", length = 191)
    private String dropLong;

    @Column(name = "drop_address", length = 191)
    private String dropAddress;

    @Column(name = "TOKEN", length = 191)
    private String token;

    @Column(name = "BUILD", length = 191)
    private String build;

    @Column(name = "State", length = 191)
    private String state;

    @Column(name = "paypal_link", length = 191)
    private String paypalLink;

    @Column(name = "ordar_at")
    private Instant ordarAt;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}