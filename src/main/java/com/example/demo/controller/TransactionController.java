package com.example.demo.controller;

import com.example.demo.model.TransactionResponse;
import com.example.demo.model.TransferRequest;
import com.example.demo.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransactionResponse> transfer(@RequestBody TransferRequest transferRequest) {
        TransactionResponse transactionResponse = transactionService.transfer(transferRequest);
        return ResponseEntity.ok(transactionResponse);
    }
}
