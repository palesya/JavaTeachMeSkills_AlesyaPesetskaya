package homework_12.task_1;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private Sex sex;
    private int age;

    public User() {
    }

    public User(String name, Sex sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name = " + name +
                ", sex = " + sex.toString().toLowerCase() +
                ", age = " + age +
                '}';
    }
}
