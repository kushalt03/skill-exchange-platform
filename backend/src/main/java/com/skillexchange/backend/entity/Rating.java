package com.skillexchange.backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ratings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private Session session;

    @ManyToOne
    @JoinColumn(name = "given_by")
    private User givenBy;

    @ManyToOne
    @JoinColumn(name = "given_to")
    private User givenTo;

    private Integer rating;

    private String feedback;
}