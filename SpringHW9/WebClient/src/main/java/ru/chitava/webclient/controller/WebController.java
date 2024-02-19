package ru.chitava.webclient.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.chitava.webclient.model.Student;
import ru.chitava.webclient.service.WebServise;


@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class WebController {
    private WebServise service;

    @GetMapping("/all")
    public String allStudents(Model model){
        Student[] students = service.getAllstudents();
        model.addAttribute("students", students);
        return "all";
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("student", new Student());
        return "add";
    }

    @RequestMapping(value = "/addstudent", method = RequestMethod.POST)
    public void addStudent(Student student, Model model){
        service.addStudent(student);
        allStudents(model);
    }
}
