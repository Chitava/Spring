import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Person {

    //region Конструкторы
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    //endregion


    //region методы переопределения
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (!(o instanceof Person person)) return false;

        return new EqualsBuilder().append(age, person.age).append(firstName, person.firstName)
                .append(lastName, person.lastName).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(firstName).append(lastName)
                .append(age).toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("Фамилия", firstName)
                .append("Имя", lastName)
                .append("возраст", age)
                .toString();
    }

    //endregion

    //region поля
    String firstName;
    String lastName;
    int age;
    //endregion

    //region getters setters
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    //endregion




}
