package Chitava.SpringHW6.service;

import Chitava.SpringHW6.model.Note;
import jakarta.persistence.Column;
import org.springframework.stereotype.Controller;

import java.util.Collection;


public interface Service {
    Collection<Note> getAllNote();

    Note getNoteById(Long id);

    Note updateNote(Note product);

    Note createNote(Note product);

    void deleteNote(Long id);
}
