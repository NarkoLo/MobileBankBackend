package com.example.demo.dao;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class TransactionDAO {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionDAO(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Transactional
    public void save(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }


    public List<Transaction> findBySenderId(Long senderId) {
        return transactionRepository.findBySenderId(senderId);
    }

    public List<Transaction> findByRecipientId(Long recipientId) {
        return transactionRepository.findByRecipientId(recipientId);
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }
}
