package Chitava.Task1.controller;

import Chitava.Task1.model.WorkNote;
import Chitava.Task1.service.WorkNoteService;
import lombok.AllArgsConstructor;
import org.hibernate.PropertyValueException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Locale;

@Controller
@RequestMapping("/note")
@AllArgsConstructor
public class RestController {
    /**
     * Сервис для работы с заметками
     */
    private final WorkNoteService service;

    /**
     * Обработка запроса на получение всех заметок
     *
     * @return коллекцию всех заметок или null если пустая база данных
     */
    @GetMapping("/all")
    public ResponseEntity<Collection<WorkNote>> getAllNotes() {
        try {
            return new ResponseEntity<>(service.getAllNotes(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Обработка запроса на создание заметки
     *
     * @param note
     * @return созданная заметка или null если возникла ошибка
     */
    @PostMapping("/create")
    public ResponseEntity<WorkNote> createProduct(@RequestBody WorkNote note) {
        try {
            return new ResponseEntity<>(service.createNote(note), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Обработка запроса поиска заметки по идентификатору
     * @param id идентификатор
     * @return заметка с идентификатором или null если ошибка данных
     */
    @GetMapping("/find/{id}")
    public ResponseEntity<WorkNote> findNoteByID(@PathVariable("id") Long id) {
        System.out.println(id);
        try {
            WorkNote noteById = service.getNoteById(id);
            return new ResponseEntity<>(noteById, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


    @PutMapping("/update")
    public ResponseEntity<WorkNote> editNote (@RequestBody WorkNote note){
        try {
            return new ResponseEntity<>(service.updateNote(note), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNote(@PathVariable("id") Long id){
        try {
            WorkNote note = service.getNoteById(id);
            service.deleteNote(id);
            return new ResponseEntity(String.format("Запись %s удалена", note.getHeader()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }


}
