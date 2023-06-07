package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.OpenAccountRequest;
import com.example.demo.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.UUID;

/**

 Класс, представляющий сервис для работы с банковскими счетами.
 */
@Service
public class AccountService {
    private final AccountRepository accountRepository;

    /**

     Конструктор класса AccountService.
     @param accountRepository Репозиторий для работы с банковскими счетами.
     */
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }
    /**

     Метод для открытия нового банковского счета.

     @param openAccountRequest Запрос на открытие банковского счета.

     @return Объект класса AccountResponse, содержащий информацию о созданном банковском счете.
     */
    public AccountResponse openAccount(OpenAccountRequest openAccountRequest) {
// создание нового счета
        Account account = new Account();
        account.setOwnerId(openAccountRequest.getOwnerId());

        account.setAccountNumber(UUID.randomUUID().toString());
        account.setBalance(BigDecimal.ZERO);

// сохранение счета в базе данных
        account = accountRepository.save(account);

// создание и возврат AccountResponse
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setOwnerId(account.getOwnerId());
        accountResponse.setBalance(account.getBalance());
        return accountResponse;
    }

    /**

     Метод для закрытия банковского счета по его идентификатору.

     @param accountId дентификатор банковского счета, который необходимо закрыть.

     @throws RuntimeException Если счет не найден или на нем имеется ненулевой баланс.
     */
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

    /**

     Метод для получения информации о банковском счете по его идентификатору.

     @param accountId дентификатор банковского счета, информацию о котором необходимо получить.

     @return Объект класса AccountResponse, содержащий информацию о запрошенном банковском счете.

     @throws RuntimeException Если счет не найден.
     */
    public AccountResponse getAccountDetails(Long accountId) {
// поиск счета по идентификатору
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Счет не найден"));

// создание и возврат AccountResponse
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(account.getId());
        accountResponse.setOwnerId(account.getOwnerId());
        accountResponse.setBalance(account.getBalance());
        return accountResponse;
    }
}