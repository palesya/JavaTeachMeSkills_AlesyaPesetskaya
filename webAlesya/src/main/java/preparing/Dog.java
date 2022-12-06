package preparing;

public class Dog extends Animal implements Cloneable, Printer{

    private int age;
    private static final String stStr;
    public Tail tail = new Tail();

    public Dog(String name, int age) {
        super(name);
        this.age = age;
    }

    public Dog(String name) {
        super(name);
    }

    static {
        stStr="new";
    }

    {
        super.name = "Oops";
        age = 90;
    }

    public void thisEat() {
        System.out.println("Call Dog.eat()");
        this.eat();
    }

    public void superEat() {
        System.out.println("Call Animal.eat()");
        Tail dog1 = new Tail();
        dog1.burke();
        super.eat();
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    void my_Method() {
        int num = 23;
        class MethodInner_Demo {
            public void print() {
                System.out.println("This is method inner class "+num);
            }
        }
        MethodInner_Demo inner = new MethodInner_Demo();
        inner.print();
    }

    @Override
    public Dog clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (Dog) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public class Tail {
        public void burke(){
            System.out.println("Very fast");
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Tail getTail() {
        return tail;
    }

    public void setTail(Tail tail) {
        this.tail = tail;
    }

    public static class Fly{
        public void sayHello(){
            System.out.println("Say hello, Fly");
        }
    }
}
