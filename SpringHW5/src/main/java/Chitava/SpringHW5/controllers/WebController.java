package Chitava.SpringHW5.controllers;
import Chitava.SpringHW5.models.Noute;
import Chitava.SpringHW5.models.Status;
import Chitava.SpringHW5.services.EnumConverter;
import Chitava.SpringHW5.services.NoteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

    @PostMapping("/notecreate")
    public String createNote (@RequestParam(value = "annotation")Noute noute, Model model){
        service.saveNote(noute);
        Collection<Noute> notes = service.findAllNotes();
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
        Optional note = service.getById(id);
        try {
            model.addAttribute("note", note.get());
            return "note";
        } catch (NoSuchElementException e) {
            model.addAttribute("message", e.getMessage());
            return "404";
        }
    }

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

    @PutMapping("edit/{id}")
    public String chengenNoteStatus(@PathVariable Long id, @RequestBody String stat, Model model){
        service.updateStatusNote(id, converter.convertToEntityAttribute(stat));
        model.addAttribute(service.findAllNotes());
        return "index";
    }


}

