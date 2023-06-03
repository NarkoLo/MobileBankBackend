package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.OpenAccountRequest;
import com.example.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse openAccount(OpenAccountRequest openAccountRequest) {
        // создание нового счета
        Account account = new Account();
        account.setOwnerId(openAccountRequest.getOwnerId());
        account.setAccountType(openAccountRequest.getAccountType());
        account.setBalance(BigDecimal.ZERO);

        // сохранение счета в базе данных
        account = accountRepository.save(account);

        // создание и возврат AccountResponse
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setOwnerId(account.getOwnerId());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setBalance(account.getBalance());
        return accountResponse;
    }

    public void closeAccount(Long accountId) {
        // поиск счета по идентификатору
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Счет не найден"));

        // проверка баланса счета
        if (account.getBalance().compareTo(BigDecimal.ZERO) != 0) {
            throw new RuntimeException("Невозможно закрыть счет с ненулевым балансом");
        }

        // удаление счета из базы данных
        accountRepository.delete(account);
    }

    public AccountResponse getAccountDetails(Long accountId) {
        // поиск счета по идентификатору
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Счет не найден"));

        // создание и возврат AccountResponse
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setOwnerId(account.getOwnerId());
        accountResponse.setAccountType(account.getAccountType());
        accountResponse.setBalance(account.getBalance());
        return accountResponse;
    }
}
