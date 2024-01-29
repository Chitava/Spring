package Chitava.Task1.service;

import Chitava.Task1.model.WorkNote;

import java.util.Collection;

/**
 * Интерфейс для работы с заметками в хранилище
 */
public interface NoteService {
    /**
     * Метод получения всех заметок
     * @return коллекцию всех заметок
     */
    Collection<WorkNote> getAllNotes();

    /**
     * Метод получения заметки по идентификатору
     * @param id идентификатор заметки
     * @return искомую заметку
     */
    WorkNote getNoteById(Long id);

    /**
     * Метод обновление заметки
     * @param note заметка
     * @return измененная заметка
     */
    WorkNote updateNote(WorkNote note);

    /**
     * Мотод создания заметки
     * @param note заметка
     * @return новая заметка
     */
    WorkNote createNote(WorkNote note);

    /**
     * Метод удаления заметки
     * @param id идентификатор удаляемой заметки
     */
    void deleteNote(Long id);
}
