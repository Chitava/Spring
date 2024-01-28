package Chitava.SpringHW5.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;

/**
 * Класс статусов записок
 */
@AllArgsConstructor

public enum Status {
    //region поля
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED,
//    private String status;
//    //endregion
//    @Override
//    public String toString() {
//        return status;
//    }

}
