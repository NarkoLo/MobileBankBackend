package com.example.demo.repository;

import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**

 нтерфейс, представляющий репозиторий для работы с банковскими счетами.
 */
public interface AccountRepository extends JpaRepository<Account, Long> {

    /**

     Метод для поиска банковского счета по его номеру.
     @param accountNumber Номер банковского счета, который необходимо найти.
     @return Объект класса Optional, содержащий банковский счет с указанным номером, если такой счет существует, иначе пустой объект Optional.
     */
    Optional<Account> findByAccountNumber(String accountNumber);
    /**

     Метод для поиска списка банковских счетов по идентификатору их владельца.
     @param ownerId дентификатор владельца банковских счетов.
     @return Список объектов класса Account, содержащих банковские счета, принадлежащие указанному владельцу.
     */
    List<Account> findByOwnerId(Long ownerId);
}