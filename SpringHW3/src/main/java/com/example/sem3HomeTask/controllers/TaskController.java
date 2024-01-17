package com.example.sem3HomeTask.controllers;

import com.example.sem3HomeTask.domain.User;
import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    /**
     * Вывод информации о имеющихся методах в системе
     * @return
     */
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    /**
     * Метод сортировки
     * @return
     */
    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
     * Метод фильтрации пользователей по возрасту
     * @param age
     * @return
     */
    //метод filterUsersByAge
    @GetMapping("/filter/{age}")
    public List<User> filters(@PathVariable("age") int age) {return service.filterUsersByAge(service.getRepository().getUsers(), age);}

    /**
     * Метод подсчета среднего возраста всех пользователей
     *
     * @return
     */
    @GetMapping("/calc")
    public int calc(){return (int) service.calculateAverageAge(service.getRepository().getUsers());}
}
