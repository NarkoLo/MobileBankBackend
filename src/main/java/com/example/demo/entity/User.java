package com.example.demo.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Сущность пользователя.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
public class User {

    /**
     * дентификатор пользователя.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * мя пользователя.
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * Электронная почта пользователя.
     */
    @Column(nullable = false, unique = true)
    private String email;

    /**
     * Пароль пользователя.
     */
    @Column(nullable = false)
    private String password;

    /**
     * Счета пользователя.
     */
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Account> accounts;

}
