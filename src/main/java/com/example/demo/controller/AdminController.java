package com.example.demo.controller;

import com.example.demo.model.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminController {
    private final TransactionService transactionService;

    public AdminController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        List<TransactionResponse> transactionResponses = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactionResponses);
    }

    @GetMapping("/transactions/user/{userId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByUser(@PathVariable Long userId) {
        List<TransactionResponse> transactionResponses = transactionService.getTransactionsByUser(userId);
        return ResponseEntity.ok(transactionResponses);
    }

    @GetMapping("/transactions/account/{accountId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByAccount(@PathVariable Long accountId) {
        List<TransactionResponse> transactionResponses = transactionService.getTransactionsByAccount(accountId);
        return ResponseEntity.ok(transactionResponses);
    }
}
