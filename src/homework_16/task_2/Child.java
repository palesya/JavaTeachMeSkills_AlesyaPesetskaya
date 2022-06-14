package homework_16.task_2;

public class Child {

    private String name;
    private Integer age;
    private SEX sex;

    enum SEX{
        MAN,
        WOMAN
    }

    public Child(String name, Integer age, SEX sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public SEX getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "{child " + name +
                ", age = " + age +", "+ sex.toString().toLowerCase()+"}";
    }
}
