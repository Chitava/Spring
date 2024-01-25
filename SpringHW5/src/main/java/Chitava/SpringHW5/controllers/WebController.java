package Chitava.SpringHW5.controllers;

import Chitava.SpringHW5.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @Autowired
    NoteService service;
    @GetMapping("/all")
    public String allNotes(Model model){
        model.addAttribute("notes", service.findAllNotes());
        service.findAllNotes().stream().forEach(p -> System.out.println(p));
        return "index";
    }
}
