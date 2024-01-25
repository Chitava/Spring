package Chitava.SpringHW5.models;
import Chitava.SpringHW5.services.EnumConverter;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

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
    String annotation;

    /**
     * Статус записки, конвертация перечисления для хранения в базе данных
     */
    @Enumerated(EnumType.ORDINAL)
    @Convert(converter = EnumConverter.class)
    Status status = Status.NOT_STARTED;

    /**
     * Дата создания, при создании добавляем время создания записки
     */
    LocalDateTime time = LocalDateTime.now();


}
