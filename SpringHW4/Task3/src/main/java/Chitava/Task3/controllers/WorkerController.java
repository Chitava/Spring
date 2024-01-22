package Chitava.Task3.controllers;

import Chitava.Task3.domens.Worker;
import Chitava.Task3.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WorkerController {

    private final WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

//    @GetMapping("/")
//    public String start(Model model){
//        model.addAttribute("all", "all");
//
//        return "index.html";
//    }

    @GetMapping("/all")
    public String allWorkers(Model model){
        model.addAttribute("workers", workerService.getAllWorkers());
        return "all";
    }
    @GetMapping("/add")
    public String addUsers(Model model){
        return "add";
    }

    @GetMapping("/salary")
    public String sallary(Model model){
        return "salary";
    }

    @PostMapping("/addworker")
    public String addUser(@RequestBody Worker worker, Model model){
        workerService.addWorker(worker);
        model.addAttribute("workers", workerService.getAllWorkers());
        return "all";
    }

/**
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String findAll(Model model){
        List<User> users = userService.findAll();


        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }
*/

}
