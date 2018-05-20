package com.mahen.doorje.namaste.uaa.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntry, Long> {
    Optional<UserEntry> findByUsername(String username);
}
