package Chitava.SpringHW5.controllers;
import Chitava.SpringHW5.models.Noute;
import Chitava.SpringHW5.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * REST Контроллер для работы с запросами
 */
@AllArgsConstructor
@RestController
public class RESTController {
    /**
     * Сервис для работы с записками
     */
    final NoteService service;

    /**
     * Метод записи записки в базу данных
     * @param note записка
     */
    @PostMapping("/create")
    public void createNote (@RequestBody Noute note){
        service.saveNote(note);
    }






}
