package com.example.sem3HomeTask.services;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

//region поля
    /**
     * Репозиторий с пользователями
     */
    @Autowired
    private UserRepository repository;
//ebdregion

//region getters setters
    public UserRepository getRepository() {
        return repository;
    }
//endregion

//region методы

    /**
     * Метод сортировки пользователей по возрасту
      * @param users
     * @return
     */
    public List<User> sortUsersByAge(List<User> users) {
        return users.stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    /**
     * Метод фильтрации по возрасту
     * @param users
     * @param age
     * @return
     */
    public List<User> filterUsersByAge(List<User> users, int age) {
        return users.stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    /**
     * Метод вычисления средноего возраста всех пользователей
     * @param users
     * @return
     */
    public double calculateAverageAge(List<User> users) {
        return users.stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }

    /**
     * Метод добавления пользователя в репозиторий
     * @param user
     */

    public void  addUserToList(User user)
    {
        repository.getUsers().add(user);
    }
//endregion
}
