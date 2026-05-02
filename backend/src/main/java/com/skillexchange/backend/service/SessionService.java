package com.skillexchange.backend.service;

import com.skillexchange.backend.entity.*;
import com.skillexchange.backend.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final ConnectionRepository connectionRepository;

    public SessionService(SessionRepository sessionRepository,
                          ConnectionRepository connectionRepository) {
        this.sessionRepository = sessionRepository;
        this.connectionRepository = connectionRepository;
    }

    public Session createSession(Integer connectionId, LocalDateTime time, Integer duration, String link) {

        Connection connection = connectionRepository.findById(connectionId).orElseThrow();

        if (connection.getStatus() != ConnectionStatus.ACCEPTED) {
            throw new RuntimeException("Users not connected");
        }

        Session session = new Session();
        session.setConnection(connection);
        session.setScheduledTime(time);
        session.setDuration(duration);
        session.setMeetingLink(link);
        session.setStatus(SessionStatus.SCHEDULED);

        return sessionRepository.save(session);
    }

    public Session completeSession(Integer sessionId) {

        Session session = sessionRepository.findById(sessionId).orElseThrow();
        session.setStatus(SessionStatus.COMPLETED);

        return sessionRepository.save(session);
    }
}