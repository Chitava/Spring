package ru.chitava.webclient.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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
    public String allStudent(Model model){
        Student[] students = service.getAllstudents();
        model.addAttribute("students", students);

        return "all";

    }
}
