package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Transaction;
import com.example.demo.model.AccountResponse;
import com.example.demo.model.OpenAccountRequest;
import com.example.demo.model.TransactionResponse;
import com.example.demo.model.TransferRequest;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TransactionRepository;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
import java.util.*;

@Service
public class TransactionService {
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository) {
        this.accountRepository = accountRepository;
        this.transactionRepository = transactionRepository;
    }

    @SneakyThrows
    public TransactionResponse transfer(TransferRequest transferRequest){
        // реализация бизнес-логики для перевода денег между счетами
        Account sender = accountRepository.findByAccountNumber(transferRequest.getFromAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Отправитель не найден"));

        Account recipient = accountRepository.findByAccountNumber(transferRequest.getToAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Получатель не найден"));


        sender.setBalance(sender.getBalance().subtract(transferRequest.getAmount()));
        recipient.setBalance(recipient.getBalance().add(transferRequest.getAmount()));

        accountRepository.saveAll(Arrays.asList(sender, recipient));

        Transaction transaction = new Transaction();
        transaction.setSender(sender);
        transaction.setRecipient(recipient);
        transaction.setAmount(transferRequest.getAmount());
        transaction = transactionRepository.save(transaction);

        return new TransactionResponse(transaction.getId(), transaction.getSender().getAccountNumber(),
                transaction.getRecipient().getAccountNumber(), transaction.getAmount(), transaction.getDate());
    }

    public List<TransactionResponse> getAllTransactions() {
        // реализация бизнес-логики для вывода всех транзакций
        List<Transaction> transactions = transactionRepository.findAll();
        return mapToTransactionResponseList(transactions);
    }

    public List<TransactionResponse> getTransactionsByUser(Long userId) {
        // реализация бизнес-логики для вывода транзакций пользователя
        List<Account> accounts = accountRepository.findByOwnerId(userId);
        List<Transaction> transactions = new ArrayList<>();

        for (Account account : accounts) {
            transactions.addAll(transactionRepository.findBySenderId(account.getId()));
            transactions.addAll(transactionRepository.findByRecipientId(account.getId()));
        }
        transactions.sort(Comparator.comparing(Transaction::getDate).reversed());
        return mapToTransactionResponseList(transactions);
    }



    public List<TransactionResponse> getTransactionsByAccount(Long accountId) {
        // реализация бизнес-логики для вывода транзакций счета
        List<Transaction> transactions = new ArrayList<>();
        transactions.addAll(transactionRepository.findBySenderId(accountId));
        transactions.addAll(transactionRepository.findByRecipientId(accountId));

        transactions.sort(Comparator.comparing(Transaction::getDate).reversed());
        return mapToTransactionResponseList(transactions);
    }




    private List<TransactionResponse> mapToTransactionResponseList(List<Transaction> transactions) {
        List<TransactionResponse> transactionResponses = new ArrayList<>();

        for (Transaction transaction : transactions) {
            transactionResponses.add(new TransactionResponse(transaction.getId(),
                    transaction.getSender().getAccountNumber(), transaction.getRecipient().getAccountNumber(),
                    transaction.getAmount(), transaction.getDate()));
        }

        return transactionResponses;
    }
}
