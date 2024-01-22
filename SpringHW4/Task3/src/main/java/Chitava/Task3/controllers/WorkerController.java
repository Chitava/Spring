package Chitava.Task3.controllers;

import Chitava.Task3.domens.Worker;
import Chitava.Task3.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class WorkerController {
    /**
     *
     * Сервис работы с сотрудниками
     */
    @Autowired
    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    /**
     * Просмотр всех сотрудников
     * @param model
     * @return
     */
    @RequestMapping(value="/all", method= RequestMethod.GET)
    public String allWorkers(Model model){
        ArrayList<Worker> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);
        return "all";
    }

    /**
     * Запрос страницы добавления нового пользователя
     * @return
     */
    @RequestMapping(value="/add", method= RequestMethod.GET)
    public String addWorker(Model model) {
        model.addAttribute("worker", new Worker());
        return "add";
    }



    /**
     * Запрос страницы расчета зарплаты
     * @param
     * @return
     */
    @GetMapping("/salary")
    public String sallary(){
        return "salary";
    }

    /**
     * Добавление нового пользователя методом post
     * @param worker
     * @param model
     * @return
     */

    @RequestMapping(value="/addworker", method=RequestMethod.POST)
    public String addWorker(@ModelAttribute Worker worker, Model model) {
        workerService.addWorker(worker);
        ArrayList<Worker> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);
        return "all";
    }


    @GetMapping("/del")
    public String del(){
        return "del";
    }

    @RequestMapping(value="/delworker", method=RequestMethod.POST)
    public String delWorker(@ModelAttribute String workerName, Model model) {
        workerService.deleteWorker(workerName);
        ArrayList<Worker> workers = workerService.getAllWorkers();
        model.addAttribute("workers", workers);
        return "all";
    }


}
