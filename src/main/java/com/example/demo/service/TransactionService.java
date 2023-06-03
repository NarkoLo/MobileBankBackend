package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.OpenAccountRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.model.TransferRequest;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    public TransactionResponse transfer(TransferRequest transferRequest) {
        // реализация бизнес-логики для перевода денег между счетами
        Account sender = accountRepository.findByAccountNumber(transferRequest.getSenderAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Sender account not found"));

        Account recipient = accountRepository.findByAccountNumber(transferRequest.getRecipientAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Recipient account not found"));

        if (sender.getBalance().compareTo(transferRequest.getAmount()) < 0) {
            throw new InsufficientBalanceException("Insufficient balance");
        }

        sender.setBalance(sender.getBalance().subtract(transferRequest.getAmount()));
        recipient.setBalance(recipient.getBalance().add(transferRequest.getAmount()));

        accountRepository.saveAll(Arrays.asList(sender, recipient));

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setRecipient(recipient);
        transaction.setAmount(transferRequest.getAmount());
        transaction = transactionRepository.save(transaction);

        return new TransactionResponse(transaction.getId(), transaction.getSender().getAccountNumber(),
                transaction.getRecipient().getAccountNumber(), transaction.getAmount(), transaction.getTimestamp());
    }

    public List<TransactionResponse> getAllTransactions() {
        // реализация бизнес-логики для вывода всех транзакций
    }

    public List<TransactionResponse> getTransactionsByUser(Long userId) {
        // реализация бизнес-логики для вывода транзакций пользователя
    }

    public List<TransactionResponse> getTransactionsByAccount(Long accountId) {
        // реализация бизнес-логики для вывода транзакций счета
    }

    public AccountResponse openAccount(OpenAccountRequest openAccountRequest) {
    }
}
