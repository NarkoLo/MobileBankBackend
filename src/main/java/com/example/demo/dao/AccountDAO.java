package com.example.demo.dao;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO для работы с банковскими счетами.
 */
@Component
public class AccountDAO {

    private final AccountRepository accountRepository;

    /**
     * Конструктор класса.
     *
     * @param accountRepository репозиторий для работы с банковскими счетами
     */
    @Autowired
    public AccountDAO(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    /**
     * Сохраняет банковский счет в базе данных.
     *
     * @param account банковский счет
     */
    @Transactional
    public void save(Account account) {
        accountRepository.save(account);
    }

    /**
     * Находит банковский счет по его идентификатору.
     *
     * @param id идентификатор счета
     * @return объект Account или null, если счет не найден
     */
    public Account findById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    /**
     * Находит банковский счет по его номеру.
     *
     * @param accountNumber номер счета
     * @return объект Account или null, если счет не найден
     */
    public Account findByAccountNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber).orElse(null);
    }

    /**
     * Находит все банковские счета, принадлежащие указанному пользователю.
     *
     * @param ownerId идентификатор пользователя
     * @return список банковских счетов
     */
    public List<Account> findByOwnerId(Long ownerId) {
        return accountRepository.findByOwnerId(ownerId);
    }

    /**
     * Находит все банковские счета в базе данных.
     *
     * @return список банковских счетов
     */
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    /**
     * Удаляет банковский счет из базы данных.
     *
     * @param account банковский счет
     */
    @Transactional
    public void delete(Account account) {
        accountRepository.delete(account);
    }
}