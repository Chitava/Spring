package Chitava.Task3.repositorys;

import Chitava.Task3.domens.Worker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * Хранилище сотрудников
 */
@Repository
public class WorkersRepository {
    //region поля
    /**
     * Хранилище сотрудников
     */
    private ArrayList<Worker> workers = new ArrayList<>();
    //endregion

    //region конструкторы
    public WorkersRepository() {
    }
    //endregion

    //region getters setters
    public ArrayList<Worker> getWorkers() {
        return workers;
    }
    //endregion

    //region методы
    /**
     *
     * @param worker добавляемый сотрудник
     */
    public void addWorker(Worker worker) {
        workers.add(worker);
    }
    /**
     *
     * @param name Удаляемый сотрудник
     */
    public void deleteWorker(String name){
        for (Worker item: workers) {
            if (name.equals(item.getFirstName()))
                workers.remove(item);
        }
    }
    //endregion
}
