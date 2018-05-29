package com.mahen.doorje.namaste.account.query;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface NamasteAccountRepository extends JpaRepository<NamasteAccountEntry, String> {
    Collection<NamasteAccountEntry> findAllByOrderByIdAsc();
    Optional<NamasteAccountEntry> findByAccountId(String accountId);
    NamasteAccountEntry findByEmail(String email);
}
