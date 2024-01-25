package Chitava.SpringHW5.controllers;

import Chitava.SpringHW5.models.Noute;
import Chitava.SpringHW5.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.NoSuchElementException;
import java.util.Optional;

@Controller
public class WebController {

    @Autowired
    NoteService service;
    @GetMapping("/all")
    public String allNotes(Model model){
        model.addAttribute("notes", service.findAllNotes());
        return "index";
    }

    @GetMapping("/note/{id}")
    public String findById(@PathVariable Long id, Model model){
        Optional note = service.getById(id);
        try {
            model.addAttribute("note", note.get());
            return "note";
        }catch (NoSuchElementException e){
            model.addAttribute(e.getMessage());
            return "404";
        }
    }
}
