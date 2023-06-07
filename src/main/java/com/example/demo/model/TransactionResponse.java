package com.example.demo.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
/**
 * DTO-объект для передачи информации о банковской транзакции клиенту.
 */
@Getter
@Setter
@AllArgsConstructor
public class TransactionResponse {

    /**
     * дентификатор транзакции.
     */
    private Long id;

    /**
     * Номер счета отправителя.
     */
    private String fromAccountNumber;

    /**
     * Номер счета получателя.
     */
    private String toAccountNumber;

    /**
     * Сумма транзакции.
     */
    private BigDecimal amount;

    /**
     * Временная метка транзакции.
     */
    private LocalDateTime timestamp;
}