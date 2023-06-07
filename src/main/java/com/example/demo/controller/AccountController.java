package com.example.demo.controller;

import com.example.demo.model.AccountResponse;
import com.example.demo.model.OpenAccountRequest;
import com.example.demo.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**

 Controller for managing bank accounts via REST API.
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    /**

     Class constructor.
     @param accountService service for working with bank accounts
     */
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    /**

     Creates a new bank account.
     @param openAccountRequest data for opening a new account
     @return ResponseEntity object with data about the created account and HTTP status 200 (OK)
     */
    @PostMapping("/open")
    public ResponseEntity<AccountResponse> openAccount(@RequestBody OpenAccountRequest openAccountRequest) {
        AccountResponse accountResponse = accountService.openAccount(openAccountRequest);
        return ResponseEntity.ok(accountResponse);
    }

    /**

     Closes an existing bank account.
     @param accountId account identifier
     @return ResponseEntity object with HTTP status 204 (NO CONTENT)
     */
    @PostMapping("/close/{accountId}")
    public ResponseEntity<Void> closeAccount(@PathVariable Long accountId) {
        accountService.closeAccount(accountId);
        return ResponseEntity.noContent().build();
    }

    /**

     Returns data about an existing bank account.
     @param accountId account identifier
     @return ResponseEntity object with data about the account and HTTP status 200 (OK)
     */
    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponse> getAccountDetails(@PathVariable Long accountId) {
        AccountResponse accountResponse = accountService.getAccountDetails(accountId);
        return ResponseEntity.ok(accountResponse);
    }
}