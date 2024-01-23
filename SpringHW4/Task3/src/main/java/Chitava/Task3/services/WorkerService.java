package Chitava.Task3.services;

import Chitava.Task3.domens.Worker;
import Chitava.Task3.repositorys.WorkersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Сервис обработки сотрудников
 */
@Service
public class WorkerService {
    //region поля
    /**
     * Хранилище сотрудников
     */
    @Autowired
    WorkersRepository repository;
    //endregion

    //region конструкторы
    public WorkerService(WorkersRepository repository) {
        this.repository = repository;
    }
    //endregion

    //region методы
    /**
     * Добавляем сотрудника
     * @param worker добавляемый сотрудник в хранилище
     */
    public void addWorker(Worker worker){
        repository.addWorker(worker);
    }

    /**
     * Получаем всех сотрудников
     *
     * @return список сотрудников
     */
    public Collection<Worker> getAllWorkers(){
        return repository.getWorkers();
    }

    public void deleteWorker (String name){
        repository.deleteWorker(name);
    }

}
