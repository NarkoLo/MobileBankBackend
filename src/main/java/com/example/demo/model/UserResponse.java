package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-объект для представляющий ответ на запрос пользователя.
 */
@Getter
@Setter
public class UserResponse {

    /**
     * Уникальный идентификатор пользователя.
     */
    private Long id;

    /**
     * мя пользователя.
     */
    private String firstName;

    /**
     * Фамилия пользователя.
     */
    private String lastName;

    /**
     * Адрес электронной почты пользователя.
     */
    private String email;
}
