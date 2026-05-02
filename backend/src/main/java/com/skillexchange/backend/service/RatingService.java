package com.skillexchange.backend.service;

import com.skillexchange.backend.entity.*;
import com.skillexchange.backend.repository.*;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private final RatingRepository ratingRepository;
    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public RatingService(RatingRepository ratingRepository,
                         SessionRepository sessionRepository,
                         UserRepository userRepository) {
        this.ratingRepository = ratingRepository;
        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    public Rating giveRating(Integer sessionId, Integer givenById, Integer givenToId,
                             Integer ratingValue, String feedback) {

        Session session = sessionRepository.findById(sessionId).orElseThrow();

        if (session.getStatus() != SessionStatus.COMPLETED) {
            throw new RuntimeException("Session not completed");
        }

        User givenBy = userRepository.findById(givenById).orElseThrow();
        User givenTo = userRepository.findById(givenToId).orElseThrow();

        Rating rating = new Rating();
        rating.setSession(session);
        rating.setGivenBy(givenBy);
        rating.setGivenTo(givenTo);
        rating.setRating(ratingValue);
        rating.setFeedback(feedback);

        return ratingRepository.save(rating);
    }
}