package Chitava.SpringHW5;

import Chitava.SpringHW5.models.Note;
import Chitava.SpringHW5.models.Status;
import Chitava.SpringHW5.repositorys.NoteRepository;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Тестирование репозитория
 */
@DataJpaTest

public class TestRepository {

    @Autowired
    private NoteRepository repository;

    private Note firstNote = new Note();

    @BeforeEach
    public void setup() {
        firstNote.setAnnotation("Новая");
        firstNote.setStatus(Status.NOT_STARTED);
        firstNote.setTime("сегодня");
    }

    @DisplayName("JUnit тест сохранение записки")
    @Test
    public void savedNote() {

        Note newNote = new Note();
        newNote.setAnnotation("Вторая");
        newNote.setStatus(Status.NOT_STARTED);
        newNote.setTime("12:24");

        Note savedNote = repository.save(newNote);

        // then - verify the output
        assertThat(savedNote).isNotNull();
        assertThat(savedNote.getId()).isGreaterThan(0);
    }



    @DisplayName("JUnit тест получения всех записок")
    @Test
    public void findAll() {

        Note newNote = new Note();
        newNote.setAnnotation("Третья");
        newNote.setStatus(Status.NOT_STARTED);
        newNote.setTime("10:24");

        repository.save(newNote);
        repository.save(firstNote);


        List<Note> noteList = repository.findAll();


        assertThat(noteList).isNotNull();
        assertThat(noteList.size()).isEqualTo(2);

    }


    @DisplayName("JUnit тест получения записки по id")
    @Test
    public void findById() {

        repository.save(firstNote);


        Note noteInDB = repository.findById(firstNote.getId()).get();


        assertThat(noteInDB).isNotNull();
    }


    @DisplayName("JUnit тест обновление записки в базе данных")
    @Test
    public void updateNote() {

        repository.save(firstNote);

        // when -  action or the behaviour that we are going test
        Note updateNote = repository.findById(firstNote.getId()).get();
        updateNote.setAnnotation("Добавляем текст");
        updateNote.setStatus(Status.IN_PROGRESS);
        Note upNote = repository.save(updateNote);

        // then - verify the output
        assertThat(upNote.getAnnotation()).isEqualTo("Добавляем текст");
        assertThat(upNote.getStatus()).isEqualTo(Status.IN_PROGRESS);
    }


    @DisplayName("JUnit тест удаления записки")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee() {

        repository.save(firstNote);


        repository.deleteById(firstNote.getId());
        Optional<Note> listNotes = repository.findById(firstNote.getId());


        assertThat(listNotes).isEmpty();
    }
}


