package com.example.demo.dao;

import com.example.demo.entity.Account;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * DAO для работы с пользователями.
 */
@Component
public class UserDAO {

    private final UserRepository userRepository;

    /**
     * Конструктор класса.
     *
     * @param userRepository репозиторий для работы с пользователями
     */
    @Autowired
    public UserDAO(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Сохраняет пользователя в базе данных.
     *
     * @param user пользователь
     */
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    /**
     * Находит пользователя по его идентификатору.
     *
     * @param id идентификатор пользователя
     * @return объект User или null, если пользователь не найден
     */
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * Находит пользователя по его электронной почте.
     *
     * @param email электронная почта пользователя
     * @return объект User или null, если пользователь не найден
     */
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }

    /**
     * Находит всех пользователей в базе данных.
     *
     * @return список пользователей
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * Удаляет пользователя из базы данных.
     *
     * @param user пользователь
     */
    @Transactional
    public void delete(User user) {
        userRepository.delete(user);
    }
}
