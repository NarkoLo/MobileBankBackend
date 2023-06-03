package com.example.demo.dao;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class AccountDAO {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountDAO(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void save(Account account) {
        accountRepository.save(account);
    }

    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).orElse(null);
    }

    public List<Account> findByOwnerId(Long ownerId) {
        return accountRepository.findByOwnerId(ownerId);
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Transactional
    public void delete(Account account) {
        accountRepository.delete(account);
    }
}
