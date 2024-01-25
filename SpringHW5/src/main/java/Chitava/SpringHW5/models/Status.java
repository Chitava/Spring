package Chitava.SpringHW5.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Класс статусов записок
 */
@AllArgsConstructor
public enum Status {
    //region поля
    NOT_STARTED ("не начата"),
    IN_PROGRESS ("в процессе выполнения"),
    COMPLETED ("завершена");
    private String status;
    //endregion
    @Override
    public String toString() {
        return String.format("Статус заявки - %s", status);
    }
    //endregion
}
