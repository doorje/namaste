package com.mahen.doorje.namaste.account.query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NamasteAccountPrivilegeRepository extends JpaRepository<NamasteAccountPrivilegeEntry, String> {

    NamasteAccountPrivilegeEntry findByName(String name);

    @Override
    void delete(NamasteAccountPrivilegeEntry privilege);
}
