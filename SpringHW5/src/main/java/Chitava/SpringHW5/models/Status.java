package Chitava.SpringHW5.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Класс статусов записок
 */
@AllArgsConstructor
@Getter
public enum Status {
    //region поля
    NOT_STARTED ("не начата"),
    IN_PROGRESS ("в процессе выполнения"),
    COMPLETED ("завершена");
    private String status;
    //endregion

    /**
     * Переопределяем метод вывода статуса заявки
     * @return Статус заявки - не начата
     */
    //region переопределений
    @Override
    public String toString() {
        return String.format("Статус заявки - %s", status);
    }
    //endregion
}
