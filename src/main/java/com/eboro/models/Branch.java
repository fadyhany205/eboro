package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "branches", schema = "eboro")
public class Branch {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "address", nullable = false, length = 150)
    private String address;

    @Column(name = "lat", nullable = false, precision = 9, scale = 6)
    private BigDecimal lat;

    @Column(name = "`long`", nullable = false, precision = 9, scale = 6)
    private BigDecimal longField;

    @Column(name = "hot_line", length = 50)
    private String hotLine;

    @Lob
    @Column(name = "opening_hours")
    private String openingHours;

    @Column(name = "open_time", nullable = false, length = 50)
    private String openTime;

    @Column(name = "close_time", nullable = false, length = 50)
    private String closeTime;

    @Column(name = "open_days", nullable = false, length = 50)
    private String openDays;

    @Lob
    @Column(name = "description")
    private String description;

    @ColumnDefault("0")
    @Column(name = "status", nullable = false)
    private Byte status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "provider_id", nullable = false)
    private com.eboro.models.Provider provider;

    @ColumnDefault("'0'")
    @Column(name = "allowed", length = 50)
    private String allowed;

    @Column(name = "parent", length = 100)
    private String parent;

    @Column(name = "position", length = 100)
    private String position;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}