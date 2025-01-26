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
@Table(name = "branch_products", schema = "eboro", indexes = {
        @Index(name = "asdqweqw", columnList = "type")
})
public class BranchProduct {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "branch_id", nullable = false)
    private com.eboro.models.Branch branch;

    @Column(name = "name", nullable = false, length = 191)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "image", length = 191)
    private String image;

    @Lob
    @Column(name = "description")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "type")
    private com.eboro.models.InnerType type;

    @Column(name = "additions", length = 191)
    private String additions;

    @Column(name = "calories", length = 191)
    private String calories;

    @Column(name = "size", length = 191)
    private String size;

    @Lob
    @Column(name = "product_type", nullable = false)
    private String productType;

    @Column(name = "has_alcohol")
    private Long hasAlcohol;

    @Column(name = "has_pig")
    private Long hasPig;

    @ColumnDefault("0")
    @Column(name = "has_outofstock")
    private Long hasOutofstock;

    @Column(name = "position")
    private Long position;

    @Column(name = "start_outofstock")
    private Instant startOutofstock;

    @Column(name = "end_outofstock")
    private Instant endOutofstock;

    @Column(name = "publish_at")
    private Instant publishAt;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}