package ru.chitava.webclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

import java.util.Collection;

/**
 * Класс студент
 * поле id  идентификатор студента
 * поле name имя студента
 * поле groupe номер группы студента
 * поле averageScore средний бал успеваимости
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    Long id;
    String name;
    String groupe;
    Double averageScore;


}
