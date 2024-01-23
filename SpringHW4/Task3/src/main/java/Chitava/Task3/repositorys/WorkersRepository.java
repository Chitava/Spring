package Chitava.Task3.repositorys;

import Chitava.Task3.domens.Worker;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * Хранилище сотрудников
 */
@Repository
public class WorkersRepository {
    //region поля
    /**
     * Хранилище сотрудников
     */
    private Collection<Worker> workers = new ArrayList<>();
    //endregion

    //region конструкторы

    public WorkersRepository() {
    }
    //endregion

    //region getters setters
    public Collection<Worker> getWorkers() {
        return workers;
    }
    //endregion

    //region методы

    /**
     * @param worker добавляемый сотрудник
     */
    public void addWorker(Worker worker) {
        workers.add(worker);
    }

    /**
     * @param name Удаляемый сотрудник
     */
    public void deleteWorker(String name) {

        workers.removeIf(x -> x.getFirstName().equals(name));

    }

    /**
     * Поиск сотрудника
     * @param name имя сотрудника
     * @return сотрудник
     */
    public Worker getWorker(String name) {
        Worker worker = null;
        Optional findWorker = workers.stream().filter(w -> w.getFirstName().equals(name)).findFirst();
        if (findWorker.isPresent()) {
            worker = (Worker) findWorker.get();
        }
        return worker;
    }
    //endregion
}
