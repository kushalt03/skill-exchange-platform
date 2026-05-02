package com.skillexchange.backend.controller;

import com.skillexchange.backend.entity.Message;
import com.skillexchange.backend.service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/send")
    public Message sendMessage(
            @RequestParam Integer senderId,
            @RequestParam Integer receiverId,
            @RequestParam String content) {

        return messageService.sendMessage(senderId, receiverId, content);
    }

    @GetMapping("/conversation")
    public List<Message> getConversation(
            @RequestParam Integer user1Id,
            @RequestParam Integer user2Id) {

        return messageService.getConversation(user1Id, user2Id);
    }
}