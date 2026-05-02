package com.skillexchange.backend.controller;

import com.skillexchange.backend.entity.Connection;
import com.skillexchange.backend.entity.ConnectionStatus;
import com.skillexchange.backend.service.ConnectionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/connections")
public class ConnectionController {

    private final ConnectionService connectionService;

    public ConnectionController(ConnectionService connectionService) {
        this.connectionService = connectionService;
    }

    @PostMapping("/send")
    public Connection sendRequest(
            @RequestParam Integer senderId,
            @RequestParam Integer receiverId) {

        return connectionService.sendRequest(senderId, receiverId);
    }

    @PostMapping("/respond")
    public Connection respondRequest(
            @RequestParam Integer connectionId,
            @RequestParam ConnectionStatus status) {

        return connectionService.respondRequest(connectionId, status);
    }
}