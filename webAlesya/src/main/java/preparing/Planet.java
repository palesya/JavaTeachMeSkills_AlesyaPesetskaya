package preparing;

public class Planet {

    public String name;

    public long age;

    public int speed;

    public int area;

    public Planet(String name, long age, int speed, int area) {
        this.name = name;
        this.age = age;
        this.speed = speed;
        this.area = area;
    }

    public void printInformation() {
        System.out.println("Имя планеты: " + this.getName() + ".");
        System.out.println("Возраст: " + this.getAge() + " лет.");
        System.out.println("Орбитальная скорость: " + this.getSpeed() + " км/ч.");
        System.out.println("Общая площадь: " + this.getArea() + " кв. км.");
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
