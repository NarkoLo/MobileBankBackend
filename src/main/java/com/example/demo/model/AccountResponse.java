package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountResponse {
    private Long id;
    private String accountNumber;
    private Double balance;
    private Long ownerId;
}
