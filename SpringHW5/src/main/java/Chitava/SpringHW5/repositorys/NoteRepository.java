package Chitava.SpringHW5.repositorys;
import Chitava.SpringHW5.models.Note;
import Chitava.SpringHW5.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;


/**
 * Класс работы с заметками в хранилище
 */

@Repository
@Transactional
public interface NoteRepository extends JpaRepository<Note, Long> {


    /**
     * Метод поиска заметки по статусу
     * @param status статус заметки
     * @return Коллекцию записок
     */
    Collection<Note> findByStatus(Status status);


//    @Modifying
//    @Query("UPDATE notes n SET n.annotation =:annotation, n.status =:status WHERE n.id =:id" )
//    void updateNoteById(@Param("annotation") String annotation, @Param("status") Status status, @Param("id") Long id);


//    void updateResponsibleNoteByID(Long id);


}