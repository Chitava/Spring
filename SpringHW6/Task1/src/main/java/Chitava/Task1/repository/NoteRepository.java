package Chitava.Task1.repository;

import Chitava.Task1.model.WorkNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Интерфейс работы с хранилещем заметов
 */
@Repository
public interface NoteRepository extends JpaRepository<WorkNote, Long> {
    WorkNote findWorkNoteById(Long id);
}
