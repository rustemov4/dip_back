package com.example.vts2.repository;

import com.example.vts2.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {
    Account findAccountByAccountID(String accountID);
}
