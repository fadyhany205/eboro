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
@Table(name = "inner_types", schema = "eboro")
public class InnerType {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type_it", length = 191)
    private String typeIt;

    @Column(name = "type_en", length = 191)
    private String typeEn;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "provider_id")
    private com.eboro.models.Provider provider;

    @Lob
    @Column(name = "image")
    private String image;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}