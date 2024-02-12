package ru.chitava.webclient.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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

    /**
     * Метод обработки запроса страницы со списком всех студентов
     * @param model модель отображения
     * @return страницу со всеми студентами
     */


    /**
     * Метод обработки запроса списка всех студентов
     * @param model модель отображения
     * @return
     */
    @GetMapping("/all")
    public String allStudents(Model model){
        Student[] students = service.getAllstudents();
        model.addAttribute("students", students);
        return "all";
    }

    /**
     * Метод обработки запроса страницы добавления нового студента
     * @param model модель отображения
     * @param student пустой объект если для корректного отображения на странице
     * @return
     */
    @GetMapping("/add")
    public String add (Model model, Student student){
        model.addAttribute("student", student);
        return "add";
    }


    /**
     *
     * Метод добавления новго студента
     * @param student параметры студента
     * @param model модель отображения
     * @return страница со всеми студентами
     */
    @PostMapping("/addstudent")
    public String addStudent(Student student, Model model){
        ResponseEntity response = service.addStudent(student);
        if (response.getStatusCode().is2xxSuccessful()) {
            model.addAttribute("students", service.getAllstudents());
            return "all";
        }
        return "error";
    }

    /**
     * Метод удаления записи о студенте из бвзы данных
     * @param id идентификатор удаляемой записи
     * @param model модель отображения
     * @return страница со всеми пользователями
     */
    @GetMapping("/delstudent/{id}")
    public String delstudent(@PathVariable("id") Long id, Model model){
        service.delStudent(id);
        model.addAttribute("students", service.getAllstudents());
        return "all";
    }


}
