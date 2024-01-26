package Chitava.SpringHW5.services;

import Chitava.SpringHW5.models.Status;
import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

/**
 * Класс конвертации статуса для храниеия в базе данных
 */
@Service
public class EnumConverter implements AttributeConverter<Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
        if (status == null) {
            return null;
        }
        return status.toString();
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Status.values())
                .filter(c -> c.toString().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
