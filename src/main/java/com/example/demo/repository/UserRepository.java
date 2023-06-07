package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**

 нтерфейс, представляющий репозиторий для работы с пользователями системы.
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**

     Метод для поиска пользователя по электронной почте.
     @param email Адрес электронной почты, для которого необходимо найти пользователя.
     @return Объект класса Optional, содержащий пользователя с указанным адресом электронной почты, если такой пользователь существует, иначе пустой объект Optional.
     */
    Optional<User> findByEmail(String email);
    /**

     Метод для проверки наличия пользователя с указанным адресом электронной почты.
     @param email Адрес электронной почты, наличие которого необходимо проверить.
     @return true, если пользователь с указанным адресом электронной почты существует, иначе false.
     */
    boolean existsByEmail(String email);
}