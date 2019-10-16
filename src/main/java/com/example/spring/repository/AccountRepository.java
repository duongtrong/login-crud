package com.example.spring.repository;

import com.example.spring.entity.Account;

public interface AccountRepository {
    Account findAccountByEmail(String email);

    Account save(Account account);
}
