package com.skillexchange.backend.repository;

import com.skillexchange.backend.entity.Message;
import com.skillexchange.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    List<Message> findBySenderAndReceiverOrSenderAndReceiver(
            User sender1, User receiver1,
            User sender2, User receiver2
    );
}