package com.example.demo.repository;

import com.example.demo.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**

 нтерфейс, представляющий репозиторий для работы с банковскими транзакциями.
 */
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    /**

     Метод для поиска списка транзакций по идентификатору отправителя.
     @param senderId дентификатор отправителя транзакций.
     @return Список объектов класса Transaction, содержащих транзакции, отправленные указанным отправителем.
     */
    List<Transaction> findBySenderId(Long senderId);
    /**

     Метод для поиска списка транзакций по идентификатору получателя.
     @param recipientId дентификатор получателя транзакций.
     @return Список объектов класса Transaction, содержащих транзакции, полученные указанным получателем.
     */
    List<Transaction> findByRecipientId(Long recipientId);
}
