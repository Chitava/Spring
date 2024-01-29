package Chitava.Task1.service;

import Chitava.Task1.model.WorkNote;
import Chitava.Task1.repository.NoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Класс работы с заметками в хранилище через интерфейс
 */
import java.util.Collection;
@Service
@AllArgsConstructor
public class WorkNoteService implements NoteService{
    /**
     * Хранилище заметок
     */
    private final NoteRepository repository;

    /**
     * Метод получения всех заметок
     * @return коллекцию всех заметок
     */
    @Override
    public Collection<WorkNote> getAllNotes() {
        return repository.findAll();
    }

    /**
     * Метод получения заметки по идентификатору
     * @param id идентификатор заметки
     * @return искомую заметку
     */
    @Override
    public WorkNote getNoteById(Long id) {
        return repository.findWorkNoteById(id);
    }

    /**
     * Метод обновление заметки
     * @param note заметка
     * @return измененная заметка
     */
    @Override
    public WorkNote updateNote(WorkNote note) {
        WorkNote noteById = getNoteById(note.getId());
        noteById.setHeader(note.getHeader());
        noteById.setAnotation(note.getAnotation());
        return repository.save(noteById);
    }

    /**
     * Мотод создания заметки
     * @param note заметка
     * @return новая заметка
     */
    @Override
    public WorkNote createNote(WorkNote note) {
        return repository.save(note);
    }

    /**
     * Метод удаления заметки
     * @param id идентификатор удаляемой заметки
     */
    @Override
    public void deleteNote(Long id) {
        WorkNote note = repository.getById(id);
        repository.delete(note);

    }
}
