package Chitava.SpringHW5.controllers;
import Chitava.SpringHW5.models.Note;
import Chitava.SpringHW5.models.Status;
import Chitava.SpringHW5.services.EnumConverter;
import Chitava.SpringHW5.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Контроллер для отображения информации в web
 */
@Controller
@AllArgsConstructor

public class WebController {

    /**
     * Создаем сервис для работы с записками
     */
    final NoteService service;
    final EnumConverter converter;


    /**
     * Выводим стартовую страницу
     * @return index.html
     */
    @GetMapping("/")
    public String index(){
        return "index";
    }

    /**
     * Выводим страницу создания записки
     * @return
     */
   @GetMapping("/create")
   public String createNote(){
        return "createnote";
   }


    /**
     * Создание записки
     * @param annotation Текст записки
     * @param note записка
     * @param model модель
     * @return страницу со всеми записками
     */
    @RequestMapping(value="/notecreate", method= RequestMethod.POST)
    public String createNote (@ModelAttribute("annotation")String annotation, Note note, Model model){
        note.setAnnotation(annotation);
        service.saveNote(note);
        Collection<Note> notes = service.findAllNotes();
        model.addAttribute("notes", notes);
        return "index";
    }

    /**
     * Вывод всех записок
     *
     * @param model модель страницы отображения
     * @return страница со всеми записками
     */
    @GetMapping("/all")
    public String allNotes(Model model) {
        model.addAttribute("notes", service.findAllNotes());
        return "index";
    }

    /**
     * Метод вывода страницы по id
     *
     * @param id    идентификатор
     * @param model модель страницы отображения
     * @return страница с запиской с искомым идентификационным номером
     */
    @GetMapping("/note/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Note note = service.getById(id);
        model.addAttribute("note", note);
        return "note";
    }

    /**
     * Ркдактирование заметки
     * @param note заметка
     * @param model модель
     * @return страницу со всеми заметками
     */
//    @RequestMapping(value="/noteedit", method= RequestMethod.POST)
//    public String editNote (Note note, Model model){
//        service.updateNote(note);
//        Collection<Note> notes = service.findAllNotes();
//        model.addAttribute("notes", notes);
//        return "index";
//    }

    /**
     * Метод удаления записки из базы данных
     *
     * @param id    идентификатор
     * @param model модель страницы отображения
     * @return страница со всеми записками
     */
    @DeleteMapping("/delete/{id}")
    public String deletById(@PathVariable Long id, Model model) {
        service.deleteNode(id);
        model.addAttribute(service.findAllNotes());
        return "index";
    }

    /**
     * метод поиска заметки по статусу
     * @param stat искомый статус
     * @param model страницы отображения
     * @return страница со всеми отфильтрованными записками
     */
    @PostMapping("/status")
    public String editNote(@RequestBody String stat, Model model){
        Status status = converter.convertToEntityAttribute(stat);
        model.addAttribute("notes", service.findeByStatus(status));
        return "index";
    }




}

