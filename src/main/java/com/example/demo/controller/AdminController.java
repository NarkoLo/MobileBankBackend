package com.example.demo.controller;

import com.example.demo.model.TransactionResponse;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**

 Controller for managing transactions via REST API for an administrator.
 */
@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final TransactionService transactionService;

    /**

     Class constructor.
     @param transactionService service for working with transactions
     */
    public AdminController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**

     Returns all transactions.
     @return ResponseEntity object with a list of all transactions and HTTP status 200 (OK)
     */
    @GetMapping("/transactions")
    public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
        List<TransactionResponse> transactionResponses = transactionService.getAllTransactions();
        return ResponseEntity.ok(transactionResponses);
    }

    /**

     Returns all transactions for the specified user.
     @param userId user identifier
     @return ResponseEntity object with a list of transactions for the user and HTTP status 200 (OK)
     */
    @GetMapping("/transactions/user/{userId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByUser(@PathVariable Long userId) {
        List<TransactionResponse> transactionResponses = transactionService.getTransactionsByUser(userId);
        return ResponseEntity.ok(transactionResponses);
    }

    /**

     Returns all transactions for the specified account.
     @param accountId account identifier
     @return ResponseEntity object with a list of transactions for the account and HTTP status 200 (OK)
     */
    @GetMapping("/transactions/account/{accountId}")
    public ResponseEntity<List<TransactionResponse>> getTransactionsByAccount(@PathVariable Long accountId) {
        List<TransactionResponse> transactionResponses = transactionService.getTransactionsByAccount(accountId);
        return ResponseEntity.ok(transactionResponses);
    }
}