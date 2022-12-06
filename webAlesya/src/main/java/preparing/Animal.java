package preparing;

public class Animal{

    protected String name;
    protected int age;

    public Animal(String name) {
        this.name = name;
    }

    public Animal(String name, int age){
        this(name);
        this.age = age;
    }

    public Long calc() {
        return null;
    }

    protected void eat() {
        System.out.println("animal eat");
    }
}
