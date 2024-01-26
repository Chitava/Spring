package Chitava.SpringHW5.models;
import Chitava.SpringHW5.services.EnumConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Класс записок
 */
@Data
@Entity
@NoArgsConstructor
@Table(name = "notes")
public class Noute {
    /**
     * Идентификатор
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    /**
     * Текст записки
     */
    private String annotation;

    /**
     * Статус записки, конвертация перечисления для хранения в базе данных
     */
    @Enumerated(EnumType.STRING)
    @Convert(converter = EnumConverter.class)
    private Status status = Status.NOT_STARTED;

    /**
     * Дата создания, при создании добавляем время создания записки
     */
    @Transient
    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern ("dd-MM-yyyy");

    private String time = dateFormat.format(LocalDateTime.now());



}
