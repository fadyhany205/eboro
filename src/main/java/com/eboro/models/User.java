package com.eboro.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.Set;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users", schema = "eboro", indexes = {
        @Index(name = "users_stripe_id_index", columnList = "stripe_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "users_email_unique", columnNames = {"email"})
})
public class User {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Column (name="username",length = 50)
    private String username;
    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "email_verified_at")
    private Instant emailVerifiedAt;

    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @Column(name = "address", length = 100)
    private String address;

    @Column(name = "mobile", length = 100)
    private String mobile;

    @Column(name = "verify_code", length = 100)
    private String verifyCode;

    @Column(name = "image", length = 100)
    private String image;

    @ColumnDefault("0")
    @Column(name = "type", nullable = false)
    private Byte type;

    @ColumnDefault("1")
    @Column(name = "active")
    private Byte active;

    @Column(name = "lat", length = 100)
    private String lat;

    @Column(name = "`long`", length = 100)
    private String longField;

    @ColumnDefault("0")
    @Column(name = "online")
    private Byte online;

    @Column(name = "last_session")
    private Instant lastSession;

    @Column(name = "vehicle_type", length = 100)
    private String vehicleType;

    @Column(name = "remember_token", length = 100)
    private String rememberToken;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "stripe_id", length = 100)
    private String stripeId;

    @Column(name = "card_brand", length = 100)
    private String cardBrand;

    @Column(name = "card_last_four", length = 4)
    private String cardLastFour;

    @Column(name = "trial_ends_at")
    private Instant trialEndsAt;

    @Column(name = "nationality", length = 100)
    private String nationality;

    @Column(name = "city", length = 100)
    private String city;

    @Column(name = "country", length = 100)
    private String country;

    @Column(name = "house", length = 100)
    private String house;

    @Column(name = "intercom", length = 100)
    private String intercom;

    @Column(name = "front_id_image", length = 100)
    private String frontIdImage;

    @Column(name = "back_id_image", length = 100)
    private String backIdImage;

    @Column(name = "license_image", length = 100)
    private String licenseImage;

    @Column(name = "license_expire", length = 100)
    private String licenseExpire;

    @Column(name = "facebook_id", length = 100)
    private String facebookId;

    @Column(name = "google_id", length = 100)
    private String googleId;

    @Lob
    @Column(name = "apple_id")
    private String appleId;
    @Singular("Authority")
    @ManyToMany(cascade = CascadeType.MERGE, fetch =
            FetchType.EAGER)
    @JoinTable(name = "USER_AUTHORITY",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID")})
    private Set<Authority> authority;
    @Builder.Default
    private Boolean accountNonExpired = true;
    @Builder.Default
    private Boolean accountNonLocked = true;
    @Builder.Default
    private Boolean credentialsExpired = true;
    @Builder.Default
    private Boolean enabled = true;
}