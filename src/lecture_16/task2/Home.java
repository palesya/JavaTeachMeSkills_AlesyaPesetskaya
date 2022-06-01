package lecture_16.task2;

public class Home {
    private int number;

    public Home(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Home{" +
                "number=" + number +
                '}';
    }
}
