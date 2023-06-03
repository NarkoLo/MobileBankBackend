package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountResponse {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Long ownerId;
}
