package com.example.spring.repository.repositoryimpl;

import com.example.spring.entity.Account;
import com.example.spring.repository.AccountRepository;

import javax.persistence.EntityManager;

public class AccountRepositoryImpl implements AccountRepository {

    private EntityManager entityManager;

    public AccountRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Account findAccountByEmail(String email) {
        return entityManager.find(Account.class, email);
    }

    @Override
    public Account save(Account account) {
        return null;
    }
}
