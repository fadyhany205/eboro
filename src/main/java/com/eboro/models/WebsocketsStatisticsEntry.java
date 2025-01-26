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
@Table(name = "websockets_statistics_entries", schema = "eboro")
public class WebsocketsStatisticsEntry {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "app_id", nullable = false, length = 191)
    private String appId;

    @Column(name = "peak_connection_count", nullable = false)
    private Integer peakConnectionCount;

    @Column(name = "websocket_message_count", nullable = false)
    private Integer websocketMessageCount;

    @Column(name = "api_message_count", nullable = false)
    private Integer apiMessageCount;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}