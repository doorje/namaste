package com.mahen.doorje.namaste.account.query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.stream.Stream;

public interface NamasteAccountVerificationTokenRepository
        extends JpaRepository<NamasteAccountVerificationTokenEntry, Long> {

    NamasteAccountVerificationTokenEntry findByToken(String token);

    NamasteAccountVerificationTokenEntry findByAccount(NamasteAccountEntry account);

    Stream<NamasteAccountVerificationTokenEntry> findAllByExpiryDateLessThan(Date now);

    void deleteByExpiryDateLessThan(Date now);

    @Modifying
    @Query("delete from NamasteAccountVerificationTokenEntry t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);
}
