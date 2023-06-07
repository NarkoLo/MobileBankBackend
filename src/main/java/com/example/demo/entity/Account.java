package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Сущность банковского счета.
 */
@Entity
@Table(name = "accounts")
@Getter
@Setter
public class Account {

    /**
     * дентификатор счета.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     Номер счета.
     */
    @Column(nullable = false, unique = true)
    private String accountNumber;

    /**
     * Баланс счета.
     */
    @Column(nullable = false)
    private BigDecimal balance;

    /**
     * дентификатор владельца счета.
     */
    @Column(nullable = false)
    private Long ownerId;

    /**
     * Владелец счета.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

}