package Chitava.Task1.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Класс записок
 * @param id идентификатор
 * @param header заголовок заметки
 * @param anotation тело заметки
 * @param time дата создания
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "worknotes")
public class WorkNote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column (nullable = false)
    String header;
    @Column (nullable = false)
    String anotation;
    LocalDateTime time = LocalDateTime.now();
}
