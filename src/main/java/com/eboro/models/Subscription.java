package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "subscriptions", schema = "eboro", indexes = {
        @Index(name = "subscriptions_user_id_stripe_status_index", columnList = "user_id, stripe_status")
})
public class Subscription {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "name", nullable = false, length = 191)
    private String name;

    @Column(name = "stripe_id", nullable = false, length = 191)
    private String stripeId;

    @Column(name = "stripe_status", nullable = false, length = 191)
    private String stripeStatus;

    @Column(name = "stripe_plan", length = 191)
    private String stripePlan;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "trial_ends_at")
    private Instant trialEndsAt;

    @Column(name = "ends_at")
    private Instant endsAt;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}