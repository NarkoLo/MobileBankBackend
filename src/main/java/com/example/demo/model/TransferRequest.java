package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**

 DTO-объект представляющий собой запрос на перевод денежных средств между счетами.
 */
@Getter
@Setter
public class TransferRequest {

    /**

     Номер счета, с которого производится перевод.
     */
    private String fromAccountNumber;
    /**

     Номер счета, на который производится перевод.
     */
    private String toAccountNumber;
    /**

     Сумма, которую необходимо перевести.
     */
    private BigDecimal amount;
}
