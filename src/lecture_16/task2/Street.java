package lecture_16.task2;

public class Street {
    private String name;
    private Home home;

    public Street(String name, Home home) {
        this.name = name;
        this.home = home;
    }

    public String getName() {
        return name;
    }

    public Home getHome() {
        return home;
    }

    @Override
    public String toString() {
        return "Street{" +
                "name='" + name + '\'' +
                ", home=" + home +
                '}';
    }
}
