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
@Table(name = "orders", schema = "eboro")
public class Order {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "user_id", nullable = false)
    private com.eboro.models.User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @Column(name = "total_price", nullable = false)
    private Double totalPrice;

    @ColumnDefault("'pending'")
    @Lob
    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "drop_lat", nullable = false, precision = 9, scale = 6)
    private BigDecimal dropLat;

    @Column(name = "drop_long", nullable = false, precision = 9, scale = 6)
    private BigDecimal dropLong;

    @Column(name = "options", length = 150)
    private String options;

    @Column(name = "drop_address", length = 150)
    private String dropAddress;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "delivery_id")
    private com.eboro.models.User delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "cashier_id")
    private BranchStaff cashier;

    @ColumnDefault("0")
    @Column(name = "payment")
    private Byte payment;

    @Column(name = "tax_price", precision = 10, scale = 2)
    private BigDecimal taxPrice;

    @Column(name = "shipping_price", precision = 10, scale = 2)
    private BigDecimal shippingPrice;

    @Column(name = "Delivery_time", length = 100)
    private String deliveryTime;

    @Column(name = "Delivery_distance", length = 100)
    private String deliveryDistance;

    @Column(name = "transaction_ID", length = 150)
    private String transactionId;

    @Lob
    @Column(name = "refuse_reason")
    private String refuseReason;

    @Column(name = "ordar_at")
    private Instant ordarAt;

    @Column(name = "paypal_EMAIL", length = 150)
    private String paypalEmail;

    @Column(name = "paypal_CURRENCY", length = 50)
    private String paypalCurrency;

    @Column(name = "paypal_PAYERID", length = 100)
    private String paypalPayerid;

    @Column(name = "paypal_ITEMAMT", precision = 10, scale = 2)
    private BigDecimal paypalItemamt;

    @Column(name = "paypal_TIMESTAMP", length = 100)
    private String paypalTimestamp;

    @Column(name = "paypal_BUILD", length = 100)
    private String paypalBuild;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Lob
    @Column(name = "comment")
    private String comment;

/*
 TODO [Reverse Engineering] create field to map the 'gratuity' column
 Available actions: Define target Java type | Uncomment as is | Remove column mapping
    @ColumnDefault("0")
    @Column(name = "gratuity", columnDefinition = "double UNSIGNED")
    private Object gratuity;
*/
}