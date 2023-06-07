package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-объект для передачи информации о запросе на вход в систему.
 */
@Getter
@Setter
public class LoginRequest {

    /**
     * Электронная почта пользователя.
     */
    private String email;

    /**
     * Пароль пользователя.
     */
    private String password;
}