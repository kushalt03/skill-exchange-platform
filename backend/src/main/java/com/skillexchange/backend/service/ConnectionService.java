package com.skillexchange.backend.service;

import com.skillexchange.backend.entity.*;
import com.skillexchange.backend.repository.*;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ConnectionService {

    private final ConnectionRepository connectionRepository;
    private final UserRepository userRepository;

    public ConnectionService(ConnectionRepository connectionRepository,
                             UserRepository userRepository) {
        this.connectionRepository = connectionRepository;
        this.userRepository = userRepository;
    }

    public Connection sendRequest(Integer senderId, Integer receiverId) {

        User sender = userRepository.findById(senderId).orElseThrow();
        User receiver = userRepository.findById(receiverId).orElseThrow();

        // Check duplicate (same direction)
        Optional<Connection> existing =
                connectionRepository.findBySenderAndReceiver(sender, receiver);

        if (existing.isPresent()) {
            return existing.get();
        }

        // Check reverse duplicate
        Optional<Connection> reverse =
                connectionRepository.findBySenderAndReceiver(receiver, sender);

        if (reverse.isPresent()) {
            return reverse.get();
        }

        Connection connection = new Connection();
        connection.setSender(sender);
        connection.setReceiver(receiver);
        connection.setStatus(ConnectionStatus.PENDING);

        return connectionRepository.save(connection);
    }

    public Connection respondRequest(Integer connectionId, ConnectionStatus status) {

        Connection connection = connectionRepository.findById(connectionId).orElseThrow();
        connection.setStatus(status);

        return connectionRepository.save(connection);
    }
}