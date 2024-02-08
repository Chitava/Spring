package ru.chitava.webclient.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.chitava.webclient.model.Student;
import ru.chitava.webclient.service.WebServise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


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
    public String addStudent(){
        return "add";
    }
}
