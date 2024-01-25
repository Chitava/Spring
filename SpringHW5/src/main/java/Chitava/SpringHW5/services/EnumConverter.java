package Chitava.SpringHW5.services;

import Chitava.SpringHW5.models.Status;
import com.sun.source.doctree.AttributeTree;
import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Класс конвертации статуса для храниеия в базе данных
 */
@Service
public class EnumConverter implements AttributeConverter <Status, String> {
    @Override
    public String convertToDatabaseColumn(Status status) {
       switch (status){
            case NOT_STARTED:
                return "не начата";
            case IN_PROGRESS:
                return "в процессе выполнения";
            case COMPLETED:
                return "завершена";
       }
        return null;
    }

    @Override
    public Status convertToEntityAttribute(String data) {
        switch (data){
            case "не начата":
                return Status.NOT_STARTED;
            case "в процессе выполнения":
                return Status.IN_PROGRESS;
            case "завершена":
                return Status.COMPLETED;
        }
        return null;
    }
}
