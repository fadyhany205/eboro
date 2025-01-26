package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "providers", schema = "eboro")
public class Provider {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 191)
    private String name;

    @Column(name = "logo", nullable = false, length = 191)
    private String logo;

    @ColumnDefault("60")
    @Column(name = "range_delivery")
    private Float rangeDelivery;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private com.eboro.models.User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ColumnDefault("'0'")
    @Column(name = "delivery")
    private String delivery;

    @ColumnDefault("0")
    @Column(name = "vip")
    private Boolean vip;

    @ColumnDefault("'45'")
    @Lob
    @Column(name = "duration")
    private String duration;

    @Lob
    @Column(name = "`lock`")
    private String lock;

    @Column(name = "position")
    private String position;

    @ColumnDefault("'1'")
    @Column(name = "delivery_fee")
    private String deliveryFee;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}