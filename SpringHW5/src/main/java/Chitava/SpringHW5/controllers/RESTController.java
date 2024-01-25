package Chitava.SpringHW5.controllers;
import Chitava.SpringHW5.models.Noute;
import Chitava.SpringHW5.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
public class RESTController {
    @Autowired
    NoteService service;

    @PostMapping("/create")
    public void createNote (@RequestBody Noute note){
        service.saveNote(note);
    }




}
