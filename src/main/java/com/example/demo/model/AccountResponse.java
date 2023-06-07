package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * DTO-объект для передачи информации о банковском счете клиенту.
 */
@Getter
@Setter
public class AccountResponse {

    /**
     * дентификатор счета.
     */
    private Long id;

    /**
     * Номер счета.
     */
    private String accountNumber;

    /**
     * Баланс счета.
     */
    private BigDecimal balance;

    /**
     * дентификатор владельца счета.
     */
    private Long ownerId;
}
