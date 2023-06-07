package com.example.demo.dao;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * DAO для работы с транзакциями.
 */
@Component
public class TransactionDAO {

    private final TransactionRepository transactionRepository;

    /**
     * Конструктор класса.
     *
     * @param transactionRepository репозиторий для работы с транзакциями
     */
    @Autowired
    public TransactionDAO(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Сохраняет транзакцию в базе данных.
     *
     * @param transaction транзакция
     */
    @Transactional
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    /**
     * Находит транзакцию по ее идентификатору.
     *
     * @param id идентификатор транзакции
     * @return объект Transaction или null, если транзакция не найдена
     */
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }

    /**
     * Находит все транзакции, отправленные с указанного банковского счета.
     *
     * @param senderId идентификатор отправителя
     * @return список транзакций
     */
    public List<Transaction> findBySenderId(Long senderId) {
        return transactionRepository.findBySenderId(senderId);
    }

    /**
     * Находит все транзакции, полученные на указанный банковский счет.
     *
     * @param recipientId идентификатор получателя
     * @return список транзакций
     */
    public List<Transaction> findByRecipientId(Long recipientId) {
        return transactionRepository.findByRecipientId(recipientId);
    }

    /**
     * Находит все транзакции в базе данных.
     *
     * @return список транзакций
     */
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}