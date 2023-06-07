package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

/**
 * DTO-объект для передачи информации о запросе на открытие нового банковского счета.
 */
@Getter
@Setter
public class OpenAccountRequest {

    /**
     * дентификатор владельца счета.
     */
    private Long ownerId;
}
