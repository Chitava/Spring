package Chitava.SpringHW5.services;
import Chitava.SpringHW5.models.Noute;
import Chitava.SpringHW5.repositorys.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

/**
 * Класс работы с заметками
 */
@Service
public class NoteService {
    //region методы
    /**
     * Метод вывода всех заметок
     * @return коллекцию заметок
     */
    public Collection<Noute> findAllNotes(){
        return (Collection<Noute>) repository.findAll();
    }

    /**
     * Метод поиска по идентификатору
     *
     * @param id идентификатор
     * @return заметку с идентификационным номером
     */
    public Optional<Noute> getById (Long id){
        return repository.findById(id);
    }

    /**
     * Метод сохранения записки в базу данных
     * @param note записка
     */
    public void saveNote(Noute note) {
        repository.save(note);
    }

    /**
     * Метод удаления записки
     * @param id идентификационный номер
     */
    public void deleteNode (Long id){
        repository.deleteById(id);
    }

    /**
     * Метод обновления статуса записки
     * @param id идентификатор
     * @param status статус
     */
//    public void updateStatusNote(Long id, String status){
//        repository.changeStatus(id, status);
//    }
    //endregion

    //region поля
    /**
     * Создаем репозиторий
     */
    @Autowired
    private NoteRepository repository;
    //endregion

    //region конструкторы
    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }
    //endregion
}
