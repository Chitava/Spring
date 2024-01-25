package Chitava.SpringHW5.repositorys;
import Chitava.SpringHW5.models.Noute;
import Chitava.SpringHW5.models.Status;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;


/**
 * Класс работы с заметками в хранилище
 */

@Repository
public interface NoteRepository extends JpaRepository<Noute, Long> {
    /**
     * Метод поиска заметки по статусу
     * @param status статус заметки
     * @return Коллекцию записок
     */
//    @Query("SELECT * FROM notes WHERE status = :status")
//    List<Noute> findByStatus (String status);



    /**
     * Метод изменения статуса записки
     * @param id идентификатор записки
     * @param status статус записки
     */
//    @Modifying
//    @Query("UPDATE notes SET status = :status WHERE id = :id")
//    void changeStatus(Long id, String status);
}
