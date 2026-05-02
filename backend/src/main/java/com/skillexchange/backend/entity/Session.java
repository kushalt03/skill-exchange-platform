package com.skillexchange.backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "connection_id")
    private Connection connection;

    private LocalDateTime scheduledTime;

    private Integer duration;

    private String meetingLink;

    @Enumerated(EnumType.STRING)
    private SessionStatus status;
}