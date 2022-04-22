package Homework_6.Computer_Task;

public class HDD {
    private String name;
    private int volume;
    private Type type;

    protected enum Type {EXTERNAL, INTERNAL}

    public HDD() {
    }

    public HDD(String name, int volume, Type type) {
        this.name = name;
        this.volume = volume;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", volume=" + volume +
                ']';
    }

}
