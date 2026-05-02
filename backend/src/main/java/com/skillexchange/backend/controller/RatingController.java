package com.skillexchange.backend.controller;

import com.skillexchange.backend.entity.Rating;
import com.skillexchange.backend.service.RatingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingController {

    private final RatingService ratingService;

    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping
    public Rating giveRating(
            @RequestParam Integer sessionId,
            @RequestParam Integer givenBy,
            @RequestParam Integer givenTo,
            @RequestParam Integer rating,
            @RequestParam String feedback) {

        return ratingService.giveRating(sessionId, givenBy, givenTo, rating, feedback);
    }
}