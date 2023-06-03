package com.example.demo.controller;

import com.example.demo.model.AccountResponse;
import com.example.demo.model.OpenAccountRequest;
import com.example.demo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/open")
    public ResponseEntity<AccountResponse> openAccount(@RequestBody OpenAccountRequest openAccountRequest) {
        AccountResponse accountResponse = accountService.openAccount(openAccountRequest);
        return ResponseEntity.ok(accountResponse);
    }

    @PostMapping("/close/{accountId}")
    public ResponseEntity<Void> closeAccount(@PathVariable Long accountId) {
        accountService.closeAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccountDetails(@PathVariable Long accountId) {
        AccountResponse accountResponse = accountService.getAccountDetails(accountId);
        return ResponseEntity.ok(accountResponse);
    }
}
