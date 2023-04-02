package com.mazurenko.accounts.repository;

import com.mazurenko.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByCustomerId(long customerId);
}
