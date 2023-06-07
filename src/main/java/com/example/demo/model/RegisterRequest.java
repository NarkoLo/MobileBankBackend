package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-объект для передачи информации о запросе на регистрацию нового пользователя.
 */
@Getter
@Setter
public class RegisterRequest {

    /**
     * мя пользователя.
     */
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    private String lastName;

    /**
     * Электронная почта пользователя.
     */
    private String email;

    /**
     * Пароль пользователя.
     */
    private String password;
}