package com.eboro.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "categories", schema = "eboro")
public class Category {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name_en", nullable = false, length = 191)
    private String nameEn;

    @Column(name = "name_it", nullable = false, length = 191)
    private String nameIt;

    @Column(name = "image", length = 191)
    private String image;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}