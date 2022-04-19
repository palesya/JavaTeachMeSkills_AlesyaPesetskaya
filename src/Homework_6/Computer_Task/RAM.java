package Homework_6.Computer_Task;

public class RAM {
    private String name;
    private double volume;

    public RAM() {
    }

    public RAM(String name, double volume) {
        this.name = name;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ']';
    }
}


