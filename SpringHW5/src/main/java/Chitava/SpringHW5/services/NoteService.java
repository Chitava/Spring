package Chitava.SpringHW5.services;

import Chitava.SpringHW5.models.Note;
import Chitava.SpringHW5.models.Status;
import Chitava.SpringHW5.repositorys.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Класс работы с заметками
 */
@Service
@AllArgsConstructor
public class NoteService {
    //region поля
    /**
     * Создаем репозиторий
     */
    NoteRepository repository;
    //endregion

    //region методы

    /**
     * Метод вывода всех заметок
     *
     * @return коллекцию заметок
     */
    public Collection<Note> findAllNotes() {
        return (Collection<Note>) repository.findAll();
    }

    /**
     * Метод поиска по идентификатору
     *
     * @param id идентификатор
     * @return заметку с идентификационным номером
     */
    public Note getById(Long id) {
        Optional note = repository.findById(id);

        if (note.isPresent()){return repository.findById(id).get();}
        return new Note();
    }

    /**
     * Метод сохранения записки в базу данных
     *
     * @param note записка
     */
    public void saveNote(Note note) {
        repository.save(note);
    }

    /**
     * Метод удаления записки
     *
     * @param id идентификационный номер
     */
    public void deleteNode(Long id) {
        repository.deleteById(id);
    }

    /**
     * @param status
     * @return
     */
    public Collection<Note> findeByStatus(Status status) {

        return repository.findByStatus(status);
    }


    /**
     * @param note записка
     *
     */
//    public void updateNote(Note note) {
//        repository.updateNoteById(note.getAnnotation(), note.getStatus(), note.getId());
//        repository.updateResponsibleNoteByID(note.getId());
//        }
    //endregion
    }






