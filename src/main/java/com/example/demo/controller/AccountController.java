package com.example.demo.controller;

import com.example.demo.model.AccountResponse;
import com.example.demo.model.OpenAccountRequest;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final TransactionService transactionService;
    public AccountController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/open")
    public ResponseEntity<AccountResponse> openAccount(@RequestBody OpenAccountRequest openAccountRequest) {
        AccountResponse accountResponse = transactionService.openAccount(openAccountRequest);
        return ResponseEntity.ok(accountResponse);
    }

    @PostMapping("/close/{accountId}")
    public ResponseEntity<Void> closeAccount(@PathVariable Long accountId) {
        transactionService.closeAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccountDetails(@PathVariable Long accountId) {
        AccountResponse accountResponse = transactionService.getAccountDetails(accountId);
        return ResponseEntity.ok(accountResponse);
    }
}
