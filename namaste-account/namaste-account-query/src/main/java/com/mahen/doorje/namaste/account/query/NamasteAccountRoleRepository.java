package com.mahen.doorje.namaste.account.query;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NamasteAccountRoleRepository extends JpaRepository<NamasteAccountRoleEntry, String> {

    NamasteAccountRoleEntry findByName(String name);

    @Override
    void delete(NamasteAccountRoleEntry role);
}
