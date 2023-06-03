package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
public class TransactionResponse {
    private Long id;
    private String fromAccountNumber;
    private String toAccountNumber;
    private BigDecimal amount;
    private LocalDateTime timestamp;
}
