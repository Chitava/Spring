package Chitava.Task2.metods;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Сервис с предсказаниями
 */
@Service
public class Predict {

    //region конструкторы
    public Predict() {
    }
    //endregion

    //region getters
    /**
     * метод получения предсказания
     * @return случайное предсказание
     */
    public String getPredicts() {
        int rnd = new Random().nextInt(0,4);
        System.out.println(predicts.get(rnd));
        return predicts.get(rnd);
    }
    //endregion

    //region поля
    /**
     * Массив со случайными предсказаниями
     */
    private List<String> predicts = Arrays.asList("да", "возможно", "сомневаюсь", "ни в коем случае");
    //endregion
}
