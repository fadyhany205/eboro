package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "subscription_items", schema = "eboro", indexes = {
        @Index(name = "subscription_items_stripe_id_index", columnList = "stripe_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "subscription_items_subscription_id_stripe_plan_unique", columnNames = {"subscription_id", "stripe_plan"})
})
public class SubscriptionItem {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "subscription_id", nullable = false)
    private Long subscriptionId;

    @Column(name = "stripe_id", nullable = false, length = 191)
    private String stripeId;

    @Column(name = "stripe_plan", nullable = false, length = 191)
    private String stripePlan;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}