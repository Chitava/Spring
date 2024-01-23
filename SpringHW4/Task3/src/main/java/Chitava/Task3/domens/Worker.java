package Chitava.Task3.domens;

public class Worker {

    //region конструкторы
    /**
     *
     * @param firstName имя
     * @param secondName фамилия
     * @param phone телефон
     * @param salary ставка за сутки
     */
    public Worker(String firstName, String secondName, int phone, int salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.phone = phone;
        this.salary = salary;

    }

    public Worker() {
    }
    //endregion

    //region getters setters

    /**
     *
     * @return имя сотрудника
     */
    public String getFirstName() {
        return firstName;
    }
    /**
     *
     * @param firstName имя сотрудника
     */

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return фамилия сотрудника
     */

    public String getSecondName() {
        return secondName;
    }

    /**
     *
     * @param secondName фамилия сотрудника
     */
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    /**
     *
     * @return телефон сотрудника
     */

    public int getPhone() {
        return phone;
    }

    /**
     *
     * @param phone телефон сотрудника
     */
    public void setPhone(int phone) {
        this.phone = phone;
    }

    /**
     *
     * @return зарплата сотрудника в день
     */
    public int getSalary() {
        return salary;
    }

    /**
     *
     * @param salary зарплата сотрудника в день
     */

    public void setSalary(int salary) {
        this.salary = salary;
    }

    /**
     *
     * @return количество отработанных дней
     */

    public int getWorkDays() {
        return workDays;
    }

    /**
     *
     * @param workDays количество отработанных дней
     */

    public void setWorkDays(int workDays) {
        this.workDays = workDays;
    }

    public int getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(int monthSalary) {
        this.monthSalary = monthSalary;
    }

    //region поля
    /**
     * класс сотрудник
     * поля
     * Имя
     * Фамилия
     * телефон
     * Зарплата в день
     * количество отработанных дней
     * зарплата за месяц
     */
    private String firstName;
    private String secondName;
    private int phone;
    private int salary;
    private int workDays;
    private int monthSalary;

    @Override
    public String toString() {
        return "Worker{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", salary=" + salary +
                '}';
    }
    //endregion

}
