package com.eboro.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "settings", schema = "eboro")
public class Setting {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "logo", length = 191)
    private String logo;

    @Lob
    @Column(name = "state")
    private String state;

    @Lob
    @Column(name = "state_message_en")
    private String stateMessageEn;

    @Lob
    @Column(name = "state_message_it")
    private String stateMessageIt;

    @Lob
    @Column(name = "description_en")
    private String descriptionEn;

    @Lob
    @Column(name = "description_it")
    private String descriptionIt;

    @Column(name = "slider_image", length = 191)
    private String sliderImage;

    @Column(name = "android_link", length = 191)
    private String androidLink;

    @Column(name = "iOS_link", length = 191)
    private String iosLink;

    @Column(name = "tax", length = 191)
    private String tax;

    @Column(name = "Dli_time", length = 191)
    private String dliTime;

    @Column(name = "shipping", length = 191)
    private String shipping;

    @ColumnDefault("'1'")
    @Column(name = "shipping2", length = 191)
    private String shipping2;

    @Column(name = "`range`")
    private String range;

    @Column(name = "min_shipping")
    private String minShipping;

    @Column(name = "avg_prepare")
    private String avgPrepare;

    @Column(name = "providers_array")
    private String providersArray;

    @Column(name = "product_array")
    private String productArray;

    @Column(name = "product_offer_array")
    private String productOfferArray;

    @Column(name = "facebook", length = 191)
    private String facebook;

    @Column(name = "twitter", length = 191)
    private String twitter;

    @Column(name = "linkedin", length = 191)
    private String linkedin;

    @Column(name = "youtube", length = 191)
    private String youtube;

    @Lob
    @Column(name = "about_en")
    private String aboutEn;

    @Lob
    @Column(name = "about_it")
    private String aboutIt;

    @Lob
    @Column(name = "privacy_en")
    private String privacyEn;

    @Lob
    @Column(name = "privacy_it")
    private String privacyIt;

    @Lob
    @Column(name = "contact_email_1")
    private String contactEmail1;

    @Lob
    @Column(name = "contact_email_2")
    private String contactEmail2;

    @Lob
    @Column(name = "contact_email_3")
    private String contactEmail3;

    @Lob
    @Column(name = "contact_map")
    private String contactMap;

    @Column(name = "de_start")
    private String deStart;

    @Column(name = "de_per_km")
    private String dePerKm;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "assist_phones")
    private String assistPhones;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}