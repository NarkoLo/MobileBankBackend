package com.example.demo.controller;

import com.example.demo.model.TransactionResponse;
import com.example.demo.model.TransferRequest;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**

 Controller for managing transactions via REST API.
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    /**

     Class constructor.
     @param transactionService service for working with transactions
     */
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    /**

     Transfers funds between bank accounts.
     @param transferRequest data for transferring funds
     @return ResponseEntity object with data about the transaction and HTTP status 200 (OK)
     */
    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> transfer(@RequestBody TransferRequest transferRequest) {
        TransactionResponse transactionResponse = transactionService.transfer(transferRequest);
        return ResponseEntity.ok(transactionResponse);
    }
}