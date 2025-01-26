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
@Table(name = "promocodes", schema = "eboro")
public class Promocode {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "current_min_deposit", length = 191)
    private String currentMinDeposit;

    @Column(name = "old_min_deposit", length = 191)
    private String oldMinDeposit;

    @Column(name = "max_offer", length = 191)
    private String maxOffer;

    @ColumnDefault("'Total'")
    @Lob
    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "user_create_at")
    private Instant userCreateAt;

    @Column(name = "user_create_to")
    private Instant userCreateTo;

    @Column(name = "start_at")
    private Instant startAt;

    @Column(name = "end_at")
    private Instant endAt;

    @Column(name = "HMUser", length = 191)
    private String hMUser;

    @Column(name = "HMTime_used", length = 191)
    private String hmtimeUsed;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id")
    private com.eboro.models.User user;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}