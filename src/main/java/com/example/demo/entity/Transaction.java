package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Сущность банковской транзакции.
 */
@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transaction {

    /**
     * дентификатор транзакции.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Сумма транзакции.
     */
    @Column(nullable = false)
    private BigDecimal amount;

    /**
     * Дата и время транзакции.
     */
    @Column(nullable = false)
    private LocalDateTime date;

    /**
     * Счет отправителя.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender_id", nullable = false)
    private Account sender;

    /**
     * Счет получателя.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient_id", nullable = false)
    private Account recipient;

    /**
     * Конструктор класса.
     */
    public Transaction() {
        this.date = LocalDateTime.now();
    }
}