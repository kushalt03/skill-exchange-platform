package com.skillexchange.backend.controller;

import com.skillexchange.backend.entity.Session;
import com.skillexchange.backend.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @PostMapping("/create")
    public Session createSession(
            @RequestParam Integer connectionId,
            @RequestParam String time,
            @RequestParam Integer duration,
            @RequestParam String link) {

        return sessionService.createSession(
                connectionId,
                LocalDateTime.parse(time),
                duration,
                link
        );
    }

    @PostMapping("/complete")
    public Session completeSession(@RequestParam Integer sessionId) {
        return sessionService.completeSession(sessionId);
    }
}