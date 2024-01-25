package Chitava.SpringHW5.services;

import Chitava.SpringHW5.models.Status;
import com.sun.source.doctree.AttributeTree;
import jakarta.persistence.AttributeConverter;

/**
 * Класс конвертации статуса для храниеия в базе данных
 */
public class EnumConverter implements AttributeConverter <Status, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Status status) {
       switch (status){
            case NOT_STARTED:
                return 1;
            case IN_PROGRESS:
                return 2;
            case COMPLETED:
                return 3;
       }
        return null;
    }

    @Override
    public Status convertToEntityAttribute(Integer data) {
        switch (data){
            case 1:
                return Status.NOT_STARTED;
            case 2:
                return Status.IN_PROGRESS;
            case 3:
                return Status.COMPLETED;
        }
        return null;
    }
}
