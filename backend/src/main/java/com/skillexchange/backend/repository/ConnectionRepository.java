package com.skillexchange.backend.repository;

import com.skillexchange.backend.entity.Connection;
import com.skillexchange.backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConnectionRepository extends JpaRepository<Connection, Integer> {

    Optional<Connection> findBySenderAndReceiver(User sender, User receiver);
}