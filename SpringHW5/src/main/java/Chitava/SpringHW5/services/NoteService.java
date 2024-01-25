package Chitava.SpringHW5.services;

import Chitava.SpringHW5.models.Noute;
import Chitava.SpringHW5.models.Status;
import Chitava.SpringHW5.repositorys.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Collection<Noute> findAllNotes() {
        return (Collection<Noute>) repository.findAll();
    }

    /**
     * Метод поиска по идентификатору
     *
     * @param id идентификатор
     * @return заметку с идентификационным номером
     */
    public Optional<Noute> getById(Long id) {
        return repository.findById(id);
    }

    /**
     * Метод сохранения записки в базу данных
     *
     * @param note записка
     */
    public void saveNote(Noute note) {
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
     *
     * @param status
     * @return
     */
    public Collection<Noute> findeByStatus(Status status) {

        return repository.findByStatus(status);
    }


    /**
     * Метод обновления статуса записки
     * @param status статус
     * @param id идентификатор записки
     */
    public void updateStatusNote(Long id, Status status){
        repository.updateStatus(status, id);

    }
        //endregion




    }

