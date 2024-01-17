import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Person persona1 = new Person("Смирнов", "Сергей", 23);
        Person persona2 = new Person("Петров", "Иван", 23);
        Person persona3 = new Person("Смирнов", "Сергей", 23);

        System.out.println(persona1);
        System.out.println(persona2);
        System.out.println(persona3);

        if(persona1.equals(persona2)){
            System.out.println("Вы выбрали одинаковых пользователей");
        }else {
            System.out.println("Вы выбрали разных пользователей");
        }
        if(persona1.equals(persona3)){
            System.out.println("Вы выбрали одинаковых пользователей");
        }else {
            System.out.println("Вы выбрали разных пользователей");
        }
        System.out.println(persona1.hashCode());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(persona1);
        System.out.println(json);
        Person deserializePerson = new Gson().fromJson(json, Person.class);
        System.out.println(deserializePerson);


    }
}