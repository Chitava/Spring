package Chitava.Task2.controllers;

import Chitava.Task2.metods.Predict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Контроллер обработчика http запросов
 */
@Controller
public class TaskController {
    /**
     * Вызываем массив предсказаний
     */
    @Autowired
    Predict predicts;
    /**
     *
     * @return страницу с предсказанием
     */

    @RequestMapping("/predictions")
    public String prediction(Model model){
        String predict = String.valueOf(predicts.getPredicts().toString());
        model.addAttribute("predict", predict);
        return "predict";
    }
}
